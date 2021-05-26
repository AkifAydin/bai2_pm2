package de.hawhh.informatik.generics.typbounds;

public class NodeTypeboundDemo {

	public static void main(String[] args) {
		// Typargumente generischer Typen
		// müssen zum Typebound kompatibel sein
		Node<Integer> ni;	// ok
		Node<Double> nd;  // ok
		Node<Number> nn;
		//Node <Object> no;  // Fehler
		//Node <String> ns;  // Fehler

		// Es gilt weiterhin 
		// Generischen Typen sind 
		// untereinander inkompatibel
		//nd = ni;  // Fehler
		//nn = nd;

	}
}
