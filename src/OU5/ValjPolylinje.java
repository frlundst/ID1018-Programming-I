package ou5;
import java.util.ArrayList;
import java.util.*;

class ValjPolylinje 
{
    public static final Random rand = new Random();
    public static final int ANTAL_POLYLINJER = 10;

    public static void main(String[] args) 
    {
        // skapa ett antal slumpmässiga polylinjer
        Polylinje[] polylinjer = new Polylinje[ANTAL_POLYLINJER];
        ArrayList<Polylinje> kortasteGula = new ArrayList<>();
        for (int i = 0; i < ANTAL_POLYLINJER; i++)
        {
            polylinjer[i] = slumpPolylinje();

            // visa polylinjerna
            System.out.println("Polylinje " + (i + 1) + ": " + polylinjer[i].toString());

            //lagra gula polylinjerna i en arraylist
            if(polylinjer[i].getFarg() == "Yellow")
            {
                kortasteGula.add(polylinjer[i]);
            }
        }

        Polylinje[] denKortasteGula = new Polylinje[kortasteGula.size()];
        denKortasteGula = kortasteGula.toArray(denKortasteGula);

        // bestäm den kortaste av de polylinjer som är gula
        for(int i = 0; i < denKortasteGula.length - 1; i++)
        {
            denKortasteGula[0] = (denKortasteGula[i].langd() < denKortasteGula[i + 1].langd())? denKortasteGula[i] : denKortasteGula[i + 1];
        }

        // visa den valda polylinjen
        if(denKortasteGula.length > 0)
        {
            System.out.println("\nKortaste gula Polylinjen: " + denKortasteGula[0] + "\n");
        }
        else
        {
            System.out.println("\nInga linjer är gula.\n");
        }
    }

    // slumpPunkt returnerar en punkt med ett slumpmässigt namn, som är en stor
    // bokstav i
    // det engelska alfabetet, och slumpmässiga koordinater.
    public static Punkt slumpPunkt() 
    {
        String n = "" + (char) (65 + rand.nextInt(26));
        int x = rand.nextInt(11);
        int y = rand.nextInt(11);
        return new Punkt(n, x, y);
    }

    public static String slumpFarg() 
    {
        String[] farger = {"Red", "Blue", "Yellow"};
        int i = rand.nextInt(farger.length);
        String polyFarg = farger[i];

        return polyFarg;
    }

    // slumpPolylinje returnerar en slumpmässig polylinje, vars färg är antingen blå, röd
    // eller gul. Namn på polylinjens hörn är stora bokstäver i det engelska alfabetet. Två hörn
    // kan inte ha samma namn.
    public static Polylinje slumpPolylinje()
    {
        // skapa en tom polylinje, och lägg till hörn till den
        int antalHorn = 2 + rand.nextInt(7);
        int antalValdaHorn = 0;
        boolean[] valdaNamn = new boolean[26];

        // ett och samma namn kan inte förekomma flera gånger
        char valtChar = 0;
        Punkt[] punktlista = new Punkt[antalHorn];
        while (antalValdaHorn < antalHorn) 
        {
            punktlista[antalValdaHorn] = slumpPunkt();
            valtChar = punktlista[antalValdaHorn].name.charAt(0);

            while(valdaNamn[valtChar - 65])
            {
                punktlista[antalValdaHorn] = slumpPunkt();
                valtChar = punktlista[antalValdaHorn].name.charAt(0);
            }

            valdaNamn[valtChar - 65] = true;
            antalValdaHorn++;
        }

        // sätt färg
        Polylinje polylinje = new Polylinje(punktlista);
        polylinje.setFarg(slumpFarg());
        //String a = slumpFarg();
        //polylinje.setFarg(a);

        return polylinje;
    }
}

