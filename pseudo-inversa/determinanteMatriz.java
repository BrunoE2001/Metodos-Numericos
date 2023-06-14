public class determinanteMatriz{
        public static float detMatriz(float matriz[][], int n_prueba) {
            float repuesta = 0;
            switch (n_prueba) {
                case 2:
                    repuesta = ((matriz[0][0] * matriz[1][1]) - (matriz[1][0] * matriz[0][1]));
                    break;
                case 3:
                    repuesta = ((matriz[0][0]) * (matriz[1][1]) * (matriz[2][2])
                            + (matriz[1][0]) * (matriz[2][1]) * (matriz[0][2])
                            + (matriz[2][0]) * (matriz[0][1]) * (matriz[1][2]))
                            - ((matriz[2][0]) * (matriz[1][1]) * (matriz[0][2])
                            + (matriz[1][0]) * (matriz[0][1]) * (matriz[2][2])
                            + (matriz[0][0]) * (matriz[2][1]) * (matriz[1][2]));
                    break;
                default:
                    for (int z = 0; z < matriz.length; z++) {
                        repuesta += (matriz[z][0] * adj(matriz, z, 0));
                    }
            }
            return repuesta;
        }
    
        public static float adj(float matriz[][], int i, int j) {
            float adjunto;
            float matriz1[][] = new float[matriz.length - 1][matriz.length - 1];
            int m, n;
            for (int k = 0; k < matriz1.length; k++) {
                if (k < i) {
                    m = k;
                } else {
                    m = k + 1;
                }
                for (int l = 0; l < matriz1.length; l++) {
                    if (l < j) {
                        n = l;
                    } else {
                        n = l + 1;
                    }
                    matriz1[k][l] = matriz[m][n];
                }
            }
            adjunto = (float)Math.pow(-1, i + j) * detMatriz(matriz1, matriz1.length);
            return adjunto;
        }
    
        float llamar(float matriz[][],int tam){
            float matriz_prueba[][] = matriz;
            int n_prueba = tam;
            float determinante = detMatriz(matriz_prueba, n_prueba);
            
            return determinante;
        }
}