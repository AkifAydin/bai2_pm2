package stringmethoden;
import static util.Printer.p;

public class StringCreate {

	public static void main(String[] args) {
		
		String s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13;
		char[] moinFolks = {'M','o','i','n',' ', 'f','o','l','k','s'};
		Person person = new  Person("Gundula", "Gause");
		
		p("LITERAL");
		p(s1 = "Moin Folks");       // Literal
		"Moin Folks".length();      // ein Literal ist ein String Objekt
		
		p("KONSTRUKTOR");
		p(s1 = new String("Moin Folks"));
		p(s4 = new String(moinFolks));
		p(s5 = new String(moinFolks, 0, 4));
		
		p("KONVERTIERUNG valueOf(...)");
		p(s6 = String.valueOf(true));            // boolean
		p(s7 = String.valueOf('M'));             // char
		p(s8 = String.valueOf(moinFolks));       // char[]
		p(s9 = String.valueOf(moinFolks, 0, 4));  
		p(s10 = String.valueOf(17.982));         // double und float
		p(s11 = String.valueOf(17.789f));
		p(s12 = String.valueOf(1345689));        // int und long
		p(s13 = String.valueOf(person));         // Objects
		
		p("OBJEKTTYPEN toString()");
		p(person.toString());
	}

}
