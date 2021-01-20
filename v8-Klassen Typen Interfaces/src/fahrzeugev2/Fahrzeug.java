package fahrzeugev2;

public abstract class Fahrzeug {
	private String name = "Umweltschädlich";
	private String hersteller = "Anonym";
	private double gewicht=35;

	
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