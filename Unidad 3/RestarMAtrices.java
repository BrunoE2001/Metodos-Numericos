public class RestarMAtrices {
    float[][] restarMatriz(float a[][],float b[][]){
        int f1,f2,c1,c2;
        f1 = a.length;
        f2 = b.length;
        c1 = a[0].length;
        c2 = b[0].length;

        float resultado[][] = new float[f1][c2];
        float lu[][] = resultado;
        if (f1!=f2 && c1!=c2) {
            System.out.println("No se puede realizar la operacion solicitada");
            System.out.println("Las matrices deben ser cuadradas");
        } else {
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[0].length;j++){
                    resultado[i][j]=a[i][j]-b[i][j];
                }
            }
            lu = resultado;
        }
        return lu;
    }
}
