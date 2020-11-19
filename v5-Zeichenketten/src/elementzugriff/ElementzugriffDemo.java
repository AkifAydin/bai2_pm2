package elementzugriff;

/**
 * 
 * @author Birgit Wendholt
 * demonstriert den Elementzugriff für String-Objekte
 */

public class ElementzugriffDemo {
	public static void main(String[] args) {
		String s = "Java";
		System.out.println(s.charAt(0));
		System.out.println(s.charAt(-1)); // Laufzeitfehler
		System.out.println(s.charAt(4));  // Laufzeitfehler
		
		/*
		 * Ausgabe aller Zeichen eines Strings
		 */
		for (int i= 0; i < s.length(); i++) {
			System.out.println(s.charAt(i));
		}
	}

}
