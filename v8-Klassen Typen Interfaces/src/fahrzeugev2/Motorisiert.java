package fahrzeugev2;

public interface Motorisiert {

	public String antriebsart();

	public double hoechstGeschwindigkeit();

	public int leistung();

	public double co2(); //	kg auf 100 km

	public double kraftstoffverbrauch();
}