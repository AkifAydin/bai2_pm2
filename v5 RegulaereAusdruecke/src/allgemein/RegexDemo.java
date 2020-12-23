package allgemein;

import static util.Printer.p;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		String selector = args[0];
		switch (selector) {
		case "quantify":
			quantifyDemo();
			break;
		case "class":
			characterClassDemo();
			break;
		case "classpre":
			characterClassPredefinedDemo();
			break;
		case "logical":
			logicalOpsDemo();
			break;
		case "greedy":
			greedyOperatorsDemo();
			break;
		case "reluctant":
			reluctantOperatorsDemo2();
			break;
		case "capture1":
			capturingGroups1();
			break;
		case "capture1_1":
			capturingGroups1_1();
			break;
		case "capture2":
			capturingGroups2();
			break;
		case "url":
			urlParse();
			break;
		case "captureback":
			capturingBackreferences();
		case "htmltag":
			htmlTagParse();
		case "changename":
			changeNameSurname();
			break;
		case "wordboundary":
			wordBoundaries();
			break;
		case "wordboundary2":
			wordBoundaries2();
			break;
		case "calendar":
			calendarFromFile();
			break;
		default:
			break;
		}

	}

	private static void quantifyDemo() {
		p("Quantifizierer");
		p(Pattern.matches("a", "aa"));
		p(Pattern.matches("a", "b"));
		p(Pattern.matches("a?", "aa"));
		p(Pattern.matches("a+", "aa"));
		p(Pattern.matches("a*", "aa"));
		p(Pattern.matches("a*", "a*"));
		p(Pattern.matches("a\\*", "a*"));
		p(Pattern.matches(Pattern.quote("a*"), "a*"));
		p(Pattern.matches("a{2}", "aa"));
		p(Pattern.matches("a{3,}", "aa"));
		p(Pattern.matches("a{1,4}", "aa"));
	}

	private static void characterClassDemo() {
		p("Zeichenklassen");
		p(Pattern.matches("[aeiou]*", "Alle Neune"));
		p(Pattern.matches("[aeioulAW ]*", "Aale Wale"));
		p(Pattern.matches("[0-9aeiou]*", "a0i7o6"));
		// Beginnt das Wort mit b gefolgt von 7 Ziffern und endet es mit %
		p("b0123345%".matches("b[0-9]{7}%"));
		// Email Adresses matchen
		p(Pattern.matches("[^@]+@.+\\.[^.]+", "Birgit.Wendholt@haw.de"));
	}

	private static void characterClassPredefinedDemo() {
		p("Vordefinierte Zeichenklassen");
		// Enthält das Wort nur Ziffern oder ist es das leere Wort
		p(Pattern.matches("\\d*", "1346"));
		p(Pattern.matches("\\d*", ""));
		p(Pattern.matches("\\d*", "aa1346"));
		// Beginnt das Wort mit zwei beliebigen Zeichen und endet mit 0-n
		// Ziffern
		p(Pattern.matches("..\\d*", "aa1346"));
		p(Pattern.matches("..\\d*", "aa"));
		// Enthält das Wort keine Ziffern
		p(Pattern.matches("\\D*", "aa1346"));
		p(Pattern.matches("\\D*", "aa Wal! \t voraus"));
	}

	private static void logicalOpsDemo() {
		p("Logische Verküpfungen");
		p(Pattern.matches("([a-z]{3}|[0-9]{3}).*", "abc 123xxxx"));
		p(Pattern.matches("([a-z]{3}|[0-9]{3}).*", "123 abcyyyy"));
		p(Pattern.matches("([a-z]{3}|[0-9]{2,3}).*", "12 abczz"));
		p(Pattern.matches("([a-z]{3}[0-9]{3}).*", "abc 123____"));
		p(Pattern.matches("([a-z]{3} [0-9]{3}).*", "abc 123ääääää"));
		p(Pattern.matches("([a-z]{3} [0-9]{2,3}).*", "123 abciiiiii"));
		p(Pattern.matches("([0-9]{2,3} [a-z]{3}).*", "12 abcuuuuuuuuuu"));
		p(Pattern.matches("Mo|Di|Mi|Do|Fr", "Mo"));
		p(Pattern.matches("M|Di|o|Fr", "Mo"));
		p(Pattern.matches("(M|D)(i|o)|Fr", "Mo"));
	}

	private static void greedyOperatorsDemo() {
		p("Gierige Quantifizierer");
		String str = "<b> Moin </b> Folks <b> Wake Up </b>";
		Pattern pattern = Pattern.compile("<b>.*</b>");
		Matcher matcher = pattern.matcher(str);

		while (matcher.find())
			p(matcher.group());
		p("");
	}

	private static void reluctantOperatorsDemo2() {
		p("Bescheidene Quantifizierer");
		String str = "<b> Moin </b> Folks <b> Wake Up </b>";
		Pattern pattern = Pattern.compile("<b>.*?</b>");
		Matcher matcher = pattern.matcher(str);
		// group() gibt den letzten Match zurück
		// start() gibt die Anfangsposition des letzten matches
		// end() die Endposition des letzten matches aus
		while (matcher.find())
			p(String.format("%1$s an Position [%2$d,%3$d]", matcher.group(),
					matcher.start(), matcher.end()));
		p("");
	}

	private static void capturingGroups1() {
		p("Gruppen eines Matches ausgeben");
		// Teilketten, die mit mindestens einer Ziffer beginnen
		// gefolgt von mindestens einem Buchstaben oder Punkt gefolgt von
		// mindestens einer Ziffer

		String regex = "((\\d+?)([a-zA-Z.]+(\\d+?)))";
		String str = "123aaaaXX.klaa756";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher(str);

		while (matcher.find()) {
			p(matcher.group(0));
			p(matcher.group(1));
			p(matcher.group(2));
			p(matcher.group(3));
			p(matcher.group(4));
		}
	}

	private static void capturingGroups1_1() {
		p("Gruppen aller Matches ausgeben");
		// Alle Teilketten, die mit mindestens einer Ziffer beginnen
		// gefolgt von mindestens einem Buchstaben oder Punkt gefolgt von
		// mindestens einer Ziffer

		String regex = "((\\d+?)([a-zA-Z.]+(\\d+?)))";
		String str = "123aaaaXX.klaa756";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher(str);

		for (int i = 0;;) {
			while (matcher.find(i)) {
				p(matcher.group(0));
				p(matcher.group(1));
				p(matcher.group(2));
				p(matcher.group(3));
				p(matcher.group(4));
				i = matcher.start() + 1;
			}
			break;
		}
	}

	private static void capturingGroups2() {
		p("Gruppen eines Matches ausgeben");
		// Teilketten, die mit genau Zeichen beginnen, gefolgt von einem
		// Leerzeichen, gefolgt von genau 3 Zeichen, gefolgt von einem
		// Leerzeichen gefolgt von genau drei Zeichen
		String regex = "-((.{2})\\s(.{3}\\s(.{3})))-";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt
				.matcher("--das-matched-nicht--Ab zwo Uhr--das-matched-nicht--");
		while (matcher.find()) {
			p(matcher.group(0));
			p(matcher.group(1));
			p(matcher.group(2));
			p(matcher.group(3));
			p(matcher.group(4));
		}
	}

	private static void urlParse() {
		p("Capturing Groups zum extrahieren von Teilzeichenketten");
		String regex = "<a href=\"(.*?)\".*?>";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt
				.matcher("<a href=\"http://haw-hamburg.de\"  HAW >");
		while (matcher.find()) {
			p(matcher.group(1));
		}
	}

	private static void capturingBackreferences() {
		p("Rückverweise");
		// Alle Zahlen, die mit der gleichen Ziffern beginnen und enden
		String regex = "\\s+?((\\d)\\d*\\2)\\s+?";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher(" 12121  34564  676786 ");
		while (matcher.find()) {
			p(matcher.group(1));
		}
	}

	private static void htmlTagParse() {
		p("HTML Tag Parse");
		String regex = "<(\\w+?)>(.*)</\\1>";
		Pattern pt = Pattern.compile(regex);
		String htmlText = "<bf> Dies ist hervorgehoben </bf> Dies ist normaler Text "
				+ "<h1> Dies ist eine �berschrift</h1>";
		Matcher matcher = pt.matcher(htmlText);
		while (matcher.find()) {
			p(matcher.group(0));
			p(matcher.group(1));
			p(matcher.group(2));
		}
	}

	private static void changeNameSurname() {
		p("Vertauschen von Name und Vorname");
		String str = "Hastig, Hugo";
		p(str);
		Pattern pt = Pattern.compile("(\\p{Alpha}+)\\s*,\\s*(\\p{Alpha}+)");
		Matcher match = pt.matcher(str);
		p(match.replaceAll("$2 $1"));
	}

	private static void wordBoundaries() {
		p("Wortgrenzen Rückverweise");
		// Zahlen, die mit den gleichen Ziffern beginnen und enden
		String regex = "\\b((\\d)\\d*\\2)\\b";
		Pattern pt = Pattern.compile(regex);
		Matcher matcher = pt.matcher("12121  34564  676786");
		while (matcher.find()) {
			p(matcher.group(1));
		}
	}

	private static void wordBoundaries2() {
		String calender = "2.11.2015, 12:30, 13:30, Labor\n"
				+ "2.11.2015, 14:00, 16:00, Masterkurs\n"
				+ "12.11.2015, 8:15, 11:30, Praktikum\n"
				+ "nonsense 2.11.2015, 9:00, 15:00, Bremen\n";
		String regex1 = "2\\.11\\.2015\\s*,(.*?)\n";
		Matcher matcher = Pattern.compile(regex1).matcher(calender);
		while (matcher.find()) {
			p(matcher.group(1));
		}
		p("");
		String regex2 = "\\b2\\.11\\.2015\\s*,(.*?)\n";
		matcher = Pattern.compile(regex2).matcher(calender);
		while (matcher.find()) {
			p(matcher.group(1));
		}
	}

	private static void calendarFromFile() {
		try (BufferedReader calReader = new BufferedReader(new FileReader(
				new File("calendar")));) {
			String calEntry;
			Pattern pattern = Pattern.compile("^2\\.11\\.2015\\s*,(.*)\\s*");
			while ((calEntry = calReader.readLine()) != null) {
				Matcher matcher = pattern.matcher(calEntry);	
				while (matcher.find()) {
					p(matcher.group(1));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
