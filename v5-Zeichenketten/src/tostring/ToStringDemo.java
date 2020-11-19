package tostring;
import static util.Printer.*;
public class ToStringDemo {

	public static void main(String[] args) {

		Rational r = new Rational(3, 4);
		p("Rational r is " + r);
		p("Rational r is " + r.toString());
	}
}
