package regla3.pkg8simpson;
import java.util.Scanner;

public class Regla38Simpson {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a, b;
        int n;    
        Scanner sc=new Scanner(System.in);
        System.out.println("------------ Regla de 3/8 de Simpson ------------");
        System.out.println("f(x): x^3/(1+x^(1/2))");
        System.out.println("Ingrese el limite inferior: ");
        a = sc.nextDouble();
        System.out.println("Ingrese el limite superior: ");
        b = sc.nextDouble();
        System.out.println("Ingresa la cantidad de intervalos: ");
        n = sc.nextInt();
        System.out.println("Resultado: " + regla38simpson(a,b,n));
    }
    
    public static double regla38simpson (double a, double b, double n){
    double h = (b - a) / n;
    double sum = f(a) + f(b);

    for (int i = 1 ; i < n ; i++){
    	double k = a + i*h;
        if (i%3==0){
                sum = (sum+2*f(k));              
            }else{
                sum = (sum+3*f(k)); 
            }
        }
        return (h * 3/8) * sum;
    }
    
    private static double f(double x){
        return Math.pow(x,3)/(1+Math.pow(x,(1/2)));
    }
}

