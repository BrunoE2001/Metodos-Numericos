public class ObtenerMatrizA {

    /**
     * codigo ANSI
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";
    MultiplicarMatriz mm = new MultiplicarMatriz();

    /**
     * Se busca la mejor ecuacion
     * que se adapte a la problema
     */
    ObtenerPseudoinversa opsi = new ObtenerPseudoinversa();
    void determimar_Ecuacion(int cdd, float [][]valoresxy){
        float [][]valx = valoresxy;
        float [][]valy = new float[cdd][1];
        float [][]pseudoinversa;
        float [][]resultado;

        /**
         * Se obtine la matriz
         * de resultados
         */
        for (int i = 0; i < valoresxy.length; i++) {
            for (int j = 0; j < 1; j++) {
                valy[i][j] = valoresxy[i][1];
            }
        }

        boolean bandera=false;
        /**
         * Se ajusta un polinomio
         * de la forma Mx + b
         */
        if ((cdd-1) == 1) {
            bandera = true;
            float [][]val = new float [cdd][2];
            for (int i = 0; i < valoresxy.length; i++) {
                for (int j = 0; j < 1; j++) {
                    val[i][j] = valoresxy[i][0];
                    val[i][1] = 1;
                }
            }
            valx=val;
        }

        /**Prueba para ver si me sale bien xD */
        else{
            float [][]val = new float [cdd][4];
            for (int i = 0; i < val.length; i++) {
                val[i][0] = (float) Math.pow(valoresxy[i][0],0);
                val[i][1] = (float) Math.pow(valoresxy[i][0],1);
                val[i][2] = (float) Math.sin(valoresxy[i][0]);
                val[i][3] = (float) Math.exp(valoresxy[i][0]);
            }
            valx = val;
        }
        /**
         * Se ajusta el polinomio de grado n-1
         * donde n es el numero de puntos
         */
        /*else{
            float [][]val = new float [cdd][cdd];
            for (int i = 0; i < val.length; i++) {
                for (int j = 0; j < val[0].length; j++) {
                    val[i][j] = (float) Math.pow(valoresxy[i][0],j);
                }
            }
            valx = val;
        }*/

        /**
         * Imprime matriz M
         * Imprime matriz b
         * Imprime pseudoinversa
         * Imprime resultados
         */
        impMz(valx, "MATRIZ M");
        imprimir(valy);
        pseudoinversa = opsi.calcularPseudoinversa(valx);
        resultado = mm.multiplicaMatrix(pseudoinversa, valy);
        impMz(pseudoinversa, "pseudoinversa");
        imprimirresultado(resultado, "Resultado", bandera, cdd);
    }

    /**
     * 
     * Metodo para imprimir las matrices
     */
    static void impMz(float [][]matriz, String mensaje){
        System.out.print(ANSI_BLUE + "\n    " + mensaje + "\n" + ANSI_RESET);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print("  "+ matriz[i][j] + "  ");
            }
            System.out.println();
        }
    }
    /**
     * Metodo que imprime la Matriz de resultados
     */
    static void imprimir(float [][]matriz){
        String leftAlignFormat = ANSI_GREEN+"|"+ANSI_RESET+" %-23s "+ANSI_GREEN+"|%n"+ANSI_RESET;
        System.out.format(ANSI_GREEN +"+------------+------------+%n");
        System.out.format("|   Matriz de resultados  |%n");
        System.out.format("+-------------------------+%n");
        System.out.format("|            b            |%n");
        System.out.format("+-------------------------+%n"+ANSI_RESET);
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.format(leftAlignFormat,"         "+ matriz[i][j]);
            }System.out.format(ANSI_GREEN+"+-------------------------+%n"+ ANSI_RESET);
        }
    }

    /**
     * Metodo que imprime la solucion
     */
    static void imprimirresultado(float [][]matriz, String titulo, boolean bandera, int cdd){
        String leftAlignFormat = ANSI_GREEN+"|"+ANSI_RESET+" %-10s "+ANSI_GREEN+"|"+ANSI_RESET+" %-10s "+ANSI_GREEN+"|%n"+ANSI_RESET;
        System.out.print(ANSI_BLUE + "\n    " + titulo + "\n" + ANSI_RESET);
        if (bandera == true) {
            System.out.format(ANSI_GREEN +"+-------------------------+%n");
            System.out.format("|        Y = Mx + b       |%n");
            System.out.format("+-------------------------+%n");
            System.out.format("|      x     |      b     |%n");
            System.out.format("+------------+------------+%n"+ANSI_RESET);
            for (int i = 0; i < matriz.length-1; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.format(leftAlignFormat, matriz[i][j], matriz[i+1][j]);
                }
                System.out.format(ANSI_GREEN+"+------------+------------+%n"+ ANSI_RESET);
            }
        }else{
            System.out.format(ANSI_GREEN +"+---------------------------------------------+%n");
            System.out.format("|  El POLINOMIO DE MEJOR AJUSTE ES DE GRADO "+(cdd-1)+" |%n");
            System.out.format("+---------------------------------------------+%n");
            System.out.format("+------------+------------+%n");
            System.out.format("|      ?     |      =     |%n");
            System.out.format("+------------+------------+%n"+ANSI_RESET);
            for (int i = 0; i < matriz.length; i++) {
                for (int j = 0; j < matriz[0].length; j++) {
                    System.out.format(leftAlignFormat,  "  X"+i, matriz[i][j]);
                }System.out.format(ANSI_GREEN+"+------------+------------+%n"+ ANSI_RESET);
            }
        }
    }
}
