package stringmethoden;
import static util.Printer.p;

public class StringConcat {
	public static void main(String[] args) {
		p("x1".concat("+x2=").concat("x3"));
		p("x1" + "+x2=" +"x3");
		// p("x1=".concat(4)); // Fehler
		p("x1=" + 4);
	}
}
