package fahrzeugev1;

import java.util.List;

public class Taxi extends PersonenKraftfahrzeug  {

	public Taxi(String name, String hersteller, double gewicht, String antriebsart, double co2, double hoechstgewschindigkeit,
			double kraftstoffverbrauch, int leistung, int plaetze) {
		super(name, hersteller,gewicht, antriebsart, hoechstgewschindigkeit, kraftstoffverbrauch, leistung,
				plaetze, plaetze);
		// TODO Auto-generated constructor stub
	}

	public boolean lizenz() {
		// TODO
		return false;
	}

	public List<Integer> tarife() {
		// TODO
		return null;
	}
}