package de.hawhh.informatik.generics.limits;
import static util.Printer.*;
import java.lang.reflect.Array;

public class GenericArray<T>  {
	
	private T[] ary;
	public T[] toAry(){
		return ary.clone();
	}	
	
/*  Do not give Array to outside, when 
 *  internal rep ist Object[] */

	public GenericArray(int cap) {
		ary = (T[])new Object[cap];
	}
	public GenericArray(int cap, Class<T> type) {
		ary = (T[])Array.newInstance(type, cap);
	}
	public void set(int index, T x){
		ary[index] = x;
	}
	public T get(int index){
		return ary[index];
	}

	public static void main(String[] args) {
		GenericArray<String> gaCorrupt = new GenericArray<String>(10);
		GenericArray<String> gaOk = new GenericArray<String>(10,String.class);
		p(gaCorrupt.toAry());
		p(gaOk.toAry().getClass());
		//String[] sAry = ga.toAry();
		// erlaubt
		Object[] oi = gaCorrupt.toAry();
		oi[0]  = "foo";
		// Laufzeitfehler: ClassCastException
		p(gaCorrupt.toAry()[0]);
		gaCorrupt.toAry()[1]= "bar";
		// beides ok vorher die fehlerhaften 
		// auskommentieren!!!!
		gaCorrupt.set(1,"foo");
		p(gaCorrupt.get(1));
	}
}