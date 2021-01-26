package ou5;
import java.io.*;
import java.util.*;

public class PunktTest {

    public static void main(String[] args) {
        Punkt p1 = new Punkt ("A", 3, 4);
        Punkt p2 = new Punkt ("B", 5, 6);
        Punkt p3 = new Punkt ("C", 7, 8);
        Punkt p4 = new Punkt ("D", 9, 10);
        Punkt p5 = new Punkt ("F", 11, 12);
        Punkt p6 = new Punkt ("G", 13, 14);
        Punkt p7 = new Punkt ("H", 15, 16);

        PrintWriter out = new PrintWriter (System.out, true);
        
        // testa en konstruktor och en transformator
        out.println (p1 + " och " + p2);

        // testa inspektorer
        String n = p1.getNamn ();
        int x = p1.getX ();
        int y = p1.getY ();
        out.println (n + " " + x + " " + y);

        n = p2.getNamn ();
        x = p2.getX();
        y = p2.getY();
        out.println(n + " " + x + " " + y);

        // testa en kombinator och en komparator
        double d = p1.avstand (p2);
        out.println (d);
        boolean b = p1.equals (p2);
        out.println (b);

        // testa mutatorer
        p2.setX (1);
        p2.setY (2);
        n = p2.getNamn();
        x = p2.getX();
        y = p2.getY();

        out.println(n + " " + x + " " + y);

        // testa en konstruktor till
        Punkt p = new Punkt (p1);
        b = p.equals (p1);
        out.println (b);

        n = p.getNamn();
        x = p.getX();
        y = p.getY();

        out.println(n + " " + x + " " + y);
        out.println(p.toString());

    }

}