import java.util.Scanner;

public class MetodoReglaFalsa{
    void main(){
        Scanner sc = new Scanner(System.in);
        Funcion f=new Funcion(){
            @Override
            public double evaluacion(double x){
                return Math.cos(x)*x;
            }
        };
        ReglaFalsa rf = new ReglaFalsa();
        System.out.println("Ingrese el numero inferior del intervalo");
            double a = sc.nextDouble();
        System.out.println("Ingrese el numero superior del intervalo");
            double b = sc.nextDouble();
        System.out.println("Ingrese el numero de iteraciones");
            int i = sc.nextInt();
        System.out.println("Ingrese la tolerancia");
            double err = sc.nextDouble();
        double raiz = rf.raiz(f, a, b, i, err);
        //double raiz = rf.raiz(f, 1, 3, 10, 1e-6);
        System.out.println("Raíz: "+ raiz);
        System.out.println("Iteraciones \n" + rf.getIter());
        Menu.menu();
    }
}