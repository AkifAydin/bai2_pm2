package bestellung;

import java.util.ArrayList;

public class Bestellung {
	private String bestnr;
	private ArrayList<Position> positionen= new ArrayList<Position>();

	public Bestellung(String bestnr){
		this.bestnr= bestnr;
	}
	public boolean add(Position p){
		return positionen.add(p);
	}	
	@Override
	public String toString() {
		return String.format("B(%1$s,%2$s)", bestnr, positionen);
	}
}
