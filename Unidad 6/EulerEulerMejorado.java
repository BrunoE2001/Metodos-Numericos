import java.util.Scanner;

class EulerMejorado {

    /**
     * Funciion a evaluar
     * Ejercicio 1
     * @param y0
     * @param t0
     * @param dt
     * @param N
     */
    public static void evaluar(double x0, double y0, double dt, int N, int opcion) {
        double aumento = 0;
        double X0 = x0;
        double x1 = y0;
        double Y0 = y0;
        double y1 = 0;
        double y2 = 0;
        System.out.println("n     xn    yn");
        if (opcion == 1) {
            for (int i = 0; i < N; i++) {
                aumento = X0 + dt;
                y1 = x1 + dt * (X0-Y0+5);
                y2 = x1 + dt * (((X0-Y0+5)+(aumento-y1+5))/2);
                System.out.print(i+"    "+(float)aumento+"  "+(float)y2+"\n");
                X0=aumento;
                x1=y1;
                Y0=y2;
            }
        }
        else if(opcion == 2){
            for (int i = 0; i < N; i++) {
                aumento = X0 + dt;
                y1 = x1 + dt * Math.log(X0 + Y0);
                y2 = x1 + dt * (((Math.log(X0 + Y0))+(Math.log(aumento+y1)))/2);
                System.out.print(i+"    "+(float)aumento+"  "+(float)y2+"\n");
                X0=aumento;
                x1=y1;
                Y0=y2;
            }
        }
        else if(opcion == 3){
            for (int i = 0; i < N; i++) {
                aumento = X0 + dt;
                y1 = x1 + dt * ((2 * X0) + Y0 -3);
                y2 = x1 + dt * ((((2 * X0) + Y0 -3)+((2 * aumento) + y1 -3))/2);
                System.out.print(i+"    "+(float)aumento+"  "+(float)y2+"\n");
                X0=aumento;
                x1=y1;
                Y0=y2;
            }
        }
        else if(opcion == 4){
            for (int i = 0; i < N; i++) {
                aumento = X0 + dt;
                y1 = x1 + dt * (1 / (Math.pow(X0, 2) + Y0));
                y2 = x1 + dt * (((1 / (Math.pow(X0, 2) + Y0))+(1 / (Math.pow(aumento, 2) + y1)))/2);
                System.out.print(i+"    "+(float)aumento+"  "+(float)y2+"\n");
                X0=aumento;
                x1=y1;
                Y0=y2;
            }
        }
        else if(opcion == 5){
            for (int i = 0; i < N; i++) {
                aumento = X0 + dt;
                y1 = x1 + dt * (Math.log(X0) + (1/Y0));
                y2 = x1 + dt * (((Math.log(X0) + (1/Y0))+(Math.log(aumento) + (1/y1)))/2);
                System.out.print(i+"    "+(float)aumento+"  "+(float)y2+"\n");
                X0=aumento;
                x1=y1;
                Y0=y2;
            }
        }
        else if(opcion == 6){
            for (int i = 0; i < N; i++) {
                aumento = X0 + dt;
                y1 = x1 + dt * (Math.sqrt(X0) + Math.sqrt(Y0));
                y2 = x1 + dt * (((Math.sqrt(X0) + Math.sqrt(Y0))+(Math.sqrt(aumento) + Math.sqrt(y1)))/2);
                System.out.print(i+"    "+(float)aumento+"  "+(float)y2+"\n");
                X0=aumento;
                x1=y1;
                Y0=y2;
            }
        }
    }
    static int opc=0;
    static boolean Menu(){
        Scanner sc = new Scanner(System.in);
        boolean bandera = true;

        System.out.println("\tEJERCICIOS");
        System.out.print("[1]. y'= x - y + 5     y(1) = 2"+
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
