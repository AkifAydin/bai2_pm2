package fahrzeugev4;

public class Fahrrad extends Fahrzeug implements PersonenFahrzeug {

	@Override
	public int plaetze() {
		return 1;
	}
}