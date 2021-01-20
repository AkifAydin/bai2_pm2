package fahrzeugev1;

public  abstract class PersonenKraftfahrzeug extends Fahrzeug  {
	
	private String antriebsart = "";
	private double co2;
	private double hoechstGeschwindigkeit;
	private  double kraftstoffverbrauch;
	private int leistung;
	private int plaetze;
	
	public PersonenKraftfahrzeug(String antriebsart, double co2,
			double hoechstgewschindigkeit, double kraftstoffverbrauch,
			int leistung, int plaetze) {
			this("Unknown","Unknown",1000,antriebsart,co2,hoechstgewschindigkeit,kraftstoffverbrauch,leistung,plaetze);
	}

	
	public PersonenKraftfahrzeug(String name, String hersteller, double gewicht,String antriebsart, double co2,
			double hoechstgeschwindigkeit, double kraftstoffverbrauch,
			int leistung, int plaetze) {
		super(name, hersteller, gewicht);
		this.antriebsart = antriebsart;
		this.co2 = co2;
		this.hoechstGeschwindigkeit = hoechstgeschwindigkeit;
		this.kraftstoffverbrauch = kraftstoffverbrauch;
		this.leistung = leistung;
		this.plaetze = plaetze;
	}

	public String antriebsart() {
		return antriebsart;
	}

	public double co2() {
		return co2;
	}

	public double hoechstGeschwindigkeit() {
		return hoechstGeschwindigkeit;
	}

	public double kraftstoffverbrauch() {
		return kraftstoffverbrauch;
	}

	public int leistung() {
		return leistung;
	}

	public int plaetze() {
		return plaetze;
	}
}