package de.hawhh.informatik.generics.typeerasure;

public class TypeErasureMaterial {
	
	public static void main(String[] args) {
		Node<String> node = new Node<String>("foo");
		String str = node.getInfo();
		
		Node nodeRaw = new Node("foo");
		str = (String)nodeRaw.getInfo();
		// wird übersetzt, erzeugt Laufzeitfehler
		Integer num = (Integer)nodeRaw.getInfo();
	}
}
