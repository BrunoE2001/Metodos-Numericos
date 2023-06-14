import java.util.Scanner;

class matrizInversa {
    float[][] metodoprincipal(float matriz[][]){
        determinanteMatriz DM = new determinanteMatriz();
        float a[][] = matriz;
        int n = matriz.length;

        float det = DM.llamar(a,n);
        
        float inv[][] = new float[matriz.length][matriz[0].length];
        float d[][] = inv;
        
        if (det != 0) { //Determinar si la matriz tiene inversa
            inv = calcularinversa(a);
            d=inv;
        }else{
            System.out.println("Det[A] => "+det);
            System.out.println("Es una matriz singular por lo tanto no tiene inversa");
        }
        return d;
    }


    public static float[][] calcularinversa(float a[][]){

        int n = a.length;
        float x[][] = new float[n][n];
        float b[][] = new float[n][n];
        int index[] = new int[n];
        for (int i=0; i<n; ++i){
            b[i][i] = 1;
        }
        // Matriz superior

        MetododeGauss(a, index);

        // Se Actualiza la matriz b [i] [j]
        for (int i=0; i<n-1; ++i){
            for (int j=i+1; j<n; ++j){
                for (int k=0; k<n; ++k){
                    b[index[j]][k] -= a[index[j]][i]*b[index[i]][k];
                }
            }
        }

        // se empieza a sustituir
        for (int i=0; i<n; ++i){
            x[n-1][i] = b[index[n-1]][i]/a[index[n-1]][n-1];
            for (int j=n-2; j>=0; --j){
                x[j][i] = b[index[j]][i];
                for (int k=j+1; k<n; ++k){
                    x[j][i] -= a[index[j]][k]*x[k][i];
                }
                x[j][i] /= a[index[j]][j];
            }
        }
        return x;
    }

    // Metodo Metodo Gaussiano

    public static void MetododeGauss(float a[][], int index[])  {
        int n = index.length;
        float c[] = new float[n];

        // Se inicializa el pivote
        for (int i=0; i<n; ++i)
            index[i] = i;

        // Busca las posiciones donde se deben cambiar de cada fila
        for (int i=0; i<n; ++i) {
            float c1 = 0;
            for (int j=0; j<n; ++j) {
                float c0 = Math.abs(a[i][j]);
                if (c0 > c1) c1 = c0;
            }
            c[i] = c1;
        }

        // Se busca el pivote en cada columna
        int k = 0;
        for (int j=0; j<n-1; ++j) {
            float pi1 = 0;
            for (int i=j; i<n; ++i)  {
                float pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }
            // Se realiza el intercambio de filas
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i=j+1; i<n; ++i) {
                float pj = a[index[i]][j]/a[index[j]][j];
                a[index[i]][j] = pj;
                for (int l=j+1; l<n; ++l)
                    a[index[i]][l] -= pj*a[index[j]][l];
            }
        }
    }
}
