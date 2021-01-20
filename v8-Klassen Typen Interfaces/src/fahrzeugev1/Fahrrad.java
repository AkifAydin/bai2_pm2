package fahrzeugev1;

public class Fahrrad extends Fahrzeug  {
	
	private int plaetze;
	public Fahrrad(String name, String hersteller, double gewicht,int plaetze) {
		super(name, hersteller, gewicht);
		this.plaetze = plaetze;
	}
	public int plaetze() {
		return plaetze;
	}
}