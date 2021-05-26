package de.hawhh.informatik.generics.multipletypebounds;
import static util.Printer.*; 
public class Info implements Printable {
	@Override
	public void print() {
		p("Info" + this.toString());
	}
}
