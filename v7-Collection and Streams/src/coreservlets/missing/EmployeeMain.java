package coreservlets.missing;

import static coreservlets.missing.StreamUtils.printStreamAsList;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.*;
import static util.Printer.p;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import coreservlets.streams.Emp;
import coreservlets.streams.EmpSamples;
import coreservlets.streams.Employee;
import coreservlets.streams.EmployeeSamples;

public class EmployeeMain {

	public static void main(String[] args) throws IOException {
		Integer[] idArray = { 1, 2, 10, 13 };
		List<Employee> empls = Stream.of(idArray).map(EmployeeUtils::findById).filter(e -> e != null)
				.filter(e -> e.getSalary() > 200000).collect(Collectors.toList());
		System.out.println(empls);
		sampleStreamCreate();
		sampleStreamConvert();
		// moreThanOnePipeline();
		forEachVersusFor();
		mapExample();
		mapNumberExample();
		mapEmployeeExample();
		firstFilterExample();
		employeeFilterExample();
		findFirstExample();
		// optionalExample();
		lazyEvaluationExample();
		limitSkipExample();
		firstComparisonExamples();
		firstComparisonExamplesV2();
		sortedExamples();
		combinedSortExample();
		minMaxExamples();
		anyAllNoneCountExamples();
		intStreamCreateExample();
		firstReduceExamples();
		reduceToMaxSalaryExample();
		collectStringsWithDelims();
		streamToMapExamples();
	}

	private static void streamToMapExamples() {

		Map<Boolean, List<Employee>> tabelleDerReichen = EmployeeSamples.getSampleEmployees().stream()
				.collect(partitioningBy(e -> e.getSalary() > 90000));
		System.out.printf("Angestellte mit Gehalt ueber 90000: %s.%n", tabelleDerReichen.get(true));
		System.out.printf("Angestellte mit Gehalt unter 90000: %s.%n", tabelleDerReichen.get(false));

		Map<String, List<Emp>> abteilungen = EmpSamples.getSampleEmps().stream().collect(groupingBy(Emp::getOffice));
		System.out.printf("Emps in Mountain View: %s.%n", abteilungen.get("Mountain View"));
		System.out.printf("Emps in NY: %s.%n", abteilungen.get("New York"));
		System.out.printf("Emps in Zurich: %s.%n", abteilungen.get("Zurich"));
	}

	private static void collectStringsWithDelims() {

		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		String nachNamen = empls.stream().map(Employee::getLastName).collect(joining(", ")).toString();
		System.out.printf("Nachnamen %s.%n", nachNamen);

	}

	private static void reduceToMaxSalaryExample() {

		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		Employee dieGlueckliche = empls.stream().reduce((e1, e2) -> e1.getSalary() >= e2.getSalary() ? e1 : e2)
				.orElse(null);
		System.out.printf("Das Glueckskind ist: %s.%n", dieGlueckliche);
	}

	private static void firstReduceExamples() {

		Double[] nums = { 1.5, 788.4, 0.45, 13.0, -0.089, -0.1 };
		Double maxWert1 = Stream.of(nums).reduce(Double.MIN_VALUE, (e1, e2) -> Double.max(e1, e2));
		Double maxWert2 = Stream.of(nums).reduce(Double.MIN_VALUE, Double::max);
		System.out.println(maxWert1);
		System.out.println(maxWert2);
		Double produkt = Stream.of(nums).reduce(1.0, (d1, d2) -> d1 * d2);
		System.out.println(produkt);
		String[] woerter = { "im", "Jahr", "der", "Schlange" };
		String konkat = Stream.of(woerter).reduce((s1, s2) -> s1 + " " + s2).orElse("");
		String konkat2 = Stream.of(woerter).reduce(String::concat).orElse("");
		System.out.println(konkat);
		System.out.println(konkat2);
	}

	private static void intStreamCreateExample() {
		/*
		 * Stream.mapToInt: Lambda Ausdruck muss auf int Werte abbilden
		 */
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		IntStream salary = empls.stream().mapToInt(e -> e.getSalary());
		System.out.printf("Salaries %s.%n", Arrays.toString(salary.toArray()));
		/*
		 * IntStream.of
		 */
		IntStream numbers = IntStream.of(1, 2, 5, 7);
		IntStream numbers2 = IntStream.of(new int[] { 798, 0, 3, 4, 5 });
		/*
		 * IntStream.range, rangeClosed
		 */
		IntStream range = IntStream.range(12, 15);
		System.out.printf("IntStream range -> %s.%n", Arrays.toString(range.toArray()));
		IntStream rangeClosed = IntStream.rangeClosed(12, 15);
		System.out.printf("IntStream rangeClosed -> %s.%n", Arrays.toString(rangeClosed.toArray()));
		/*
		 * Infinite IntStream
		 */
		IntStream infinite = new Random().ints();
		infinite.limit(100).forEach(e -> System.out.print(e + " "));
	}

