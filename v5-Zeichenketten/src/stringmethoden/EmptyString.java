package stringmethoden;
import static util.Printer.p;

public class EmptyString {
	
	public static void main(String[] args) {
		String s1,s2,sNull;
		s1 = "";
		s2 = " ";
		sNull = null;
		p(s1.length() == 0);
		p(s2.length() == 0);
		p(s1.isEmpty());
		p(s2.isEmpty());
		p(isEmptySafe(sNull));
		p(sNull.length() == 0);
		p(sNull.isEmpty());
	}
	
	private static boolean isEmptySafe(String s){
		return s!=null && s.isEmpty();
	}
}
