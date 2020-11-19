package stringmethoden;
import static util.Printer.*;
public class StringExtract {

	public static void main(String[] args) {

		String str;
		str =  "Nachdem wir das Ziel aus unseren Augen verloren hatten, "
				+ "verdoppelten wir unsere Anstrengungen.";
		char[] cAry = new char[10];   
		// Teilstrings extrahieren
		p(str.substring(33,43));
		p(str.subSequence(33, 43));
		p(str.substring(str.length() - 14));
		// char Arrays extrahieren
		str.getChars(33,38, cAry, 0);
		str.getChars(33, 38, cAry, 5);
		for (char c : cAry) {
			printnb(c);
		}
		print("");
		// in char Array verwandeln
		cAry = str.toCharArray();
		for (char c : cAry) {
			printnb(c);
		}		
	}
}
