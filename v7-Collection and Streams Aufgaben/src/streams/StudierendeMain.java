package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudierendeMain {

	public static void main(String[] args) {

		// KursUtil.generiereKurse().forEach(k -> System.out.println(k));
		// StudierendeUtil.generiereStudierende().forEach(
		// e -> System.out.println(e));
		List<Studierende> studies = StudierendeUtil.generiereStudierende(); //

		System.out.println(studies);

		List<Studierende> fastFertig = studies.stream().filter(studie -> studie.getSemester() == 5)
				.collect(Collectors.toList());

		List<Studierende> byMatNr = Arrays.asList("4", "5", "111111").stream().map(StudierendeUtil::findByMatnr)
				.filter(studie -> studie != null).collect(Collectors.toList());

		Studierende studie = studies.stream().filter(st -> st.getSemester() == 24).findFirst()
				.orElse(Studierende.UNKNOWN);

		System.out.println(studie);
		// Studierende studie2 = studies.stream().filter(st -> st.getSemester()
		// == 24).findFirst().get();

		int gesamtEcts = StudierendeUtil.findByMatnr("111111").getKurse().stream().map(k -> k.getEcts()).reduce(0,
				(acc, ects) -> acc + ects);

		Map<Integer, List<Studierende>> mis = studies.stream().collect(Collectors.groupingBy(Studierende::getSemester));
		mis.entrySet().stream()
				.forEach(entry -> System.out.println("Semester: " + entry.getKey() + " Studies: " + entry.getValue()));

		// alle Ects aller Studiereden
		int alleEcts = studies.stream().map(st -> st.getKurse().stream())
				.reduce(new ArrayList<Kurs>().stream(), (acc, str) -> Stream.concat(acc, str)).map(k -> k.getEcts())
				.reduce(0, (acc, etc) -> acc + etc);
		System.out.println(alleEcts);
	}
}
