package regla1.pkg3simpson;
import java.util.*;

public class Regla13Simpson {
    private static double a = 0, b = 0, n = 0, h = 0;
    private static double[] eva;
    private static int i = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("------------ Regla de 1/3 de Simpson ------------");
        System.out.println("Función:  exp(x^2)");
        System.out.println("Ingresa el límite inferior: ");
        a = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println("Ingresa el límite superior: ");
        b = Double.parseDouble(new Scanner(System.in).nextLine());
        System.out.println("Ingresa el número de intervalos: ");
        n = Double.parseDouble(new Scanner(System.in).nextLine());
        h = (b - a) / n;
        h = h / 2;

        eva = new double[(int)n * 2 + 1];
        i = 0;
            while (i < eva.length){
                if (i == 0){
                    eva[i] = a;
                }else if (i == eva.length - 1){
                    eva[i] = b;
                }else{
                    eva[i] = eva[i - 1] + h;
                }
                i++;
            }
            System.out.println("Resultado: " + Simpson1());
	}

	private static double Simpson1(){
            double sum1 = 0, sum2 = 0, resultado = 0;
            int com = 0;
            i = 1;
            while (i < eva.length){
                com = i % 2;
                if (com == 0){
                    sum2 = (sum2 + Funcion(eva[i]));
                }else{
                    sum1 = (sum1 + Funcion(eva[i]));
                }if (i == eva.length - 2){
                        i = eva.length;
                }
                i++;
            }
            resultado = ((b - a) * (Funcion(eva[0]) + (4 * sum1) + (2 * sum2) + Funcion(eva[eva.length - 1])));
            resultado = (resultado / (6 * n));
            return resultado;
	}

	private static double Funcion(double x){
            double resultado = 0;
            resultado =  (double) Math.exp(Math.pow(x,2));     
            return resultado;
	}
}

