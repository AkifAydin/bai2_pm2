package fahrzeugev1;

import java.util.Date;

public abstract class Schiff extends Fahrzeug {

	private String heimathafen;
	private String flagge;
	private Date stapellauf;
		
//	public String hersteller(){
//		return hersteller;
//	}

	public double verdraengung() {
		return gewicht();
	}

	public String flagge(){
		return flagge;
	}
	
	public Date stapellauf() {
		return stapellauf;
	}

	public String heimathafen() {
		return heimathafen;
	}
	public Schiff(String name, String hersteller, double gewicht,String heimathafen, String flagge, Date stapellauf ) {
		super(name, hersteller, gewicht);
		this.heimathafen = heimathafen;
		this.flagge = flagge;
		this.stapellauf = stapellauf;
	}

	
}