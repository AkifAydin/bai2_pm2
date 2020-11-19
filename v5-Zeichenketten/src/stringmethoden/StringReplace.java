package stringmethoden;
import static util.Printer.p;

import java.util.regex.Pattern;
public class StringReplace {

	public static void main(String[] args) {
		String str = "Auf    den Schultern   von Giganten.";
		
		p(str.replace('n','x'));
		p(str.replace("Auf","Neben"));
		
		// Mehr als zwei Leerzeichen durch eins ersetzen
		p(str.replaceFirst(" +", " "));
		p(str.replaceAll(" +", " "));
		
		// Punkt durch ! ersetzen
		// Liefert nicht das korrekte Ergebnis
		p(str.replaceFirst(".", "!"));
		p(str.replaceAll(".", "!"));
		
		// Escapen von Sonderzeichen in regex
		// liefert das gewünschte Ergebnis
		String regex1 = "\\.";
		String regex2 = Pattern.quote(".");
		p(str.replaceFirst(regex1, "!"));
		p(str.replaceAll(regex2, "!"));
	}
}
