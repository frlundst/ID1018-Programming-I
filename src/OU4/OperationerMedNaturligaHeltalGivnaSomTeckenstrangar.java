package ou4;
import java.util.*; // Scanner
import static java.lang.System.out;

class OperationerMedNaturligaHeltalGivnaSomTeckenstrangar
{
	public static void main (String[] args){
		out.println ("OPERATIONER MED NATURLIGA HELTAL GIVNA SOM TECKENSTRANGAR\n");
		// mata in två naturliga heltal
		Scanner in = new Scanner (System.in);
		out.println ("två naturliga heltal:");
		String tal1 = in.next ();
		String tal2 = in.next ();
		out.println ();
		// addera heltalen och visa resultatet
		String summa = addera (tal1, tal2);
		visa (tal1, tal2, summa, '+');
		String summa2 = subtrahera(tal1, tal2);
		visa(tal1, tal2, summa2, '-');
		// subtrahera heltalen och visa resultatet
		// koden här
	}
	
	// addera tar emot två naturliga heltal givna som teckensträngar, och returnerar deras
	// summa som en teckensträng.
	public static String addera (String tal1, String tal2){
		
		String tal1_reverse = "";
		String tal2_reverse = "";
		String sum = "";
		String sum_reverse = "";
		int barare = 0;
		
		if(tal1.length() > tal2.length()) {
			String x = tal1;
			tal1 = tal2;
			tal2 = x;
		}
		
		for(int i = tal1.length() - 1; i >= 0; i--) { //vänd tal1
			tal1_reverse = tal1_reverse + tal1.charAt(i);
		}
		for(int i = tal2.length() - 1; i >= 0; i--) { //vänd tal2
			tal2_reverse = tal2_reverse + tal2.charAt(i);
		}
		
		for(int i = 0; i < tal1_reverse.length(); i++) {
			int sum2 = ((int)(tal1_reverse.charAt(i)-'0') + (int)(tal2_reverse.charAt(i) - '0') + barare); 
			sum_reverse += (char)(sum2 % 10 + '0'); 
			barare = sum2 / 10;
		}
		
		for(int i = tal1_reverse.length(); i < tal2_reverse.length(); i++) {
			int sum2 = ((int)(tal2_reverse.charAt(i) - '0' + barare));
			sum_reverse += (char)(sum2 % 10 + '0');
			barare = sum2 / 10;
		}
		
		if(barare > 0) {
			sum_reverse += (char)(barare + '0');
		}
		
		for(int i = sum_reverse.length() - 1; i >= 0; i--) {
			sum = sum + sum_reverse.charAt(i);
		}
				
		return sum;
	}
	
	// subtrahera tar emot två naturliga heltal givna som teckensträngar, och returnerar
	// deras differens som en teckensträng.
	// Det första heltalet är inte mindre än det andra heltalet.
	public static String subtrahera (String tal1, String tal2){
		String tal1_reverse = "";
		String tal2_reverse = "";
		int barare = 0;
		String sum = "";
		String sum_reverse = ""; 
		
		if(tal1.length() < tal2.length()) { //tal1 ska vara större 
			String x = tal1;
			tal1 = tal2;
			tal2 = x;
		}
		
		for(int i = tal1.length() - 1; i >= 0; i--) { //vänd tal1 stringbuilder kan även användas
			tal1_reverse = tal1_reverse + tal1.charAt(i);
		}
		
		for(int i = tal2.length() - 1; i >= 0; i--) { //vänd tal2
			tal2_reverse = tal2_reverse + tal2.charAt(i);
		}
		
		for(int i = 0; i < tal2_reverse.length(); i++) {
			
			int sum2 = ((int)(tal1_reverse.charAt(i) - '0') - (int)(tal2_reverse.charAt(i) - '0') - barare);
			
			if(sum2 < 0) {
				sum2 += 10;
				barare = 1;
			}else 
				barare = 0;
			
			sum_reverse += (char)(sum2 + '0');
		}
				
		for(int i = tal2.length(); i < tal1.length(); i++) {
			int sum2 = ((int)(tal1_reverse.charAt(i) - '0') - barare);
			if (sum2 < 0) {
				sum2 += 10;
				barare = 1;
			}else
				barare = 0;
			if(sum2 != 0) {
				sum_reverse += (char)(sum2 + '0');	
			}
		}
		
		for(int i = sum_reverse.length() - 1; i >= 0; i--) { //vänd tal2
			sum += sum_reverse.charAt(i);
		}

		return sum;
	}
	
	// visa visar två givna naturliga heltal, och resultatet av en aritmetisk operation
	// utförd i samband med hetalen
	public static void visa (String tal1, String tal2, String resultat, char operator){
		// sätt en lämplig längd på heltalen och resultatet
		int len1 = tal1.length ();
		int len2 = tal2.length ();
		int len = resultat.length ();
		int maxLen = Math.max (Math.max (len1, len2), len);
		tal1 = sattLen (tal1, maxLen - len1);
		tal2 = sattLen (tal2, maxLen - len2);
		resultat = sattLen (resultat, maxLen - len);
		// visa heltalen och resultatet
		out.println (" " + tal1);
		out.println ("" + operator + " " + tal2);
		for (int i = 0; i < maxLen + 2; i++)
			out.print ("-");
		out.println ();
		out.println (" " + resultat + "\n");
	}

	// sattLen lägger till ett angivet antal mellanslag i början av en given sträng
	public static String sattLen (String s, int antal){
		StringBuilder sb = new StringBuilder (s);
		for (int i = 0; i < antal; i++)
			sb.insert (0, " ");
		return sb.toString ();
	}
}

