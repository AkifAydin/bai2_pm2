package stringmethoden;
import static util.Printer.p;

import java.util.Locale;

public class StringLowerUpper {
	public static void main(String[] args) {
		String s1,s2;
		s1 ="Großschreibung";
		char[] cAry = new char[s1.length()];
		s2 = s1.toUpperCase();
		p(s2);
		p(s2.toLowerCase());
		// mit Locale
		Locale germ = Locale.GERMAN;
		p(s1.toUpperCase(germ));
		p(s1.toUpperCase(germ).toLowerCase(germ));
		// Laufzeitfehler ArrayIndexOutOfBounds
		s2.getChars(0, s2.length(), cAry, 0);
	}
}
