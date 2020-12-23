package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class KursUtil {

	private static Random rand = new Random(11111);
	private static List<String> kursnamen = Arrays.asList("PM1", "PTP", "GI",
			"DB", "LB", "MP", "SE1", "SE2", "BS", "VS", "RN", "SEC");

	public static List<Kurs> generiereKurse() {
		return kursnamen.stream().map(kn -> new Kurs(kn, rand.nextInt(80))).collect(Collectors.toList());
	}
}
