package ou2;
import java.util.*;

public class EnTriangelOchDessCirklar {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		in.useLocale (Locale.US);
		double a = in.nextDouble();
		double b = in.nextDouble();
		double c = in.nextDouble();

		double triangel_omkrets = Triangel.omkrets(a,b,c);

		double semiperimeter = triangel_omkrets / 2;

		double omskrivna_radie = Triangel.omskrivna(a, b, c);

		System.out.println(omskrivna_radie);

		double inskrivna_radie = Triangel.inskrivna(a, b, c);

		System.out.println(inskrivna_radie);
	}
}
