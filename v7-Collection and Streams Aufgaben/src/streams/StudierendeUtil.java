package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudierendeUtil {

	private static final Random rand = new Random(2222);
	private static final int anzahl = 20;
	private static final List<String> namen = IntStream.rangeClosed(1, anzahl)
			.mapToObj(e -> "stud" + e).collect(Collectors.toList());
	private static final List<String> matnrs = IntStream.rangeClosed(1, anzahl)
			.mapToObj(e -> "11111" + e).collect(Collectors.toList());
	private static final List<Integer> semester = Arrays.asList(1, 2, 3, 4, 5,
			6);
	private static final List<Kurs> kurse = KursUtil.generiereKurse();

	private static final List<Studierende> studies;

	static {
		studies = generiereStudierende();
	}

	public static Studierende findByMatnr(String matnr) {
		return generiereStudierende().stream().filter(st -> st.getMatnr().equals(matnr)).findFirst().orElse(null);
	}

	public static List<Studierende> generiereStudierende() {

		if (studies == null) {
			List<Studierende> _studies = new ArrayList<Studierende>();
			for (int i = 0; i < anzahl; i++) {
				int kursAnzahl = rand.nextInt(kurse.size());
				Set<Kurs> meineKurse = new HashSet<Kurs>();
				for (int j = 0; j <= kursAnzahl; j++) {
					meineKurse.add(kurse.get(rand.nextInt(kurse.size())));
				}
				_studies.add(new Studierende(matnrs.get(i), namen.get(i),
						new ArrayList<Kurs>(meineKurse), semester.get(rand
								.nextInt(semester.size()))));
			}

			return _studies;
		}
		return studies;
	}

}
