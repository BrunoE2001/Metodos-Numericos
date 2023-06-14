import java.math.*;

public class matrizdiagonalDominante {

    float[][] MatrizDominante (float [][]matrizcoeficientes,float[][] vectorcoef , int numeroEcuaciones){
        float matriscoef[][] = matrizcoeficientes;
        float [][]vectorcoefi = vectorcoef;
        int numecua = numeroEcuaciones;

        matriscoef = CambiarFilas(matriscoef,vectorcoefi, numecua); // cambiar filas
        boolean resultado = false;
        int contador = 0;
        float sumaValoresFila;
        float valoresDiagonal;
        for (int i = 0; i < numeroEcuaciones; i++){
            sumaValoresFila=0;
            valoresDiagonal =0;
            for (int j = 0; j < numeroEcuaciones; j++){
                if (i != j)
                    sumaValoresFila += Math.abs(matriscoef[i][j]);
                else{
                    valoresDiagonal = Math.abs(matriscoef[i][j]);
                }
            }

            if (valoresDiagonal >= sumaValoresFila){
                contador++;
            }

            sumaValoresFila = 0;
        }


        if (contador == numecua){
            resultado = true;
            System.out.println("matriz dominante");
        }else{
            resultado = false;
            System.out.println("No se pudo convertir en matriz dominante");
        }

        return matriscoef;
    }

    static float[][] CambiarFilas (float [][]matris,float[][] vecctorcoeficients, int numeroEcuacion) {
        float [][]matriz = matris;
        int numeroEcuaciones = numeroEcuacion;
        float auxiliarMatriz;
        int i, j=0;
        float auxiliarVector;
        float [][] vectorDeResultados = vecctorcoeficients;

        for (i = 0; i < numeroEcuaciones; i++){
            auxiliarMatriz=0;
            i=i;j=j;
            auxiliarVector=0;
            //vectorDeResultados;
            float valorMaximo = Math.abs(matriz[i][i]);
            int columnaDelValorMaximo = i;
            for (j = 0; j < numeroEcuaciones; j++){
                if (valorMaximo < Math.abs(matriz[i][j])){
                    valorMaximo = Math.abs(matriz[i][j]);
                    columnaDelValorMaximo = j;
                }   
            }

            if(i != columnaDelValorMaximo){
                for(int m=0; m < numeroEcuaciones; m++){
                    auxiliarMatriz = matriz[i][m];
                    matriz[i][m] = matriz[columnaDelValorMaximo][m];
                    matriz[columnaDelValorMaximo][m] = auxiliarMatriz;
                }
            }

            if (i != columnaDelValorMaximo){
                for (int n = 0; n < numeroEcuaciones; n++){
                    auxiliarVector = vectorDeResultados[i][0];
                    vectorDeResultados[i][0] = vectorDeResultados[columnaDelValorMaximo][0];
                    vectorDeResultados[columnaDelValorMaximo][0] = auxiliarVector;
                }
            }
        }
        for (int k = 0; k < matriz.length; k++) {
            for (int k2 = 0; k2 < matriz[0].length; k2++) {
                if (k2 == vectorDeResultados.length) {
                    matriz[k][k2] = vectorDeResultados[k][0];
                }
            }
        }
        return matriz;
    }
}