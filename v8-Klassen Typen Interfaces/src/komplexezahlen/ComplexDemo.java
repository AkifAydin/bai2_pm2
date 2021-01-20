package komplexezahlen;
import static util.Printer.*;
public class ComplexDemo {

	public static void main(String[] args) {
		Complex c1= new Polar(new Cartesian(1,2));
		Complex c2= new Polar(new Polar(1.5,0.8));	
		Complex c3= new Cartesian(new Cartesian(1,2));
		Complex c4= new Cartesian(new Polar(1.5,0.8));

		p(c1.add(c2));
		p(c2.add(c3));
		p(c2.mult(c4));
		p(c3.mult(c4));
	}
}
