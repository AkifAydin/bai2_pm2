package de.hawhh.informatik.generics.typeboundtypevar;

import de.hawhh.informatik.generics.motivation.liste.Liste;

public class Regal<C, K extends Kiste<C>> {
	// Klasse Liste<K> muss moch geschrieben werden
	private Liste<K> kisten;
	public Regal(){
		kisten = new Liste<K>();
	}
	void add(K kiste){
		kisten.add(kiste);
	}
}
