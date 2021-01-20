package fahrzeugev1;

public class Privatfahrzeug extends PersonenKraftfahrzeug {

	public Privatfahrzeug(String name, String hersteller, double gewicht,String antriebsart, double co2,
			double hoechstgewschindigkeit, double kraftstoffverbrauch,
			int leistung, int plaetze) {
		super(name, hersteller,gewicht,antriebsart, co2, hoechstgewschindigkeit, kraftstoffverbrauch, leistung,
				plaetze);
	}

}