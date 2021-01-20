package fahrzeugev4;

public abstract class Motorschiff extends Schiff implements Motorisiert {

	private Motorisiert motorisiert;

	public Motorschiff(Motorisiert motorisiert) {
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
}