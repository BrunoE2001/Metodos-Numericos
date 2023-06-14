package regladeltrapecio;
import java.util.Scanner;

public class ReglaDelTrapecio {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double a, b;
        int n;
        Scanner sc=new Scanner(System.in);
        System.out.println("------------ Regla del trapecio ------------");
        System.out.println("f(x): exp^(x^2)");
        System.out.println("Ingrese el limite inferior: ");
        a = sc.nextDouble();
        System.out.println("Ingrese el limite superior: ");
        b = sc.nextDouble();
        System.out.println("Ingresa la cantidad de intervalos: ");
        n = sc.nextInt();     
        System.out.println("Resultado: " + Trapecio(a,b,n));
    }
    
    public static double funcion (double x){
        return Math.exp(Math.pow(x,2));   
    }
    
    public static double Trapecio(double a, double b, int n){
        double h=(b-a)/n;
        double resultado=0;
        
        for(int k = 1; k < n; k++) {
            resultado += funcion(a + k * h);
        }       
        resultado +=(funcion(a)+funcion(b))/2;
        resultado *=h;
        return resultado;
    }
}

