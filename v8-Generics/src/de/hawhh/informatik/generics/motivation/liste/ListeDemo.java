package de.hawhh.informatik.generics.motivation.liste;

public class ListeDemo {
	public static void main(String[] args) {
		Liste<String> ls = new Liste<String>();
//		ls.add(34); // Compilerfehler
		//String s = ls.next();
		//p(s);
		Liste<Integer> li = new Liste<Integer>();
		li.add(34);
//		String s = li.next(); // Compilerfehler
	}
}
