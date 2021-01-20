package fahrzeugev1;

import java.util.Date;
import java.util.List;

public class Faehrschiff extends Motorschiff {

	
	private String verkehrsverbund;
	private String linie;
	private int plaetze;
	private boolean lizenz;
	private List<Integer> tarife;

	public Faehrschiff(String name, String hersteller, double gewicht,
			String heimathafen, String flagge, Date stapellauf,
			String antriebsart, double hoechstGeschwindigkeit, int leistung,
			double co2, double kraftstoffverbrauch, String verkehrsverbund, String linie, int plaetze, boolean lizenz, List<Integer> tarife) {
		super(name, hersteller, gewicht, heimathafen, flagge, stapellauf, antriebsart,
				hoechstGeschwindigkeit, leistung, co2, kraftstoffverbrauch);
		this.verkehrsverbund = verkehrsverbund;
		this.linie = linie;
		this.plaetze = plaetze;
		this.lizenz = lizenz;
		this.tarife = tarife;
	}

	public String verkehrsverbund() {
		return verkehrsverbund;
	}

	public String linie() {
		return linie;
	}

	public int plaetze() {
		return plaetze;
	}

	public boolean lizenz() {
		return lizenz;
	}

	public List<Integer> tarife() {
		return tarife;
	}
}