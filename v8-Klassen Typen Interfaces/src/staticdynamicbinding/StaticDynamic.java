package staticdynamicbinding;

import static util.Printer.*;

public class StaticDynamic {

	public static void main(String[] args) {
		Base b = new Derived();
		p(b.data);
		b.md();
		p(((Derived) b).data);
		
		p("-------------");
		
		StaticBase sb = new StaticDerived();
		p(sb.data);
		p(((StaticDerived)sb).data);
		sb.pMe();
		((StaticDerived)sb).pMe();
	}
}

class Base {
	int data = 1;

	public void md() {
		p(data);
	}
}

class Derived extends Base {
	int data = 2;

	public void md() {
		p(data);
		super.md();
	}
}

class StaticBase{
	static int data = 1;
	static void pMe(){
		p("this is StaticBase");
	}
}

class StaticDerived  extends StaticBase {
	static int data = 2;
	static void pMe(){
		p("this is StaticDerived");
	}
}