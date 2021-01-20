package fahrzeugev4;

public abstract class Fahrzeug {
	private String name = "";
	private String hersteller = "";
	private double gewicht;

	
	public String hersteller() {
		return hersteller;
	}
	public double gewicht() {
		return gewicht;
	}
	public String name() {
		return this.name;
	}
}