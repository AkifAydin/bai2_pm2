package de.hawhh.informatik.generics.typeboundtypevar;

public class Base implements Comparable<Base> {
	@Override
	public int compareTo(Base o) {
		return 0;
	}
}

class Derived extends Base{
	public static void main(String[] args) {
		SortedNode<Base> snb;
		// CompilerFehler 
		// ... not a valid substitute ...
		// SortedNode<Derived> snd;
	}
}

