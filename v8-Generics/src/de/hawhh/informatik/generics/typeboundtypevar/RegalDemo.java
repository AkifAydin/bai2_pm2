package de.hawhh.informatik.generics.typeboundtypevar;

public class RegalDemo {

	public static void main(String[] args) {
		Regal<Fliesen,Kiste<Fliesen>> rf = new Regal<Fliesen, Kiste<Fliesen>>();
		Kiste<Fliesen> kf = new Kiste<Fliesen>();
		kf.add(new Fliesen());
		Kiste<Lebensmittel> kl = new Kiste<Lebensmittel>();
		kl.add(new Lebensmittel());
		rf.add(kf);
		// Compilerfehler
		// The method add(Kiste<Fliesen>) in the type Regal<Fliesen,Kiste<Fliesen>> is
		// not applicable for the arguments (Kiste<Lebensmittel>)
		// rf.add(kl);
	}
}
