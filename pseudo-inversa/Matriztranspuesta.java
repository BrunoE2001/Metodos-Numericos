public class Matriztranspuesta {
	float [][] mTranspuesta(float [][] matriz) {
		float[][] matrizT = new float[matriz[0].length][matriz.length];

		for (int i=0; i< matriz.length; i++){
			for (int j= 0; j< matriz[0].length; j++){
				matrizT[j][i] = matriz[i][j];
			}
		}

		return matrizT;
	}

}