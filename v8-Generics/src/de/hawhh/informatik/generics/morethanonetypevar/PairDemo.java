package de.hawhh.informatik.generics.morethanonetypevar;

public class PairDemo {

	public static void main(String[] args) {
		// 1. Typvariablen sind unabhängig

		Pair<String,Integer> psi;
		psi = new Pair<String,Integer>("eins",1235769);

		// 2. Typfehler

		//int i = psi.getFirst();   // Fehler 
		int j = psi.getSecond();  //ok

		// 3. Generische Typen sind gültige
		//    Typausdrücke
		Pair<String, Pair<String,Integer>> psp;
		psp = new Pair<String,			Pair<String,Integer>>("foo",psi);
		int k = psp.getSecond().getSecond();
	}
}
