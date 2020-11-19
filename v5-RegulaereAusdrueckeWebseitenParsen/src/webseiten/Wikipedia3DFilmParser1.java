package webseiten;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Wikipedia3DFilmParser1 {

	/*
	 * Reguläre Ausdrücke für das Parsen der Datei
	 */
	private Pattern threeDeeBegin = Pattern
			.compile("<h2><span class=\"mw-headline\" id=\"3D-Filme\">3D-Filme</span>.*?</h2>");
	private Pattern threeDeeEnd = Pattern
			.compile("<h2><span class=\"mw-headline\" id=\"4D-Filme\">4D-Filme</span>.*?</h2>");
	// Die Option Pattern.MULTILINE|Pattern.DOTALL bewirkt, dass auch Zeilenumbrüche mit dem . matchen
	private Pattern threeDeeEnum = Pattern.compile(
			"<h3>.*?<span class=\"mw-headline\" id=.*?>(.*?)</span>.*?</h3>(.*?)</ul>",
			Pattern.MULTILINE | Pattern.DOTALL);
	private Scanner wiki3DFilmScanner = null;
	private Pattern liPattern = Pattern.compile("<li>(.*?)</li>");
	// private Pattern liPattern = Pattern.compile("<li>(?:<a .+?>(.+?)</a>)?(.*?)</li>");
	// private Pattern liPattern = Pattern.compile("<li>(?:<a .+?>(.+?)</a>)?(.+?)?(?:<a .+?>(.+?)</a>(.+?))?</li>");
	// private Pattern liPattern = Pattern.compile("<li>(?:<a .+?>(.+?)</a>)?(.+?)?(?:<a .+?>(.+?)</a>(.+?))?(?:<a .+?>(.+?)</a>(.+?))?</li>");

	/**
	 * Konstruktor öffnet einen InputStream für eine URL und erzeugt einen
	 * Scanner für das Lesen der Quelle. Hier handelt es sich um eine HTML
	 * formatierte Seite. Das Encoding wird auf UTF-8 gesetzt. (Encodings können
	 * in dem Metainformationen einer HTML-Seite nachgesehen werden).
	 * 
	 * @param uri
	 *            eine URI als Zeichenkette dargestellt.
	 * @throws MalformedURLException:
	 *             uri ist eine ungültige Darstellung einer URL
	 * @throws IOException:
	 *             Beim Öffnen des InputStreams einer URL ist ein Fehler
	 *             aufgetreten
	 */
	public Wikipedia3DFilmParser1(String uri) throws MalformedURLException, IOException {
		wiki3DFilmScanner = new Scanner(new URL(uri).openStream(), "UTF-8");
	}

	/**
	 * Konstruktor delegiert an den ersten Konstruktor und wandelt zuvor den
	 * Pfad in eine absoluten Pfad und dann einen Zeichenkette um.
	 * 
	 * @param path
	 *            eine Pfaddarstellung einer Ressource im Dateisystem
	 * @throws MalformedURLException
	 * @throws IOException
	 */
	public Wikipedia3DFilmParser1(Path path) throws MalformedURLException, IOException {
		this(path.toAbsolutePath().toString());
	}

	/**
	 * Liest den Inhalt einer Ressource zeilenweise und gibt diesen auf der
	 * Konsole aus. Dies ist sinnvoll, um sich einen Überblick über den Aufbau
	 * der Seite zu verschaffen.
	 * 
	 * @return void
	 */

	public void echoPage() {
		while (wiki3DFilmScanner.hasNextLine()) {
			System.out.println(wiki3DFilmScanner.nextLine());
		}
	}

	/**
	 * Liest den Inhalt der Wiki 3D Filmseite und wandelt diesen in ein
	 * "3D-Film-Verzeichnis" um. Positioniert den Scanner vor dem Inhalt, der
	 * die Aufzählungen für die 3D-Filme enthält. Beendet das Parsen am Ende
	 * dieser Aufzählungen.
	 * 
	 * Gelesen wird "in memory": Der Bereich, der zwischen Beginn und Ende der
	 * Aufzählungen für die 3D Filme steht wird einmal in eine Zeichenkette
	 * gelesen, die dann mit Pattern-Matchern weiterverarbeitet wird.
	 * 
	 * @return Verzeichnis, das einzelnen Jahren oder Intervallen von Jahren die
	 *         Liste der in diesen Zeiträumen erschienenen 3D File zuordnet.
	 */
	public Map<String, List<String>> contentTo3DFilmsPerYear() {
		Map<String, List<String>> threeDeeMap = new HashMap<>();
		// Positionieren des Scanners vor dem Pattern threeDeeBegin.
		// "<h2><span class=\"mw-headline\"
		// id=\"3D-Filme\">3D-Filme</span>.*?</h2>"
		wiki3DFilmScanner.useDelimiter(threeDeeBegin);
		if (wiki3DFilmScanner.hasNext()) {
			wiki3DFilmScanner.next();
		}
		// Lesen des Bereichs bis zum Ende der Aufzählung, das durch das Pattern
		// threeDeeEnd markiert wird.
		// "<h2><span class=\"mw-headline\"
		// id=\"4D-Filme\">4D-Filme</span>.*?</h2>"
		wiki3DFilmScanner.useDelimiter(threeDeeEnd);
		if (wiki3DFilmScanner.hasNext()) {
			String filmsPerYearEnumeration = wiki3DFilmScanner.next();
			// System.out.println(filmsPerYearEnumeration);
			// Extrahieren der Aufzählung nach Jahren / Zeitspannen. Pattern
			// threeDeeEnum
			// "<h3>.*?<span class=\"mw-headline\"
			// id=.*?>(.*?)</span>.*?</h3>(.*?)</ul>"
			Matcher matcherEnum = threeDeeEnum.matcher(filmsPerYearEnumeration);
			while (matcherEnum.find()) {
				// Lesen der Jahresangabe (Gruppe 1)
				String currentDate = matcherEnum.group(1);
				if (!threeDeeMap.containsKey(currentDate)) {
					threeDeeMap.put(currentDate, new ArrayList<>());
					// Extrahieren des Bereichs der ListItems, (Gruppe 2)
					String filmListContent = matcherEnum.group(2);
					// Parsen der ListItems und Einfügen in das Verzeichnis
					contentTo3DFilmList(filmListContent, currentDate, threeDeeMap);
				}
			}
		}
		return threeDeeMap;
	}

	/**
	 * Parst aus einem String mit ListItems die Filminformation zu einer
	 * Zeitangabe und trägt diese in das "3D-Film-Verzeichnis" ein.
	 * 
	 * @param ulList
	 *            Zeichenkette, die die ListItems enthält
	 * @param currentDate
	 *            Zeitangabe, der Schlüssel für das Verzeichnis
	 * @param threeDeeMap
	 *            Verzeichnis, in das zu dem Schlüssel die Liste der geparsten
	 *            Filme eingetragen werden
	 */
	private void contentTo3DFilmList(String ulList, String currentDate, Map<String, List<String>> threeDeeMap) {
		// Erzeugen eines Matchers für das Extrahieren der HTML ListItems
		// (Pattern liPattern)
		// "<li>(.*)?</li>"
		Matcher liMatcher = liPattern.matcher(ulList);
		// Partielles Matching des liPatterns, für alle Items der Liste
		while (liMatcher.find()) {
			String liContent = liMatcher.group(1);
			liContent = liContent.replaceAll("<a.*?>|</a>|<i>|</i>", "");
			liContent.replaceAll("&amp;", "&");
			threeDeeMap.get(currentDate).add(liContent);
		}
	}
	
	/**
	 * Parst aus einem String mit ListItems die Filminformation zu einer
	 * Zeitangabe und trägt diese in das "3D-Film-Verzeichnis" ein.
	 * Alternative mit kompliziertem Pattern.
	 * 
	 * @param ulList
	 *            Zeichenkette, die die ListItems enthält
	 * @param currentDate
	 *            Zeitangabe, der Schlüssel für das Verzeichnis
	 * @param threeDeeMap
	 *            Verzeichnis, in das zu dem Schlüssel die Liste der geparsten
	 *            Filme eingetragen werden
	 */
	private void contentTo3DFilmList2(String ulList, String currentDate, Map<String, List<String>> threeDeeMap) {
		// Erzeugen eines Matchers für das Extrahieren der HTML ListItems
		// (Pattern liPattern)
		// "<li>(?:<a .+?>(.+?)</a>)?(.+?)?(?:<a .+?>(.+?)</a>(.+?))?(?:<a
		// .+?>(.+?)</a>(.+?))?</li>"
		Matcher liMatcher = liPattern.matcher(ulList);
		// Partielles Matching des liPatterns, für alle Items der Liste
		while (liMatcher.find()) {
			String concat = "";
			// Extraktion der Info für einen Film mit Hilfe der Gruppen des
			// liPattern
			for (int i = 1; i <= liMatcher.groupCount(); i++) {
				if (liMatcher.group(i) != null) {
					concat += liMatcher.group(i);
				}
			}
			// Hinzufügen eines Films in die Liste der Filme
			threeDeeMap.get(currentDate).add(concat);
		}
	}


}
