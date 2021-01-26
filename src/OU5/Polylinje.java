package ou5;
import java.util.Arrays;

public class Polylinje {
	
	public class PolylinjeIterator{
		private int aktuell = -1;

		public PolylinjeIterator ()
		{
			if (Polylinje.this.horn.length > 0)
				aktuell = 0;
		}

		public boolean finnsHorn() {
			return aktuell != -1;
		}

		public Punkt horn() throws java.util.NoSuchElementException {
			if (!this.finnsHorn())
				throw new java.util.NoSuchElementException("slut av iterationen");
			Punkt horn = Polylinje.this.horn[aktuell];
			return horn;
		}

		public void gaFram() {
			if (aktuell >= 0 && aktuell < Polylinje.this.horn.length - 1)
				aktuell++;
			else
				aktuell = -1;
		}
		
		public void printPunkt() {
			while(this.finnsHorn()) {
				var tempHorn = horn();
				System.out.println(tempHorn);
				gaFram();
			}
		}
	}
	
    private Punkt[] horn; //horn är en array av punkter. Varje punkt har ett namn, x och y koordinat.
    private String farg = "svart";
    private int bredd = 1;

    public Polylinje () {
        this.horn = new Punkt[0];
    }

    public Polylinje (Punkt[] horn) { //Tar emot en förbestämd polylinje och skapar en polylinje efter den.

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
        return "[" + polylinje + " ," + farg + " ," + bredd +  "]";
    }

    public Punkt[] getHorn () { //Skapar en kopia av hörn genom att gå igenom alla hörn och skriva in dem i en ny array.
    	Punkt[] h = new Punkt[this.horn.length];
    	for(int i = 0; i < h.length; i++) {
    		h[i] = this.horn[i];
    	}
        return h; //Bättre för datorn och mer minneseffektivt att returnera på detta sätt.
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

    public double langd () { //returnerar längden för polylinje
        double langd = 0;
    	for(int i = 1; i < horn.length; i++) {
    		langd += horn[i-1].avstand(horn[i]);
    	}
    	return langd;
    }
    
    public void laggTill (Punkt horn) { //lägger till en ny punkt i slutet
        Punkt[] h = new Punkt[this.horn.length + 1];
        int i = 0;

        for (i = 0; i < this.horn.length; i++)
            h[i] = this.horn[i];

        h[i] = new Punkt (horn);
        this.horn = h;
    }

    public void laggTillFramfor (Punkt horn, String hornNamn) { //lägger till en ny punkt i slutet eller före angiven plats
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