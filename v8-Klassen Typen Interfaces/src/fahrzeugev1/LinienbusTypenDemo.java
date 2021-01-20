package fahrzeugev1;

import java.util.ArrayList;

public class LinienbusTypenDemo {

	public static void main(String[] args) {
				
		LinienBus lb = new LinienBus("HVV", "N13", true, 
				new ArrayList<Integer>(), "Diesel", 30, 250 ,100,
				130);
		Bus b = lb;
		PersonenKraftfahrzeug pkf = lb;
		Fahrzeug fz = lb;
		
		// FEHLER Schiff sc = lb;
	}
}
