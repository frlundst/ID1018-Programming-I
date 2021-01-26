package ou5;

import java.io.PrintWriter;

import ou5.Polylinje.PolylinjeIterator;

public class PolylinjeTest {
	public static void main(String[] args) {
		Punkt p1 = new Punkt("A", 3, 4);
		Punkt p2 = new Punkt("B", 5, 6);
		Punkt p3 = new Punkt("C", 7, 8);
		Punkt p4 = new Punkt("D", 9, 10);
		Punkt p5 = new Punkt("F", 11, 12);
		Punkt p6 = new Punkt("G", 13, 14);
		Punkt p7 = new Punkt("H", 15, 16);

		PrintWriter out = new PrintWriter(System.out, true);
		Punkt[] punkter = { p1, p2, p3, p4, p5, p6, p7 };
		Polylinje polylinje1 = new Polylinje(punkter);

		out.println(polylinje1.toString());

		Punkt p8 = new Punkt("E", 10, 12);
		polylinje1.laggTillFramfor(p8, "C");
		out.println(polylinje1.toString());

		polylinje1.taBort("B");
		out.println(polylinje1.toString());
		out.println(polylinje1.langd());

		Polylinje.PolylinjeIterator a = polylinje1.new PolylinjeIterator();
		a.printPunkt();
	}

}