	private static void anyAllNoneCountExamples() {

		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		boolean istNiemandArm = empls.stream().noneMatch(e -> e.getSalary() < 100000);
		boolean jemandReich = empls.stream().anyMatch(e -> e.getSalary() > 300000);
		boolean alleReich = empls.stream().allMatch(e -> e.getSalary() > 300000);
		long anzahlReiche = empls.stream().filter(e -> e.getSalary() > 300000).count();
		System.out.printf("Ist niemand arm? -> %s.%n", istNiemandArm);
		System.out.printf("Ist irgend jemand reich? -> %s.%n", jemandReich);
		System.out.printf("Sind alle reich? -> %s.%n", alleReich);
		System.out.printf("Anzahl der Reichen -> %d.%n", anzahlReiche);
		System.out.println("Das Leben ist ungerecht!?");
	}

	private static void minMaxExamples() {
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		Employee alphabetisch = empls
				.stream()
				.min((e1, e2) -> 
					e1.getFullName().compareTo(e2.getFullName()))
				.orElse(null);
		System.out.printf("Erster Angestellte im Alpahbet:  %s.%n", alphabetisch);

		Employee kroesus = empls
				.stream()
				.max((e1, e2) -> 
					e1.getSalary() - e2.getSalary()).orElse(null);
		System.out.printf("Krösus %s.%n", kroesus);

	}

	private static void sortedExamples() {
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		List<Employee> emplsSorted1 = empls
				.stream()
				.sorted((e1, e2) -> 
					e1.getLastName().compareTo(e2.getLastName()))
				.collect(Collectors.toList());
		System.out.printf("Angestellte nach Nachname sortiert %s.%n", emplsSorted1);
		/*
		 * limit mit sort verhält sich nicht als short-circuit Operator
		 */
		List<Employee> emps3 = empls
				.stream()
				.sorted((e1, e2) -> e1.getFirstName().compareTo(e2.getFirstName())).limit(2).collect(Collectors.toList());
		System.out.printf("Angestellte nach Vorname sortiert %s.%n", emps3);
	}

	private static void firstComparisonExamples() {
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		List<Employee> emplsSortedBySal = empls.stream().sorted((e1, e2) -> e1.getSalary() - e2.getSalary())
				.collect(Collectors.toList());
		System.out.println(emplsSortedBySal);
		// Alternative zur Bestimmung von Krösus
		Employee richest = empls.stream().max((e1, e2) -> e1.getSalary() - e2.getSalary()).get();
		Integer[] noDups = Stream.of(new Integer[] { 1, 2, 3, 4, 1, 5, 6, 3, 4, 1, 2 }).distinct()
				.toArray(Integer[]::new);
		System.out.println(Arrays.deepToString(noDups));
	}

	private static void firstComparisonExamplesV2() {
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		List<Employee> emplsSortedBySal = empls.stream()
				.sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		System.out.println(emplsSortedBySal);
		// Alternative zur Bestimmung von Krösus
		Employee richest = empls.stream()
				.max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println();
		Integer[] noDups = Stream.of(new Integer[] { 1, 2, 3, 4, 1, 5, 6, 3, 4, 1, 2 }).distinct()
				.toArray(Integer[]::new);
		System.out.println(Arrays.deepToString(noDups));
	}

