package de.hawhh.informatik.generics.node;

public class NodeDemo {

	public static void main(String[] args) {
		Node<Integer> ni = new Node<Integer>(2);
		Node<String> ns = new Node<String>("foo");
		
		ni.setInfo(678);
		// Compilerfehler
		// ni.setInfo("foo");  
		ni.setLeft(new Node<Integer>(15));
		// Compilerfehler
		//ni.setLeft(new Node<String>("foo")); 
		// kein Typecast
		Integer info = ni.getInfo(); 
		
		// Compilerfehler nicht typkompatibel
//		Node<Object> no = ns;
//		no = ni;
//		ns = ni;
		
		// Invarianz generischer Typen:
		// Würde diese Zeile keinen
		// Compilerfehler geben,
//		Node<Object> no = ni;
		// dann würde diese Zeile
		// einen Laufzeitfehler erzeugen.
//		no.setInfo(34.7);
		
		// Für Arrays gilt: ungeschützte
		// Kovarianz
		// Diese Zeile ist nach den Typregeln ok.
		Object[] oAry = new Integer[10];
		// Diese Zeile erzeugt einen Laufzeitfehler
		oAry[0]= 34.5;
	}
}
