package klassenmethoden;
import static util.Printer.*;

public class StaticMethodVarsDemo {

	public static void printClass() {p("StaticMethodVarsDemo");}
	
	public static void main(String[] args) {
		StaticMethodVarsDemo c = new StaticMethodVarsDemo();
		StaticMethodVarsDemo cs = new StaticMethodVarsSub();
		
		cs.printClass();
		c.printClass();
	}

}

class StaticMethodVarsSub extends StaticMethodVarsDemo{
	
	public static void printClass() {p("StaticMethodVarsSub");}
}
