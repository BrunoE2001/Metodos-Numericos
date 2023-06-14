class MultiplicarMatriz {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    float[][] multiplicaMatrix(float a[][],float b[][]){
        int f1,f2,c1,c2;
        f1 = a.length;
        c1 = a[0].length;
        
        f2 = b.length;
        c2 = b[0].length;

        float [][]resultado = new float[f1][c2];
        float mult[][] = resultado;

        if (c1 != f2){
            System.out.println(ANSI_RED + "Upps! Matrices con tamaño diferente\n(╯°□°）╯No se puede hacer la multiplicacion" + ANSI_RESET);
        }else{
            for (int i=0; i<resultado.length; i++){
                for (int j=0; j<resultado[0].length; j++){
                    float var=0;
                    for(int k=0;k<c1;k++){
                        var=var+a[i][k]*b[k][j];
                    }
                    resultado[i][j]=var;
                }
            }
            mult = resultado;
        }
        return mult;
    }
}
