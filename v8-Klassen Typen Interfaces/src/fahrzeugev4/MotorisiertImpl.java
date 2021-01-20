package fahrzeugev4;

public class MotorisiertImpl implements Motorisiert {
	
	private double hoechstGeschwindigkeit;
	private String antriebsart;
	private double co2;
	private int leistung;
	private double kraftstoffverbrauch;

	public MotorisiertImpl(String antriebsart,int leistung, double hoechstGeschwindigkeit,double kraftstoffverbrauch,double co2) {
		this.co2 = co2;
		this.antriebsart = antriebsart;
		this.kraftstoffverbrauch = kraftstoffverbrauch;
		this.hoechstGeschwindigkeit = hoechstGeschwindigkeit;
		this.leistung = leistung;
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
