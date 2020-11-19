package stringmethoden;
import static util.Printer.p;
public class StringCompare {

	public static void main(String[] args) {
		p("Moin".compareTo("Morgen") < 0);
		p("Morgen".compareTo("Morgen") == 0);
		p("Morgen".compareTo("Gestern") > 0);
	}

}
