public class ObtenerPseudoinversa {
    /**
     * A+ = (AtA)−1At
     * @param valx
     * @return
     */
    Matriztranspuesta mt = new Matriztranspuesta();
    MultiplicarMatriz mm = new MultiplicarMatriz();
    matrizInversa mi = new matrizInversa();
    
    float [][] calcularPseudoinversa(float [][]valx){
        float [][]matrix = valx;
        float [][] transpuestaA = new float[valx[0].length][valx.length];
        float [][] AtA = new float[transpuestaA.length][valx.length];
        float [][] invAtA = new float[AtA.length][AtA[0].length];
        float [][] pseudoinversa;

        /**Imprimir matrices */
        transpuestaA = mt.mTranspuesta(matrix);
        imprimir(transpuestaA, "transpuesta");
        AtA = mm.multiplicaMatrix(transpuestaA, matrix);
        imprimir(AtA, "Matriz A * A^T");
        invAtA = mi.metodoprincipal(AtA);
        imprimir(invAtA, "(A^T)-1 A^T");
        pseudoinversa = mm.multiplicaMatrix(invAtA,transpuestaA);

        return pseudoinversa;
    }
    static void imprimir(float [][]matriz,String mensaje){
        System.out.println("\n"+mensaje);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }System.out.println();
        }
    }
}
