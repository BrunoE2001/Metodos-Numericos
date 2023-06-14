import java.util.Scanner;

public class Matriztranspuesta {
	void mTranspuesta() {
		Scanner sc = new Scanner(System.in);
		CrearMatriz cm = new CrearMatriz();
		
		int i,e;
		
		System.out.println("Ingrese el numero de filas ");
        int filas = sc.nextInt();

        System.out.println("Ingrese el numero de columnas ");
        int columnas = sc.nextInt();
		
		float [][]matriz =new float[filas][columnas];
		matriz = cm.crearMatriz(filas, columnas);
		
		float[][] matrizT = new float[matriz[0].length][matriz.length];

		for (i=0; i< matriz.length; i++){
			for (e= 0; e< matriz[0].length; e++){
				matrizT[e][i] = matriz[i][e];
			}
		}

		System.out.println("Matriz Original" + "\n");
		for (i=0; i< matriz.length; i++){
			for (e= 0; e< matriz[0].length; e++){
				System.out.print(matriz[i][e]+" ");
			}
			System.out.println();
		}

		System.out.println("Matriz Traspuesta" + "\n");
		for(i= 0; i<matrizT.length; i++){
			for(e=0; e< matrizT[0].length; e++){
				System.out.print(matrizT[i][e] + " " );
			}
			System.out.println();
		}
	}

}