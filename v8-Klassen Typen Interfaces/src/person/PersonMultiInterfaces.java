package person;
import static util.Printer.*;

import java.util.Arrays;
public class PersonMultiInterfaces {

	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1,p2;
		p1 = new Student("Heide", "Simonis",99999999);
		p(p1);
		
		p1 = new Person("Heide", "Simonis");
		p2 = new Person("Peter", "Lustig");
		Comparable[]persAry =  new Person[]{p1,p2};
		
		Arrays.sort(persAry);
		p(Arrays.toString(persAry));
		
		Cloneable c = (Cloneable)p1.clone();
		p("p1 == p2:" + (p1 == c));
		p1.setName("Anders");
		p(p1);
		p(c);
	}
}
