import java.util.Scanner;

class Menu{
    static void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\n####################\n"+"##      Menu      ##"+"\n####################");

        String menu = "1. metodo de biseccion\n"
        + "2. metodo de regla falsa\n"
        + "3. metodo de newton raphson\n"
        + "4. Salir\n";

        System.out.print(menu+" Elije un metodo ");
        int opc = sc.nextInt();
        if (opc == 1){
            MetodoBiseccion mb = new MetodoBiseccion();
            mb.Menu();
        }else if (opc == 2){
            MetodoReglaFalsa mrf = new MetodoReglaFalsa();
            mrf.main();
        }else if (opc == 3){
            MetodoNewtonRaphson mnr = new MetodoNewtonRaphson();
            mnr.menu();
        }else if(opc == 4){
            System.out.println("Adios!!");
        }else{
            System.out.println("Opcion invalida.");
        }
        sc.close();
    }
}
