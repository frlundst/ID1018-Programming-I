package ou5;
import java.util.Arrays;

public class Polylinjealternativ {
    private Punkt[] horn; //horn är en array av punkter. Varje punkt har ett namn, x och y koordinat.
    private String farg = "svart";
    private int bredd = 1;

    public Polylinjealternativ () {
        this.horn = new Punkt[0];
    }

    public Polylinjealternativ (Punkt[] horn) { //Tar emot en förbestämd polylinje och skapar en polylinje efter den.

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

    public Punkt[] getHorn () { //Skapar en kopia av hörn genom att gå igenom alla hörn och skriva in dem i en ny array.
    	Punkt[] h = new Punkt[this.horn.length];
    	for(int i = 0; i < h.length; i++) {
    		h[i] = this.horn[i];
    	}
        return h; 
    }

    public String getFarg () { //returnerar färgen för polylinje
        return this.farg;
    }

    public int getBredd () { //returnerar bredden för polylinje
        return this.bredd;
    }

    public void setFarg (String farg) { //ändrar färgen för polylinje
        this.farg = farg;
    }

    public void setBredd (int bredd) { //ändrar bredden för polylinje
        this.bredd = bredd;
    }

    public double langd () {
        return bredd;
    }
    
    public void laggTill (Punkt horn) {
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;

        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];

        h[i] = new Punkt (horn);
        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) {
    	Punkt[] h = new Punkt[this.horn.length + 1]; //
    	Punkt carry = new Punkt(horn); // nya punkten E
    	
    	for (int i = 0; i < this.horn.length; i++) {
    		h[i] = this.horn[i];
    	}
    	
        if(hornNamn == "" || hornNamn == null) {
            laggTill(horn);
        }else {
        	laggTill(this.horn[this.horn.length - 1]);
        	
        	int i = 0;
            for(i = 0; i < this.horn.length; i++) {
                
            	if(this.horn[i].name == hornNamn) {
                    break;
            	}  
            }

            h[i] = carry;
            
            for(int ii = this.horn.length - 1; ii > i; ii--) {
            	h[ii] = h[ii - 1];
            }
            h[i+1] = this.horn[i];
            this.horn = h;
        }
    }

    public void taBort (String hornNamn) {
        for(int i = 0; i < this.horn.length; i++) {
            if(this.horn[i].name == hornNamn) {

            }
        }
    }
}