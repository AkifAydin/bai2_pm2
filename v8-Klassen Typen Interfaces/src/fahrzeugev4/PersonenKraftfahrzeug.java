package fahrzeugev4;

import fahrzeugev4.Motorisiert;

public abstract class PersonenKraftfahrzeug extends Fahrzeug implements Motorisiert, PersonenFahrzeug {

	private int plaetze;
	private Motorisiert motorisiert;
	
	public PersonenKraftfahrzeug(Motorisiert motorisiert){
		this.plaetze =4;
		this.motorisiert = motorisiert;
	}
	
	public String antriebsart() {
		return motorisiert.antriebsart();
	}
	public double co2() {
		return motorisiert.co2();
	}
	public double hoechstGeschwindigkeit() {
		return motorisiert.hoechstGeschwindigkeit();
	}
	public double kraftstoffverbrauch() {
		return motorisiert.kraftstoffverbrauch();
	}
	public int leistung() {
		return motorisiert.leistung();
	}
	@Override
	public int plaetze() {
		return plaetze;
	}
}