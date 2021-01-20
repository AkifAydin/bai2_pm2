package fahrzeugev3;

public abstract class PersonenKraftfahrzeug extends Fahrzeug implements Motorisiert, PersonenFahrzeug {

	private int plaetze;
	private int leistung;
	private double kraftstoffverbrauch;
	private double hoechstGeschwindigkeit;
	private double co2;
	private String antriebsart;
	
	public PersonenKraftfahrzeug(){
		this.plaetze =4;
		this.leistung = 80;
		this.kraftstoffverbrauch = 8.6;
		this.co2 = 78;
		this.antriebsart = "Diesel";
	}
	
	@Override
	public String antriebsart() {
		return antriebsart;
	}

	@Override
	public double co2() {
		return co2;
	}

	@Override
	public double hoechstGeschwindigkeit() {
		return hoechstGeschwindigkeit;
	}

	@Override
	public double kraftstoffverbrauch() {
		return kraftstoffverbrauch;
	}

	@Override
	public int leistung() {
		return leistung;
	}

	@Override
	public int plaetze() {
		return plaetze;
	}
}