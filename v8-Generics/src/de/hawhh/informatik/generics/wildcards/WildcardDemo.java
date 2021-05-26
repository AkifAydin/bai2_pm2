package de.hawhh.informatik.generics.wildcards;

public class WildcardDemo {
	public static void main(String[] args) {
		Node<?> nx;
		// Compilerfehler
		//nx.setInfo("Hello");
		// Compilerfehler
		//Integer itg = nx.getInfo();
		
		//Object o = nx.getInfo();
		//nx.setInfo(null);
		
		nx = new Node<Integer>(56);
		nx = new Node<String>("Hi");
		
		// nicht symmetrisch
		//Node<String> ns = nx;
		
		// Wildcardtypen mit Upper Type Bound
		Node<? extends Number> nb;
		Node<Double> nd; 
		Node<Integer> ni = new Node<Integer> (45);

		//nb = ni; 		//ok
		//nb = nd;		//ok
		// Compilerfehler: cannot convert ...
		//nb = new Node<String>("foo");  
		// Compilerfehler: cannot convert ...							 
		//ni = nd;  // Fehler
		//nd = ni;  // Fehler
		
		// Kovarianz von Wildcardtypen
		// Arrays: Ungeschützte Kovarianz
		Number[] a = new Integer[23];
		// Laufzeitfehler kein Compilerfehl.
		//a[0] = new Double(3.14); 
		
		// and what about Generics?
		Node<? extends Number> nbb =
					new Node<Integer>(4);
		// Compilerfehler: Schreiben nicht erlaubt
		//nbb.setInfo(3.14); 
		
		// ok Sonderfall null
		nbb.setInfo(null); 
		
		// Lesen mit Wildcardtypen
		Node<Number> nn;
		Node<Integer> nni;

		//nn.copyInfoFrom(nni);	
		// Compilerfehler ... not applicable ...
		//ni.copyInfoFrom(nn); 
   
		// Kontravarianz von Wildcardtypen
		Node<? super Number> nsn = new Node<Number>(34.5);
		// Typsicheres Schreiben auf info in nsn
		//für  Number und Subtypen
		nsn.setInfo(34.5);
		nsn.setInfo(34.5f);
		nsn.setInfo(34l);
		nsn.setInfo((short)34);
		nsn.setInfo(34);       // etc...
		
		// nsn kompatibel zu
		nsn = new Node<Object>(34);
		
		// nsn nicht kompatibel zu 
		// Node<Integer> / Node<String>
		// Compilerfehler Number kein
		// Subtyp von Integer / String
		//nsn = new Node<Integer>(34);
		//nsn = new Node<String>("hello");
		
		// Lesen in den Basistyp Integer von info 
		// nicht möglich: nsi auch kompatibel 
		// zu Node<Number>, Node<Object>
		Node<? super Integer> nsi = new Node<Number>(34.5);
		//Integer num = nsi.getInfo();
		// Lesen in Object immer möglich
		// Alles ist Object
		Object o = nsi.getInfo();
		
		// Schreiben in Objekte mit Lower Typbound
		Node<String> ns  = new Node<String>("hello");
		Node<Object> no1 = new Node<Object>(new Object()); 
		Node<Integer> ni1 = new Node<Integer>(34);
		ns.copyInfoTo(no1);
		// Compilerfehler: ni1 nicht kompatibel zu Node<? super String>
		//ns.copyInfoTo(ni1);
	}
}
