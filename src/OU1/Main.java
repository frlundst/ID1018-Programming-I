package ou1;
import java.util.*;

public class Main {

	public static void main (String[] args){
		System.out.println ("TEMPERATURER\n");

		// inmatningsverktyg
		Scanner in = new Scanner (System.in);
		in.useLocale (Locale.US);
		// mata in uppgifter om antalet veckor och antalet mätningar
		System.out.print ("antalet veckor: ");
		int antalVeckor = in.nextInt ();
		System.out.print ("antalet mätningar per vecka: ");
		int antalMatningarPerVecka = in.nextInt ();
		// plats att lagra temperaturer
		double[][] t = new double[antalVeckor + 1][antalMatningarPerVecka + 1];
		// mata in temperaturerna
		for (int vecka = 1; vecka <= antalVeckor; vecka++){
			System.out.println ("temperaturer - vecka " + vecka + ":");
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
				t[vecka][matning] = in.nextDouble ();
			}
		}
		System.out.println ();
		// visa temperaturerna
		System.out.println ("temperaturerna:");
		for (int vecka = 1; vecka <= antalVeckor; vecka++){
			for (int matning = 1; matning <= antalMatningarPerVecka; matning++) {
				System.out.print (t[vecka][matning] + " ");
			}
			System.out.println ();
		}
		
		System.out.println ();
		// den minsta, den största och medeltemperaturen – veckovis
		double[] minT = new double[antalVeckor + 1];
		double[] maxT = new double[antalVeckor + 1];
		double[] sumT = new double[antalVeckor + 1];
		double[] medelT = new double[antalVeckor + 1];
		// koden ska skrivas här
		// visa den minsta, den största och medeltemperaturen för varje vecka
		for(int vecka = 0; vecka < antalVeckor; vecka++) {
			double min = t[0][0];
			for(int matning = 0; matning < antalMatningarPerVecka; matning++) {	
				if(t[vecka][matning] < min) {
					min = t[vecka][matning];
				}
			}
			System.out.println("Minsta värdet:" + min);
		}
		// den minsta, den största och medeltemperaturen - hela mätperioden
		double minTemp = minT[1];
		double maxTemp = maxT[1];
		double sumTemp = sumT[1];
		double medelTemp = 0;
		// koden ska skrivas här
		// visa den minsta, den största och medeltemperaturen i hela mätperioden
		// koden ska skrivas här
	 }
}
