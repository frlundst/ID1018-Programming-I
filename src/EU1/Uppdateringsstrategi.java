package eu1;

public class Uppdateringsstrategi {
	
	public static void main(String[] args) {
		int [] element = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 6, 8 };
		System.out.println(min(element));
	}
	
	public static int min(int[] element) {
		int min = 10;
		
		for (int i = 0; i < element.length; i++) {
			if(i == 0) 
				min = element[i];
			
			if(min > element[i])
				min = element[i];
		}
		return min;
	}
}