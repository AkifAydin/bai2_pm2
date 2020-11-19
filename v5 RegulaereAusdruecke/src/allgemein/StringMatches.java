package allgemein;
import static util.Printer.p;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringMatches {

	public static void main(String[] args) {
		// prüft ob ein oder mehr Zeichen zwischen 
		// einfachen Quotes stehen
		p( Pattern.matches( "'.*'", "'Moin Folks'" ) ); 	// true 
		p( "'Moin Folks'".matches( "'.*'" ) );          	// true 
		p( Pattern.matches( "'.*'", "''" ) );           	// true 
		p( Pattern.matches( "'.*'", "Moin Folks" ) );   	// false 
		p( Pattern.matches( "'.*'", "'Moin Folks" ) );  	// false
		Pattern pattern = Pattern.compile("'.*'");
		Matcher matcher = pattern.matcher("'Moin Folks");	
		boolean doesMatch = matcher.matches();
		p (doesMatch);
	}

}
