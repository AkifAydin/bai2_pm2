package overloadoverrideshadow;
import static util.Printer.*;

public class ShadowDemo {

	public static void main(String[] args) {
		A b = new B();
		b.showMe();
		((B)b).showMe();
		b.thatsMe();
		((B)b).thatsMe();
	}
	

}

class A {
	static void showMe(){
		p("A");
	}
	private void inMe(){
		p("inA");
	}
	void thatsMe(){
		inMe();
	}
}

class B extends A{
	static void showMe(){
		p("B");
	}	
	private void inMe(){
		p("inB");
	}
}

