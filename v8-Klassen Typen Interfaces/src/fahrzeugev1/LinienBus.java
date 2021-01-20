package fahrzeugev1;

import java.util.ArrayList;
import java.util.List;

public class LinienBus extends Bus {

	private String verkehrsverbund;
	private String linie;
	
	// Arbeitet mit Defaults und Konstruktorkaskade
	public LinienBus(String verkehrsverbund, String linie,boolean lizenz,
			List<Integer> tarife, double co2, int plaetze) {
		this( verkehrsverbund, linie,"Unknown", "Unknown", 1000, lizenz, tarife, "Diesel", co2, 100,
				30, 300, plaetze);
		this.verkehrsverbund = verkehrsverbund;
		this.linie = linie;
	}
	
	public LinienBus(String verkehrsverbund, String linie,String name, String hersteller, double gewicht,
			boolean lizenz, List<Integer> tarife, String antriebsart,
			double co2, double hoechstgeschwindigkeit,
			double kraftstoffverbrauch, int leistung, int plaetze) {
		super(name, hersteller, gewicht, lizenz, tarife, antriebsart, co2,
				hoechstgeschwindigkeit, kraftstoffverbrauch, leistung, plaetze);
		this.verkehrsverbund = verkehrsverbund;
		this.linie = linie;
	}

	public LinienBus(String verkehrsverbund, String linie, boolean lizenz,
			ArrayList<Integer> tarife, String antriebsart,  double hoechstGeschwindigkeit,
			double kraftstoffverbrauch, double co2, int plaetze)  {
		this(verkehrsverbund, linie, "Unknown", "Unknown", 1000, lizenz, tarife,
				antriebsart, co2, hoechstGeschwindigkeit, kraftstoffverbrauch, 1000, plaetze);
	}

	public String verkehrsverbund() {
		return verkehrsverbund;
	}

	public String linie() {
		return linie;
	}
}