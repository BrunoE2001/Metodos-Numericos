import java.util.Scanner;

/**
 * pseudoinversa
 */
class pseudoinversa {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de No° de puntos ");
        int cdd = sc.nextInt();
        if (cdd == 1) {
            System.out.println( ANSI_BLUE + "+-------------------------+\n"
                                          + "| Debe elejir otro metodo |\n"
                                          + "+-------------------------+"
                                + ANSI_RESET);
            System.exit(0);
        }
        capturar_datos(cdd);
        sc.close();
    }
    
    /**
     * codigo ANSI
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE  = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    static void capturar_datos(int cdd){
        Scanner sc = new Scanner(System.in);
        int cant = cdd;

        float [][] valoresxy = new float[cdd][2];

        /**
         * Capturar los datos
         */
        System.out.println(ANSI_GREEN + "Ingrese los valores" + ANSI_RESET);
        for (int i = 0; i < valoresxy.length; i++) {
            for (int j = 0; j < valoresxy[0].length; j++) {
                valoresxy[i][j] = sc.nextFloat();
            }
        }

        /**
         * Limpiar consola
         */
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String leftAlignFormat = ANSI_GREEN+"|"+ANSI_RESET+" %-10s "+ANSI_GREEN+"|"+ANSI_RESET+" %-10s "+ANSI_GREEN+"|%n"+ANSI_RESET;
        /**
         * Imprimir tabla de valores ingresados
         */
        System.out.format(ANSI_GREEN +"+------------+------------+%n");
        System.out.format("|     TABLA DE VALORES    |%n");
        System.out.format("+------------+------------+%n");
        System.out.format("|      x     |      Y     |%n");
        System.out.format("+------------+------------+%n"+ANSI_RESET);
        for (int i = 0; i < valoresxy.length; i++) {
            for (int j = 0; j < valoresxy[0].length-1; j++) {
                System.out.format(leftAlignFormat,  "   "+valoresxy[i][j],"   "+valoresxy[i][j+1]);
            }System.out.format(ANSI_GREEN+"+------------+------------+%n"+ ANSI_RESET);
        }

        ObtenerMatrizA Oma = new ObtenerMatrizA();
        Oma.determimar_Ecuacion(cant, valoresxy);

        sc.close();
    }
}