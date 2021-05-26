package de.hawhh.informatik.generics.limits;
import static util.Printer.*;

import de.hawhh.informatik.generics.node.Node;

public class GenericsSevereWarnings {
	public static void main(String[] args) {
		Node<Integer> ni = new Node<Integer>(19);
		// ok Methode akzeptiert Doubles
		ni.setAnyNumber(39.6);
		// Zugriff auf Info offenbart das
		// Ausmaß der Katastrophe
		// ClassCastException
		Integer nint = ni.getInfo();
				
		Liste<Integer> li = new Liste<Integer>();
		// statischer Typ von li.elements: Integer[]
		// nach Type-Erasure: Object[]
		// Zuweisung erlaubt, aber Laufzeitfehler
		// ClassCastException
		Integer[] ielems = li.intern;
//
//		// erlaubt
		Object[] oi = li.intern;
		oi[0]  = 35;
//		// Laufzeitfehler: ClassCastException
		p(li.intern[0]);
//		// Type-Erasure übersetzt in
		p(((Integer[])li.intern)[0]);

		// li.intenr liefert immer Object[]
		// wegen Type-Erasure in Liste<T>
		// Object[] nicht kompatibel zu Integer[]
		li.intern[1]= 56;
		// Type-Erasure übersetzt in
		((Integer[])li.intern)[1]= 56;
		// 
		// Argumentation wie bei Elementzugriff
		
		// beides ok
		li.set(1,45);
		p(li.get(1));
		// Type-Erasure übersetzt in
		 li.set(1,(Integer)45);
		 p((Integer)li.get(1));
		// 
		// Da nur Integer Werte in dem Array stehen
		// ist der Zugriff typsicher. 
		// Integer ist immer kompatibel zu Object.
		
	}
}
