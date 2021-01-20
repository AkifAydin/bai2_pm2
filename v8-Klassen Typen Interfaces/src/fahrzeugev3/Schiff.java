package fahrzeugev3;

import java.util.Date;

public abstract class Schiff extends Fahrzeug {
	private String heimathafen;
	private String flagge;
	private Date stapellauf;

	public Schiff() {
		this.heimathafen = "Hamburg";
		this.flagge = "NL";
		this.stapellauf = new Date();
	}
	
	public String flagge(){
		return flagge;
	}
	public double verdraengung() {
		return gewicht();
	}
	public String heimathafen(){
		return heimathafen;
	}
	public Date stapellauf() {
		return stapellauf;
	}
}