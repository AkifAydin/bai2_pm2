package de.hawhh.informatik.generics.limits;
import de.hawhh.informatik.generics.node.Node;
import generics.node.*;

public class GenericsLimitsErros {
	
	public static void main(String[] args) {
		Broken<String> bs = new Broken<String>();
		Broken<Integer> bi = new Broken<Integer>();
	}
	
	static void errorsBaseDatatypes(){
		// erlaubt Autoboxing int -> Integer 
		Node<Integer> ni = new Node<Integer>(19);
		// erlaubt Autounboxing Integer -> int
		int info = ni.getInfo();
		// Fehler: keine Basistypen als Typargumente
		//Node<int> nint = new Node<int>(19);
	}
	
	//static <T> boolean matchesType(T x, Object o){
		// Compilerfehler
		// Cannot perform instanceof check against 
		// type parameter T. Use instead its erasure 
		// Object since generic type information will 
		// be erased at runtime
		/*if (o instanceof T) return true;
			return false;*/
	//}
}

class Broken<T> {
	// wird nicht übersetzt
	//static T data;
	//static T getData()
	//		{return data;};
}

