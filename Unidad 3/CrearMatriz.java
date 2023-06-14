import java.util.Scanner;

class CrearMatriz{
    float[][] crearMatriz(int filas, int columnas){
        Scanner sc = new Scanner(System.in);
        int f,c;
        float a[][] = new float[filas][columnas];
        System.out.println("Ingrese los datos");
        for(f=0; f<a.length; f++){
            for(c=0; c<a[0].length; c++){
                a[f][c] = sc.nextFloat();
            }
        }
        return a;
    }
}