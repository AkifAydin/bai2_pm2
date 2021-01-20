package fahrzeugev1;

import java.util.List;

public class Reisebus extends Bus {

	public Reisebus(boolean lizenz, List<Integer> tarife, String antriebsart,
			double co2, double hoechstgewschindigkeit,
			double kraftstoffverbrauch, int leistung, int plaetze) {
		super("Unknown", "Unknown", 1000, lizenz, tarife, "Diesel", co2, 100,
				30, 300, plaetze);
	}
}