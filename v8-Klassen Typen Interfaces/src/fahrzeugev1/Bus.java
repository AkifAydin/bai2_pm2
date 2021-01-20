package fahrzeugev1;

import java.util.List;

public abstract class Bus extends PersonenKraftfahrzeug {

	private boolean lizenz;
	private List<Integer> tarife;

	public Bus(boolean lizenz, List<Integer> tarife, String antriebsart,
			double co2, double hoechstGeschwindigkeit,
			double kraftstoffverbrauch, int leistung, int plaetze) {
		super(antriebsart, co2, hoechstGeschwindigkeit, kraftstoffverbrauch,
				leistung, plaetze);
		this.lizenz = lizenz;
		this.tarife = tarife;
	}

	public Bus(boolean lizenz, List<Integer> tarife, double co2, int plaetze) {
		this("Unknown", "Unknown", 1000, lizenz, tarife, "Diesel", co2, 10, 20,
				250, plaetze);

	}

	public Bus(String name, String hersteller, double gewicht, boolean lizenz,
			List<Integer> tarife, String antriebsart, double co2,
			double hoechstgeschwindigkeit, double kraftstoffverbrauch,
			int leistung, int plaetze) {
		super(name, hersteller, gewicht, antriebsart, co2,
				hoechstgeschwindigkeit, kraftstoffverbrauch, leistung, plaetze);
		this.lizenz = lizenz;
		this.tarife = tarife;
	}

	public boolean lizenz() {
		return lizenz;
	}

	public List<Integer> tarife() {
		return tarife;
	}

}