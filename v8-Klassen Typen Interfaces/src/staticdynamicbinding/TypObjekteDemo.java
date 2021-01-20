package staticdynamicbinding;

import static util.Printer.*;

public class TypObjekteDemo {
 public static void main(String[] args) {
	Base b1 = new Derived();
	Base b2 = new Base();
	Class cB1 = Derived.class;
	Class cB2 = Base.class;
	p(cB1);p(cB2);
	p(cB1==cB2);
	p(cB1== b1.getClass());
	p("hello".getClass()== String.class);
	p(cB1 instanceof Class);
	p("hello".getClass() instanceof Class);
	p(cB1.getClass());
	p(cB1.getClass() instanceof Class);
 }
}
