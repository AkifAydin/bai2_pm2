package fahrzeugev1;

import java.util.Date;

public abstract class Motorschiff extends Schiff {

	private String antriebsart;
	private double hoechstGeschwindigkeit;
	private int leistung;
	private double co2;
	private double kraftstoffverbrauch;


	public Motorschiff(String name, String hersteller, double gewicht,
			String heimathafen, String flagge, Date stapellauf,String antriebsart, double hoechstGeschwindigkeit,int leistung, double co2, double kraftstoffverbrauch) {
		super(name, hersteller, gewicht, heimathafen, flagge, stapellauf);
		this.antriebsart = antriebsart;
		this.hoechstGeschwindigkeit = hoechstGeschwindigkeit;
		this.leistung = leistung;
		this.co2 = co2;
		this.kraftstoffverbrauch = kraftstoffverbrauch;
	}
	
	public String antriebsart() {
		return antriebsart;
	}

	public double hoechstGeschwindigkeit() {
		return hoechstGeschwindigkeit;
	}

	public int leistung() {
		return leistung;
	}

	public double co2() {
		return co2;
	}

	public double kraftstoffverbrauch() {
		return kraftstoffverbrauch;
	}
}