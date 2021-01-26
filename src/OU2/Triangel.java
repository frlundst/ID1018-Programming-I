package ou2;

public class Triangel {
	
	//Beräknar omkrets för en triangel där alla tre sidor är kända. Metoden returnerar sedan omkretsen.
	public static double omkrets(double a, double b, double c){
			return a + b + c;
	}
	
	//Beräknar radien för den omskrivna cirkeln för triangel och returnerar radien.
	public static double omskrivna(double a, double b, double c){
		double s = (a + b + c) / 2;	
		double R = (a * b * c)/(4 * Math.sqrt(s * (s - a) * (s - b) * (s - c)));
			return R;
	}
	
	//Beräknar radien för den inskrivna cirkeln för triangel och returnerar radien.
	public static double inskrivna(double a, double b, double c){
		double s = (a + b + c) / 2;	
		double r = Math.sqrt(((s - a) * (s - b) * (s - c))/ s);
		return r;
	}
	//Beräknar bisektris för triangel där två sidor är kända samt dess vinkel
	public static double bisektris(double b, double c, double alfa) {
		double p = 2 * b * c * Math.cos(alfa/2);
		double bis = p / (b + c);
		return bis;
	}
	//Beräknar höjd för triangel där dess sidor samt semipermeter är kända
	public static double hojd(double a, double b, double c) {
		double s = (a + b + c) / 2;
		double h = (2 / a) * Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return h;
	}
	//Beräknar semiperimeter för triangel där dess sidor är kända
	public static double semiperimeter(double a, double b, double c) {
		return (a + b + c) / 2;
	}
	
}
