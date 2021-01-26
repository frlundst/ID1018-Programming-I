package ou3;
import java.util.*;

public class BestamDenKortasteVagen {

	public static void main(String[] args) {
		//double[] a = {3.20, 3.50, 4};
		//double[][] b = {{6, 6.80, 6.30, 5.30}, {5, 5.60, 6.90, 4}, {6.30, 7, 7.50, 5.70}};
		//double[] c = {4.70, 4.50, 4, 3.40, 4.70, 4.50, 4, 3.40, 4.70, 4.50, 4, 3.40};
		
		Scanner in = new Scanner(System.in);
		double[] a = {0,0,0};
		double[][] b = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		double[] c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		for(int i = 0; i < 3; i++) {
			System.out.print("Skriv in langd mellan X och U" + (i+1) + ": ");
			a[i] = in.nextDouble();
			for(int j = 0; j < 4; j++) {
				System.out.print("Skriv in längd mellan U" + (i+1) + " och V" + (j+1) + ": ");
				b[i][j] = in.nextDouble();
			}
		}
		for(int i = 0; i < 4; i++) {
			System.out.print("Skriv in längd mellan V" + (i+1) + " och Y" + ": ");
			c[i] = in.nextDouble();
			c[4 + i] = c[i];
			c[8 + i] = c[i];
		}
		
		int[] stationer = DenKortasteVagen.mellanstationer(a, b , c);
		System.out.println("Kortaste sträckan går genom station U" + stationer[1] + " och V" + stationer[2] + ".");
		System.out.println("Minsta sträckan: " + DenKortasteVagen.langd(a, b, c));
	}

}
