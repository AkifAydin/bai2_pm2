package stringmethoden;
import static util.Printer.p;

public class StringWhitespaces {
	public static void main(String[] args) {
		String str = " \tAuf    den Schultern  von  Giganten. \n\n";
		p(str);
		p(str.trim());
	}
}
