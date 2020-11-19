package stringmethoden;
import static util.Printer.p;
public class StringEquals {

	public static void main(String[] args) {
		String s1, s2;
		s1 = "Moin Folks";
		s2 = "mOin fOLks";
		p(s1.equals(s2));
		p(s1.equalsIgnoreCase(s2));

	}

}
