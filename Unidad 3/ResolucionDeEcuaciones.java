import java.math.*;
import java.util.Scanner;

public class ResolucionDeEcuaciones {
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        ResolucionDeEcuaciones rde = new ResolucionDeEcuaciones();
        matrizInversa mi = new matrizInversa();
        RestarMAtrices rm = new RestarMAtrices();
        sumarMatrices sm = new sumarMatrices();
        MultiplicarMatriz mm = new MultiplicarMatriz();

        int opc=0,Noiter=0;
        float tol=0;
        // Se inicializan los vectores
        float SisEcuaciones[][];
        float ecuaciones[][];
        float coeficiente[][];
        float VectorInicio[][];
        float matrizdiagonal[][];
        float menosinversadiagonal[][];
        float LU[][];
        float inversadiagonal[][];
        float LUX[][];
        float menosDLU[][];
        float Db[][];
        float menosDLUXmasDb[][];
        float vold[][];
        float vectorerror[][];
        
        System.out.println("\t--- Systemas de ecuaciones---\n");
        System.out.println("cuantas ecuaciones tiene su sistema");
        int NoEcuaciones = sc.nextInt();
        int f = NoEcuaciones+1;
        System.out.println("\nPerfecto, Debe ingresar solo los coeficientes de sistema de ecuaciones\nel sistema agrega variables por defecto");
        //Se definen los tamaños de las matrices
        SisEcuaciones = new float[NoEcuaciones][f];
        ecuaciones = new float[NoEcuaciones][NoEcuaciones];
        coeficiente = new float[NoEcuaciones][1];
        vold = new float[NoEcuaciones][1];
        vectorerror = new float[NoEcuaciones][1];
        VectorInicio = new float[NoEcuaciones][1];
        matrizdiagonal = new float[NoEcuaciones][NoEcuaciones];
        menosinversadiagonal = new float[NoEcuaciones][NoEcuaciones];
        inversadiagonal = new float[NoEcuaciones][NoEcuaciones];
        LU = new float[NoEcuaciones][NoEcuaciones];
        LUX = new float[NoEcuaciones][NoEcuaciones];
        menosDLU = new float[NoEcuaciones][NoEcuaciones];
        menosDLUXmasDb = new float[NoEcuaciones][NoEcuaciones];

        // Se ingresan los datos a las matrices y vectores
        CrearMatriz CM = new CrearMatriz();
        SisEcuaciones = CM.crearMatriz(NoEcuaciones,f);
        System.out.println("\nProporcione el vector Inicio");
        VectorInicio = CM.crearMatriz(NoEcuaciones,1);
        // Metodo de parada
        System.out.println("\nElija el metodo por el cual quiere parar");
        opc = rde.menuRDE();
        if(opc != 1 && opc != 2){
            System.out.println("Por favor elija una opcion valida");
            opc = rde.menuRDE();
        }
        if (opc == 1) {
            System.out.println("\n\nIngrese el numero de iteraciones");
            Noiter = sc.nextInt();
        }
        if (opc == 2){
            System.out.println("\nIngrese la tolerancia");
            tol = sc.nextFloat();
        }
        coeficiente = rde.devolverCoeficientes(SisEcuaciones);
        SisEcuaciones = rde.devolverMatrizDominante(SisEcuaciones,coeficiente,NoEcuaciones);
        ecuaciones = rde.devolverEcuaciones(SisEcuaciones);
        coeficiente = rde.devolverCoeficientes(SisEcuaciones);
        matrizdiagonal = rde.devolverdPrincipal(ecuaciones);
        menosinversadiagonal = rde.mid(menosinversadiagonal);

        // Se procede a obtener lo siguiente
        // -D^-1(L+U)x + D^-1b
        inversadiagonal = mi.metodoprincipal(matrizdiagonal);
        menosinversadiagonal = mm.multiplicaMatrix(menosinversadiagonal, inversadiagonal);
        LU = rm.restarMatriz(ecuaciones, matrizdiagonal);
        //LUX = mm.multiplicaMatrix(LU, ecuaciones);
        menosDLU = mm.multiplicaMatrix(menosinversadiagonal, LU);//M
        Db = mm.multiplicaMatrix(inversadiagonal, coeficiente);// c
        //Db = rde.verificartamano(Db,menosDLU);
        //menosDLUXmasDb= sm.sumarMatriz(menosDLU,Db);
        
        // Se imprimen matrices y vectores
        rde.impPt(SisEcuaciones);
        rde.impMatrix(ecuaciones, "Matrix del sitema");
        rde.impVector(coeficiente,"Vector de coeficientes");
        rde.impVector(VectorInicio,"Vector de Inicio");
        rde.impMatrix(matrizdiagonal, "Matriz diagonal principal");
        rde.impInv(menosinversadiagonal, "Matriz -D^-1");
        rde.impInv(inversadiagonal, "Inversa de la diagonal");
        rde.impMatrix(LU, "Matriz (L+U)");
        //rde.impMatrix(LUX, "Matriz (L+U)x");
        rde.impMatrix(menosDLU, "Matriz -D^-1(L+U)x");
        rde.impMatrix(Db, "Matriz D^-1b");
        //rde.impMatrix(menosDLUXmasDb, "Matriz -D^-1(L+U)x+Db");
        
