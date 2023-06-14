import java.util.Scanner;

class MetodoNewtonRaphson {
    void menu(){
        Scanner sc = new Scanner(System.in);
        MetodoNewtonRaphson mnr = new MetodoNewtonRaphson();
        
        System.out.println("Digite la aproximacion:");
            double xr = sc.nextDouble();
        System.out.println("Digite la tolerancia: ");
            double tol = sc.nextDouble();
        System.out.println("Digite el numero de iteraciones limite");
            int iteer = sc.nextInt();
        mnr.newtonRaphson(xr, tol, iteer);
        Menu.menu();
        sc.close();
    }

    static double funcion(double x){ // Evalua funcion
        return Math.exp(-x) - Math.log(x);
    }
    static double derivada(double x){ // Evalua derivada
        return -Math.exp(-x) - (1/x);
    }
    void newtonRaphson(double xr,double delta,int maxit){
        /**
         * xf - valor de inicio
         * delta- tolerancia
         * maxit - numero de iteraciones
         */
        int iter = 0; // Contador de iteraciones
        double error = 100;
        while (iter < maxit) {
            double xold = xr;
            xr = xr - (funcion(xr) / derivada(xr));
            error = 100 * Math.abs((xr - xold)/xr);
            iter++;
            if(error <= delta){
                System.out.println("Valor de error => "+error);
                System.out.println("Valor de la aproximacion => "+xr);
                System.out.println("No° de iteraciones => "+iter);

                System.out.printf("Valor de error: %.6f en aprox: %.6f en la iteracion %d", error, xr , iter);
                break;
            }
            if(iter >= maxit){
                System.out.println("Fallo el numero de iteraciones " );
                break;
            }
        }
    }
}
