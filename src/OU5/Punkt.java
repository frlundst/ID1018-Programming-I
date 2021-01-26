package ou5;
import java.util.*;

public class Punkt {
	String name;
	int x;
	int y;
	
	public Punkt (String punkt_name, int punkt_x, int punkt_y) {
		name = punkt_name;
		x = punkt_x;
		y = punkt_y;
	}
	
	public String toString() {
		return "[" + name + " ," + x + " ," + y + "]";
	}
	
	public Punkt (Punkt punkt) {
		this.x = punkt.x;
		this.y = punkt.y;
		this.name = punkt.name;
	}
	
	public String getNamn () {
		return name;
	}
	
	public int getX () {
		return x;
	}
	
	public int getY () {
		return y;
	}
	
	public double avstand (Punkt punkt) {
		return Math.sqrt((x - punkt.x) * (x - punkt.x) + (y - punkt.y) * (y - punkt.y));
	}
	
	public int setX (int setX_x) {
		x = setX_x;
		return x;
	}
	
	public int setY (int setY_y) {
		y = setY_y;
		return y;
	}
	
	

}
