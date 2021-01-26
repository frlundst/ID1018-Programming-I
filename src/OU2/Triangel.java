package ou2;

public class Triangel {
	
	//Ber�knar omkrets f�r en triangel d�r alla tre sidor �r k�nda. Metoden returnerar sedan omkretsen.
	public static double omkrets(double a, double b, double c){
			return a + b + c;
	}
	
	//Ber�knar radien f�r den omskrivna cirkeln f�r triangel och returnerar radien.
	public static double omskrivna(double a, double b, double c){
		double s = (a + b + c) / 2;	
		double R = (a * b * c)/(4 * Math.sqrt(s * (s - a) * (s - b) * (s - c)));
			return R;
	}
	
	//Ber�knar radien f�r den inskrivna cirkeln f�r triangel och returnerar radien.
	public static double inskrivna(double a, double b, double c){
		double s = (a + b + c) / 2;	
		double r = Math.sqrt(((s - a) * (s - b) * (s - c))/ s);
		return r;
	}
	//Ber�knar bisektris f�r triangel d�r tv� sidor �r k�nda samt dess vinkel
	public static double bisektris(double b, double c, double alfa) {
		double p = 2 * b * c * Math.cos(alfa/2);
		double bis = p / (b + c);
		return bis;
	}
	//Ber�knar h�jd f�r triangel d�r dess sidor samt semipermeter �r k�nda
	public static double hojd(double a, double b, double c) {
		double s = (a + b + c) / 2;
		double h = (2 / a) * Math.sqrt(s * (s - a) * (s - b) * (s - c));
		return h;
	}
	//Ber�knar semiperimeter f�r triangel d�r dess sidor �r k�nda
	public static double semiperimeter(double a, double b, double c) {
		return (a + b + c) / 2;
	}
	
}
