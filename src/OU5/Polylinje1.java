package ou5;
import java.util.Arrays;

public class Polylinje1 {
    private Punkt[] horn; //horn �r en array av punkter. Varje punkt har ett namn, x och y koordinat.
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje1 () {
        this.horn = new Punkt[0];
    }

    public Polylinje1 (Punkt[] horn) { //Tar emot en f�rbest�md polylinje och skapar en polylinje efter den.

        this.horn = new Punkt[horn.length];

        for (int i = 0; i < horn.length; i++)
            this.horn[i] = new Punkt (horn[i]);
    }
    public String toString () {
        String polylinje = "";
        for(int i = 0; i < this.horn.length; i++) {
        	Punkt punkt = this.horn[i];
        	int punkt_x = punkt.getX(), punkt_y = punkt.getY();
        	String punkt_namn = punkt.getNamn();
        	polylinje += "{" + punkt_namn + " ," + punkt_x + " ," + punkt_y + "}";
        }
        return "[" + polylinje + "]";
    }

    public Punkt[] getHorn () { //Skapar en kopia av h�rn genom att g� igenom alla h�rn och skriva in dem i en ny array.
    	return this.horn; //returnerar referensen till egna h�rn
    }

    public String getFarg () { //returnerar f�rgen f�r polylinje
        return this.farg;
    }

    public int getBredd () { //returnerar bredden f�r polylinje
        return this.bredd;
    }

    public void setFarg (String farg) { //�ndrar f�rgen f�r polylinje
        this.farg = farg;
    }

    public void setBredd (int bredd) { //�ndrar bredden f�r polylinje
        this.bredd = bredd;
    }

    public double langd () { //returnerar l�ngden f�r polylinje
        double langd = 0;
    	for(int i = 1; i < horn.length; i++) {
    		langd += horn[i-1].avstand(horn[i]);
    	}
    	return langd;
    }
    
    public void laggTill (Punkt horn) { //l�gger till en ny punkt i slutet
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;

        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];

        h[i] = new Punkt (horn);
        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) { //l�gger till en ny punkt i slutet eller f�re angiven plats
    	Punkt[] h = new Punkt[this.horn.length + 1]; //
    	Punkt carry = new Punkt(horn); // nya punkten E
    	
    	for(int i = 0; i < h.length; i++) {
    		if(i == this.horn.length) {
           		h[i] = carry;
           		break;
            }  
            if(hornNamn.equals(this.horn[i].getNamn())) {
           		h[i] = carry;
           		for(int j = i + 1; j < h.length; j++) {
           			h[j] = this.horn[i];
           			i++;
           		}
           		break;
    		}else {
    			h[i] = this.horn[i];
    		}
    	} 
    	this.horn = h;
    }

    public void taBort (String hornNamn) { //tar bort given punkt eller den sista om inte angiven
    	Punkt[] h = new Punkt[horn.length - 1];
    	
    	for(int i = 0; i < h.length; i++) {
            if(hornNamn.equals(horn[i].getNamn())) {
           		for(int j = i + 1; j <= h.length; j++) {
           			h[i] = horn[j];
           			i++;
           		
           		}
           		break;
    		}else {
    			h[i] = horn[i];
    		}
    	} 
    	horn = h;
    }
}