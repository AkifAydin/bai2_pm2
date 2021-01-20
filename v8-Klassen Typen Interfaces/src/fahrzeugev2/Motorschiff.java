package fahrzeugev2;

public abstract class Motorschiff extends Schiff implements Motorisiert {

	private double hoechstGeschwindigkeit;
	private String antriebsart;
	private double co2;
	private int leistung;
	private double kraftstoffverbrauch;

	public Motorschiff() {
		this.co2 = 500;
		this.antriebsart = "Diesel";
		this.kraftstoffverbrauch = 500;
		this.leistung = 400;
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