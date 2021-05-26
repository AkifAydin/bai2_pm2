package util;

import java.lang.reflect.Array;

public class Printer {
	public static void print(Object s) {
		System.out.println(s);
	}
	public static void println(){
		System.out.println();
	}
	
	public static void pAry(String cmt,Object o){
		printnb(cmt+ " ");
		pAry(o);
	}
	
	public static void pAry(Object o){
		pArynb(o);
		println();
	}
	public static void pArynb(Object o){
		if (o==null) {printnb(o); return;}
		Class type = o.getClass();
		if (type.isArray()) {
				int l = Array.getLength(o);
				printnb("[");			
				for(int i = 0; i < l-1; i++){
					pArynb(Array.get(o, i)); printnb(",");
				}
				pArynb(Array.get(o, l-1)); printnb("]");
		} else {
			printnb(o);
		}
	}
	
	public static void p(Object s) {
		print(s);
	}
	public static void pnb(Object s) {printnb(s);}
	public static void printf(String format, Object... s) {
		System.out.printf(String.format(format, s));
	}
	public static void printnb(Object s){
		System.out.print(s);
	}
}


