package de.hawhh.informatik.generics.typeboundtypevar;
import de.hawhh.informatik.generics.motivation.liste.Liste;

public class Kiste<W> {
	// Klasse Liste<T> muss noch geschrieben werden
	Liste<W> liste;
	public Kiste(){
		liste = new Liste<W>();
	}
	public void add(W ware){
		liste.add(ware);
	}
}