	private static void combinedSortExample() {
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		List<Employee> emplsSortedCombined =
				empls.stream().sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getFirstName))
				.collect(Collectors.toList());
		System.out.println("Sortiert nach Name dann nach Vorname " + emplsSortedCombined);
	}

	private static void limitSkipExample() {
		System.out.println("limitSkipExample");
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		List<String> emplNames = empls
				.stream()
				.map(e -> e.getFirstName())
				.limit(8)
				.skip(3)
				.collect(Collectors.toList());
		System.out.printf("Names of %d employees skipping first 3: %n%s%n", 
				emplNames.size(), emplNames);

	}

	private static void lazyEvaluationExample() {
		System.out.println("lazyEvaluationExample");
		Integer[] ids = { 3, 4, 8, 15, 21, 14, 1, 22, 25 };
		Stream.of(ids).map(id -> {
			p("Suche nach Angestellter mit id " + id + ".");
			return EmployeeUtils.findById(id);
		}).filter(e -> {
			p("Pruefe auf null ");
			return e != null;
		}).filter(e -> {
			p("Pruefe Gehalt von " + e);
			return e.getSalary() > 200000;
		}).findFirst().orElse(null);
	}

	private static void optionalExample() {
		/* ein Optional erzeugen */
		Optional<Integer> oInt = Optional.of(14);
		Optional<Employee> oEmpl = Optional.empty();
		/*
		 * Operationen fuer Optional get: liefert den Wert in Optional oder
		 * generiert einen Fehler (NoSuchElementException)
		 */
		Integer anInt = oInt.get();
		Employee anEmpl = oEmpl.get(); // Fehler
		/*
		 * orElse: liefert den Wert in Optional Wenn Optional leer ist, dann das
		 * Argument von orElse
		 */
		anEmpl = oEmpl.orElse(new Employee("", "", 0, 0));
		/*
		 * Prueft, ob ein Wert enthalten ist
		 */
		boolean hasInt = oInt.isPresent();
		boolean hasEmpl = oEmpl.isPresent();

	}

	private static void findFirstExample() {
		Integer[] ints = { 14, 11, 10, 8, 7, 2, 1 };
		// wenn sicher gestellt ist, dass es ein Element gibt
		Integer erstesGerades = Stream.of(ints).filter(i -> i % 2 == 0).findFirst().get();
		p(erstesGerades);
		// wenn der Ergebnis Stream leer sein kann
		List<Employee> empls = EmployeeSamples.getSampleEmployees();
		Employee lucky = empls.stream().filter(e -> e.getSalary() > 300000).findFirst().orElse(null);
		p(lucky);
		Employee rich = empls.stream().filter(e -> e.getSalary() > 400000).findFirst().orElse(null);
		p(rich);
	}

	private static void employeeFilterExample() {
		Integer[] ids = { 14, 11, 10, 8, 7, 2, 1 };
		printStreamAsList(
				Stream.of(ids).map(EmployeeUtils::findById).filter(e -> e != null).filter(e -> e.getSalary() > 200000),
				"Salary > 200000");
	}

	private static void firstFilterExample() {
		Integer[] intAry = { 1, 2, 3, 4, 5, 6, 7, 8 };
		Integer[] gerade = Stream.of(intAry).filter(i -> i % 2 == 0).toArray(Integer[]::new);
		p(Arrays.deepToString(gerade));
		Integer[] gerade2 = Stream.of(intAry).filter(i -> i % 2 == 0).filter(i -> i > 3).toArray(Integer[]::new);
		p(Arrays.deepToString(gerade2));
	}

	private static void mapEmployeeExample() {
		Integer[] idArray = { 1, 2, 11, 14 };
		printStreamAsList(Stream.of(idArray), "ID's");
		printStreamAsList(Stream.of(idArray).map(EmployeeUtils::findById).map(e -> e.getFullName()),
				"Namen zu den ID's");
	}

	private static void mapNumberExample() {
		Double[] nums = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		printStreamAsList(Stream.of(nums), "Originale");
		printStreamAsList(Stream.of(nums).map(e -> e * e), "Quadratzahlen");
		printStreamAsList(Stream.of(nums).map(e -> e * e).map(Math::sqrt), "Wurzel der Quadratzahlen");
	}

	private static void mapExample() {
		Double[] nums = { 1.0, 2.0, 3.0, 4.0, 5.0 };
		Double[] squares = Stream.of(nums).map(e -> e * e).toArray(Double[]::new);

		Integer[] idArray = { 1, 2, 10, 13 };
		List<Employee> empls = Stream.of(idArray).map(EmployeeUtils::findById).collect(Collectors.toList());
	}

	private static void forEachVersusFor() {
		List<Employee> employees = EmployeeSamples.getSampleEmployees();
		// Ausgabe mit for
		for (Employee e : employees) {
			System.out.println(e);
		}
		// Ausgabe mit foreach
		employees.stream().forEach(e -> System.out.println(e));
	}

	private static void moreThanOnePipeline() {
		List<Employee> employees = EmployeeSamples.getSampleEmployees();
		// Richtige Verwendung: 1 Stream pro Pipeline
		employees.stream().map(e -> e.getEmployeeId()).filter(id -> id > 2).forEach(System.out::println);
		employees.stream().map(e -> e.getSalary()).filter(sal -> sal > 200000).forEach(System.out::println);

		Stream<Employee> emplStream = EmployeeSamples.getSampleEmployees().stream();
		// Fehlerhafte Verwendung: n Pipelines fuer 1 Stream
		emplStream.map(e -> e.getEmployeeId()).filter(id -> id > 2).forEach(System.out::println);
		emplStream.map(e -> e.getSalary()).filter(sal -> sal > 200000).forEach(System.out::println);
	}

	private static void sampleStreamConvert() {
		Collection<Employee> employees = EmployeeSamples.getSampleEmployees();
		List<Employee> empls = employees.stream().filter(e -> e.getSalary() > 200000).collect(Collectors.toList());
		p(empls);

		String[] words = new String[] { "one", "two", "three" };
		String[] filtered = Stream.of(words).filter(e -> e.startsWith("t")).toArray(String[]::new);
		p(Arrays.deepToString(filtered));
	}

	private static void sampleStreamCreate() throws IOException {
		// aus Collections
		List<String> words = Arrays.asList("one", "two", "three");
		Stream<String> stringStream = words.stream();
		Collection<Employee> employees = EmployeeSamples.getSampleEmployees();
		Stream<Employee> emplStream = employees.stream();

		// aus Arrays
		String[] wordAry = new String[] { "one", "two", "three" };
		stringStream = Stream.of(wordAry);

		// aus Aufzaehlungen einzelner Elemente
		stringStream = Stream.of("first", "second", "third");

		// aus Strings chars erzeugt einen IntStream
		"one".chars().forEach(e -> p((char) e));
		Stream.of("o n e".split(" ")).forEach(e -> p(e));

		// aus Dateien
		Files.list(Paths.get(".")).forEach(e -> p(e));

		// aus Streams: map, filter, sort, distinct, limit, skip
	}
}
