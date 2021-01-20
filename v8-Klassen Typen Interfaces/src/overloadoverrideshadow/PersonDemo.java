package overloadoverrideshadow;
import static util.Printer.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class PersonDemo {

	public static void main(String[] args) {
		Person p1 = new Person("Ada");
		Person p2 = new Person("Ada");
		p("p1.equals(p2)" + p1.equals(p2));
		Person p3 = new Person("Ada");
		Object p4 = new Person("Ada");
		p("p3.equals(p4)" + p3.equals(p4));
		p("p4.equals(p3)" + p4.equals(p3));
		
		
		Person[] pa = {p1,p1};
		int  cntEqual = 0;
		for (Person o : pa) {
			if( o!= null && o.equals(p2)) {
				cntEqual ++;
			}
		}
		p("found p2 in " + Arrays.deepToString(pa) + " " + cntEqual + " times");
			
		Object[] oa = {p1,p1};
		System.out.println(oa);
		cntEqual = 0;
		for (Object o : oa) {
			//System.out.println(o);
			if( o!= null && o.equals(p2)) {
				cntEqual ++;
			}
		}
		p("found p2 in " +  Arrays.deepToString(oa) + " " + cntEqual + " times");
		
		
		
		List<Person> lp = new ArrayList<Person>();
		lp.add(p1);
		p(lp.contains(p2));
	}
	
}
