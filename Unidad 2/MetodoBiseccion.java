import java.util.Scanner;
import java.lang.Math;

class MetodoBiseccion {
    void Menu(){

        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double xmin = 4, xmax = 6, tolerancia = 0.1;
        boolean bandera = true;

        while (bandera){
            System.out.println("\n------------------ M E N U ------------------");
            System.out.println("1.- Ingresar datos.");
            System.out.println("2.- f(x) = exp(x)*cos(x)-(x)*sin(x)");
            System.out.println("3.- Salir.");

            System.out.println("Seleccione una opcion: ");
            opcion = sc.nextInt();

            if (opcion == 1){
                System.out.println("Ingresar el limite inferior: ");
                xmin = sc.nextDouble();

                System.out.println("Ingresar el limite superior: ");
                xmax = sc.nextDouble();

                System.out.println("Ingresar la tolerancia: ");
                tolerancia = sc.nextDouble();

            }else if (opcion == 2){
                metodoBiseccion(xmin, xmax, tolerancia);
            }else if (opcion == 3){
                bandera = false;
                Menu.menu();
            }else{
                System.out.println("Opcion invalida.");
            }
        }
        sc.close();
    }
    static double funcion1 (double x){
        return Math.exp(x)*Math.cos(x)-(x)*Math.sin(x);
    
    
    }
    static void metodoBiseccion(double xmin, double xmax, double tolerancia){
        double a, b, fa, fb, puntoMedio, error, xold, fPuntoMedio;
        int contador;
        a = xmin;
        b = xmax;
        fa = funcion1(a);
        fb = funcion1(b);
    
        error = 100;
    
        xold = 0;
    
        if (fa*fb > 0){
            System.out.println("El intervalo dado no es valido");
        }else{
            contador = 0;
    
            while (error > tolerancia){
                puntoMedio = (a+b)/2;
                fPuntoMedio = funcion1(puntoMedio);
    
                if (fa*fPuntoMedio > 0){
                    a = puntoMedio;
                    fa = fPuntoMedio;
                }else{
                    b = puntoMedio;
                    fb = fPuntoMedio;
                }
    
                contador = contador + 1;
                error = Math.abs(((puntoMedio-xold)/puntoMedio)*100);
                xold = puntoMedio;
            }
            System.out.println("No° iteraciones: " + contador + "\nRaiz: " + xold + "\nError: " + error);
        }
    }
}
