package ou3;

public class DenKortasteVagen {

	public static int[] mellanstationer(double[] a, double[][] b, double [] c) {
		double min = 100;
		int[] station = {0, 0, 0};	
		for(int i = 0; i < 3; i++) { 
			for(int j = 0; j < 4; j++) {
				if((a[i] + b[i][j] + c[j]) < min) {
					min = a[i] + b[i][j] + c[j];
					station[1] = i+1;
					station[2] = j+1;
				}
			}
		}
		return station;
	}
	
	public static double langd(double[] a, double[][] b, double[] c) {
		double min = 100;
		for(int i = 0; i < 3; i++) { 
			for(int j = 0; j < 4; j++) {
				if((a[i] + b[i][j] + c[j]) < min) {
					min = a[i] + b[i][j] + c[j];
				}	
			}
		}
		return min;
	}
	
}
