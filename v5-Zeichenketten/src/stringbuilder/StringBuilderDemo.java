package stringbuilder;
import static util.Printer.p;
import static util.Printer.pAry;
import stringmethoden.Person;

public class StringBuilderDemo {

	public static void main(String[] args) {
		StringBuilder sb;		
		p("StringBuilder Objekte erzeugen");
		p(sb =new StringBuilder());
		p(sb.capacity());p(sb.length());
		p(sb=new StringBuilder(50));
		p(sb.capacity());p(sb.length());
		p(sb =new StringBuilder("www.haw-hamburg.de"));
		p(sb.capacity());p(sb.length());	
		p(sb =new StringBuilder(sb));
		p(sb.capacity());p(sb.length());
		
		// Länge und Kapazität
		sb = new StringBuilder( "www.haw-hamburg.de" ); 
		int length   = sb.length();                           //  18
		int capacity = sb.capacity();                         //  34
		p(length);
		p(capacity);
		
		p("Elemente anhängen");
		p(sb.append(false));
		p(sb.append('Z'));
		p(sb.append(new char[] {'v','e','r','z','o','c','k','t'}));
		p(sb.append(sb.substring(0, 3)));
		p(sb.append(6710.987));    // analog float, long, int
		p(sb.append(new Person("Crash", "Test Dummy")));
		p(sb.append(new char[] {'v','e','r','z','o','c','k','t'},3 ,4 )); // letzter Index Länge
		
		
		sb= new StringBuilder( "www.haw-hamburg.de" ); 
		p("Zeichenketten und Zeichen abfragen");
		//----------
		String subStr = "ha";
		p(sb.charAt(0));
		//----------
		char[] cAry = new char[10];
		sb.getChars(4,6,cAry,2);
		pAry(cAry);         // Ausgabe siehe Klasse Printer
		p("");
		// sb.getChars(0,sb.length(),cAry,2);   // ArrayIndexOutOfBound 
		// cAry hat nicht genügend Speicher
		//----------		
		// p(sb.charAt(sb.length()));   // StringIndexOutOfBounds
		p(sb.indexOf(subStr));
		p(sb.indexOf(subStr,sb.indexOf(subStr)+1));
		p(sb.lastIndexOf(subStr));
		p(sb.lastIndexOf(subStr,sb.lastIndexOf(subStr)-1));
		//----------		
		p(sb.subSequence(0, 5));   // www.h
		p(sb.substring(5));        // aw-hamburg.de
		p(sb.substring(0, 5));     // www.h
		
		p("Zeichenfolgen (er)setzen und einf�gen");
		sb.setCharAt(7,'Y');		
		p(sb);
		p(sb.insert(7,true));
		p(sb.insert(7, 'X'));
		p(sb.insert(7, new char[] {'c','o','o','l'}));
		p(sb.insert(7, new StringBuffer("not so ")));
		p(sb.insert(7, 10.7));  // analog f�r float int long
		p(sb.insert(7, new char[] {'c','o','o','l'}, 1, 3));
		p(sb.insert(7, new Person("Crash", "Test Dummy")));
		p(sb.replace(7, 49, ""));
		p(sb.replace(7, 8, "-"));

		p("Zeichen(folgen) l�schen und invertieren");
		p(sb.deleteCharAt(0));
		p(sb.delete(0, 2));      // Ende Index exklusiv
		p(sb.reverse());
		p(sb);
	
		p("Vergleich StingBuilder String");
		String s = "Entspannter Morgen"; 
		StringBuilder sb1 = new StringBuilder( "Entspannter Morgen" ); 
		p( s.equals(sb) );                   // false 
		p( s.equals(sb1.toString()) );        // true 
		p( s.contentEquals(sb1) );            // true 
		
		sb1 = new StringBuilder( "www.haw-hamburg.de" ); 
		StringBuilder sb2 = new StringBuilder( "www.haw-hamburg.de" ); 
		p( sb1.equals( sb2 ) );                        // false 
		p( sb1.toString().equals( sb2.toString() ) );  // true 
		p( sb1.toString().contentEquals( sb2 ) );      // true
		
		
	}
}
