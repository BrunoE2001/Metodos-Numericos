class sumarMatrices {
    float[][] sumarMatriz(float a[][],float b[][]){
		int f1,f2,c1,c2;
        f1 = a.length;
        c1 = a[0].length;
        
        f2 = b.length;
        c2 = b[0].length;

        float resultado[][] = new float[f1][c2];
        float resul[][] = resultado;

        if (f1!=f2 && c1!=c2) {
            System.out.println("No se puede realizar la operacion solicitada");
            System.out.println("Las matrices deben ser cuadradas");
        } else {
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[0].length;j++){
                    resultado[i][j]=a[i][j]+b[i][j];
                }
            }
            resul = resultado;
        }
        return resul;
    }
}
