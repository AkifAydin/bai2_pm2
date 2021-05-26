package de.hawhh.informatik.generics.multipletypebounds;

public class NodeDemo {
	
	public static void main(String[] args) {
		Node<InfoDeLuxe> nidl = new Node<InfoDeLuxe>(new InfoDeLuxe());
		//Node<Info> ni = new Node<Info>(new Info()); // Fehler
	}

}
