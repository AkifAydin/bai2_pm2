package fahrzeugev1;

public abstract class Fahrzeug {
	private String name = "";
	private String hersteller = "";
	private double gewicht;
	
	
	public Fahrzeug(String name, String hersteller, double gewicht) {
		this.name = name;
		this.hersteller = hersteller;
		this.gewicht = gewicht;
	}


	public String name() {
		return name;
	}


	public String hersteller() {
		return hersteller;
	}


	public double gewicht() {
		return gewicht;
	}

	
	
}