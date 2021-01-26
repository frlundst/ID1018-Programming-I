package eu1;

/**
 * @author Fredrik
 *
 */
 public class EU1 {
	
	public static void main(String[] args) {
		int[] element = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,0,18,19}; 
		System.out.println(min(element));
	}
	
	// min returnerar det minsta elementet i en sekventiell samling.
	// Om samlingen är tom, kastas ett undantag av typen IllegalArgumentException.
	public static int min (int[] element) throws IllegalArgumentException {
		if (element.length == 0)
			throw new IllegalArgumentException ("tom samling");
		// hör ihop med spårutskriften 2:
		int antalVarv = 1;
		int[] sekvens = element;
		int antaletPar = sekvens.length / 2;
		int antaletOparadeElement = sekvens.length % 2;
		int antaletTankbaraElement = antaletPar + antaletOparadeElement;
		int[] delsekvens = new int[antaletTankbaraElement];
		int i = 0;
		int j = 0;
		while (antaletTankbaraElement > 1) { 

			i = 0;
			j = 0;
			while (j < antaletPar) {
				delsekvens[j++] = (sekvens[i] < sekvens[i + 1])? sekvens[i] : sekvens[i + 1]; //jämför och lägger alltid till det minsta värdet a sekvens
				i += 2;
			}
			
			if (antaletOparadeElement == 1)
				delsekvens[j] = sekvens[antaletPar*2];
			
			sekvens[0] = (sekvens[0] < sekvens[1])? sekvens[0] : sekvens[1];
			
			sekvens = delsekvens;
			antaletPar = antaletTankbaraElement / 2;
			antaletOparadeElement = antaletTankbaraElement % 2;
			antaletTankbaraElement = antaletPar + antaletOparadeElement;
			//delsekvens = new int[antaletTankbaraElement];
			System.out.println (java.util.Arrays.toString (sekvens));
		}
		return sekvens[0];
	}
}
	