import java.util.Scanner;

class Euler {

    /**
     * Funciion a evaluar
     * Ejercicio 1
     * @param y0
     * @param t0
     * @param dt
     * @param N
     */
    public static void evaluar(double y0, double t0, double dt, int N, int opcion) {
        double y1 = y0;
        double t1 = t0;
        System.out.println("n     xn      yn");
        if (opcion == 1) {
            for (int i = 0; i < N; i++) {
                y1 = y1 + dt * Math.sqrt(Math.pow(t1, 2) + Math.pow(y1, 2));
                t1 +=  dt;
                System.out.print(i+"    "+(float)t1+"  "+(float)y1+"\n");
            }
        }
        else if(opcion == 2){
            for (int i = 0; i < N; i++) {
                y1 = y1 + dt * Math.log(t1 + y1);
                t1 +=  dt;
                System.out.print(i+"    "+(float)t1+"  "+(float)y1+"\n");
            }
        }
        else if(opcion == 3){
            for (int i = 0; i < N; i++) {
                y1 = y1 + dt * ((2 * t1) + y1 -3);
                t1 +=  dt;
                System.out.print(i+"    "+(float)t1+"  "+(float)y1+"\n");
            }
        }
        else if(opcion == 4){
            for (int i = 0; i < N; i++) {
                y1 = y1 + dt * (1 / (Math.pow(t1, 2) + y1));
                t1 +=  dt;
                System.out.print(i+"    "+(float)t1+"  "+(float)y1+"\n");
            }
        }
        else if(opcion == 5){
            for (int i = 0; i < N; i++) {
                y1 = y1 + dt * (Math.log(t1) + (1/y1));
                t1 +=  dt;
                System.out.print(i+"    "+(float)t1+"  "+(float)y1+"\n");
            }
        }
        else if(opcion == 6){
            for (int i = 0; i < N; i++) {
                y1 = y1 + dt * (Math.sqrt(t1) + Math.sqrt(y1));
                t1 +=  dt;
                System.out.print(i+"    "+(float)t1+"  "+(float)y1+"\n");
            }
        }
    }
    static int opc=0;
    static boolean Menu(){
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;

        System.out.println("\tEJERCICIOS");
        System.out.print("[1]. y'= √(x^2+y^2 )   y(2) = 0.5"+
        "\n[2]. y'= ln(x+y)       y(1) = 1.5)"+
        "\n[3]. y' = 2x+7-3       y(2) = 1"+
        "\n[4]. y' = 1/(x^2+y)    y(3) = 2.5)"+
        "\n[5]. y'=ln x + 1/y     y(4.3) = 5"+
        "\n[6]. y'= √x+√y         y(3) = 10"+
        "\nPulse cualquier numero diferente a los que se muestran para salir\n");
        System.out.println("Que funcion desea evaluar: ");
        opc = sc.nextInt();
        if (opc <= 0 || opc >= 7) {
            bandera = false;
        } else {
            bandera = true;
        }
        return bandera;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        boolean VoF = Menu();
        if (VoF) {
                System.out.println("Valor inicial: ");
                    double y0 = sc.nextDouble();
                System.out.println("Tiempo inicial: ");
                    double t0 = sc.nextDouble();
                System.out.println("Tamaño de paso: ");
                    double dt = sc.nextDouble();
                System.out.println("Numero de puntos: ");
                    int N = sc.nextInt();
                System.out.println("Resumimos los resultados en la siguiente tabla:");
                evaluar(y0,t0,dt,N,opc);
        }else{
            System.exit(0);
        }
    }
}