        /**
         * Se realiza el calculo de las ecuaciones con el metodo correspondiente
         * if 1 = numero de iteraciones
         * if 2 = por calculo de error
         */
        if (opc == 1) {
            for (int i = 0; i < Noiter; i++) {
                menosDLUXmasDb = mm.multiplicaMatrix(menosDLU, VectorInicio);
                VectorInicio = sm.sumarMatriz(Db, menosDLUXmasDb);
            }
            rde.imprimirSolucionesdelsistema(VectorInicio,"Soluciones para cada incognita");
        } 
        if (opc == 2){
            boolean bandera = true;
            int contador = 0,co=0;
            float error=100;
            while (error > tol) {
                vold = VectorInicio;

                menosDLUXmasDb = mm.multiplicaMatrix(menosDLU, VectorInicio);
                VectorInicio = sm.sumarMatriz(Db, menosDLUXmasDb);

                error = rde.calcularerror(VectorInicio, vold);
                /*for (int i = 0; i < vectorerror.length; i++) {
                    for (int j = 0; j < vectorerror[0].length; j++) {
                        if (vectorerror[i][j] > tol) {
                            co++;
                        }
                    }
                }

                if (co==1 || co==vectorerror.length) {
                    bandera = true;
                    System.out.println("entro if");
                }if (co == 0){
                    System.out.println("entro else");
                    bandera = false;
                }
                co=0;*/
                contador++;
            }
            System.out.println("Las soluciones se encontraron en: NoIteracion "+contador);
            rde.imprimirSolucionesdelsistema(VectorInicio,"Soluciones para cada incognita");
            System.out.println("El error total de: "+error);
        }
    }// Aqui termina el main

    void imprimirSolucionesdelsistema(float [][] VectorInicio,String mensaje){
        System.out.println("\n\n"+mensaje+"\n");
        for (int i = 0; i < VectorInicio.length; i++) {
            for (int j = 0; j < VectorInicio[0].length; j++) {
                System.out.println("X"+(i+1)+" => " + VectorInicio[i][j]);
            }
        }
    }

    float calcularerror(float [][] vnew, float[][] vold){
        float error=0;
        float sumat=0,suma=0,potencia=0,raiz=0;
        for (int i = 0; i < vnew.length; i++) {
            for (int j = 0; j < vnew[0].length; j++) {
                suma = vnew[i][j] - vold[i][j];
                potencia = suma * suma;
                sumat += potencia;
            }
        }
        raiz = (float)Math.sqrt(sumat);
        error = raiz;
        sumat=0;
        return error;
    }

    void impPt (float matriz[][]){
        System.out.println("\nSistema de ecuacion a resolver");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length-1; j++) {
                System.out.print((int)matriz[i][j]+"x"+(j+1)+" ");
            }
            for (int k = matriz[0].length-1; k < matriz[0].length; k++) {
                System.out.print(" = "+(int)matriz[i][k]);
            }
            System.out.println();
        }
    }

    void impVector (float matriz[][], String mensaje){
        System.out.print("\n"+mensaje+"\n");
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("["+(int)matriz[i][j]+"]");
            }
        }
        System.out.println();
    }

    void impMatrix(float matriz[][], String mensaje){
        System.out.print("\n"+mensaje+"\n");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    void impInv(float matriz[][], String mensaje){
        System.out.print("\n"+mensaje+"\n");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("]");
        }
    }

    int menuRDE(){
        Scanner sc = new Scanner(System.in);
        String menu = "1. Cantidad de iteraciones\n"
        + "2. Tolerancia\n";
        System.out.println(menu);
        int opc = sc.nextInt();
        
        return opc;
    }

    float[][] devolverCoeficientes(float matrix[][]){
        float matcoef[][] = new float [matrix[0].length-1][1];
        int f = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((f == i) && (j == matrix[0].length-1)) {
                    matcoef[f][0] = matrix[i][j];
                }
            }
            f += 1;
        }
        return matcoef;
    }

    float[][] devolverEcuaciones(float matrix[][]){
        float matcoef[][] = new float [matrix.length][matrix[0].length-1];
        int f=0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if ((f == i) && (j != matrix[0].length-1)) {
                    matcoef[i][j] = matrix[i][j];
                }
            }
            f += 1;
        }
        return matcoef;
    }
    float[][] devolverdPrincipal(float matrix[][]){
        float diagonal [][] = new float[matrix.length][matrix[0].length];
        for (int f = 0; f < matrix.length; f++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if(f==c){
                    diagonal[f][c] = matrix[f][c];
                }
            }
        }
        return diagonal;
    }

    float[][] mid(float matrix[][]){ //crea una matriz con la diagonal principal de unos negativa
        float m [][] = new float[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(i==j){m[i][j] = -1;}
                else{ m[i][j] = 0;}
            }
        }
        return m;
    }

    float[][] verificartamano(float matrix[][],float matriz[][]){
        float igualar [][] = new float[matriz.length][matriz[0].length];
        for (int i = 0; i < matriz.length; i++) {
            for(int j = 0; j<matriz[0].length; j++){
                igualar[i][j] = 0;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                igualar[i][j] = matrix[i][j];
            }
        }
        return igualar;
    }

    float[][] devolverMatrizDominante(float matrix[][],float[][] resultados, int noecua){
        float matrixDominante [][] = new float[matrix.length][matrix[0].length];
        int noecuaciones = noecua;
        float [][]resultado = resultados;
        matrixDominante = matrix;
        int cont=0,suma=0,suma2=0;
        for (int i = 0; i < matrixDominante.length; i++){
            float pivote = 0;
            for (int j = 0; j < matrixDominante.length; j++){
                if (i==j){
                    pivote = matrix[i][j];
                }else{
                    suma += Math.abs(matrix[i][j]);
                    suma2 += Math.abs(matrix[j][i]);
                }
            }
            if (pivote >= suma && pivote >= suma2){
                cont++;
            }
        }
        if (cont >= matrix.length-1) {
            System.out.println("Ya es una Matriz dominante");
        }else{
            matrizdiagonalDominante mdd = new matrizdiagonalDominante();
            matrixDominante = mdd.MatrizDominante(matrix,resultado,noecuaciones);
        }
        return matrixDominante;
    }
}