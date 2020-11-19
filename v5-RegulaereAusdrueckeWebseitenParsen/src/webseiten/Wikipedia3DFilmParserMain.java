package webseiten;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Wikipedia3DFilmParserMain {
	private static String RESOURCE_DIR = "bin";
	public static void main(String[] args) throws MalformedURLException, IOException {

		/*
		 * Wir arbeiten mit einer lokalen Datei / Kopie einer Wikipediaseite. 
		 * Referenz auf die Datei wird als URI String übergeben: file:///<absoluter Pfad zur Datei>
		 * Path wiki3DFilmLocal = Paths.get("Listevon3D-Filmen–Wikipedia.html") erzeugt einen relativen
		 * Pfad zur der Datei (Bezug das aktuelle Projekt)
		 * wiki3DFilmLocal.toAbsolutePath() erzeugt den absoluten Pfad, der als
		 * Argument übergeben wird.
		 */
		Path wiki3DFilmLocal = Paths.get(RESOURCE_DIR+"//3DFilmeWikipedia.html");
		//Wikipedia3DFilmParser0 wp = new Wikipedia3DFilmParser0("file:///" + wiki3DFilmLocal.toAbsolutePath());
		Wikipedia3DFilmParser2 wp = new Wikipedia3DFilmParser2("file:///" + wiki3DFilmLocal.toAbsolutePath());

		/*
		 * Um direkt von der Webseite zu lesen (BITTE VORSICHT BEI NICHT
		 * GETESTETEN PROGRAMMEN) wird der Parser mit der URL der Seiten
		 * erzeugt. WebseitenParser wp1 = new
		 * WebseitenParser("https://de.wikipedia.org/wiki/Liste_von_3D-Filmen");
		 */
		
		/*
		 * Parsen der Seite und Einsammeln der Liste von 3D-Filmen eines Jahres / eines Zeitraums 
		 * in einem Verzeichnis (einer Java-Map).
		 */
		long start = System.currentTimeMillis();
		Map<String, List<String>> threeDeeMap1 = wp.contentTo3DFilmsPerYear();
		//System.out.println("Duration: " + (System.currentTimeMillis() - start) + "ms");
		ppMap(threeDeeMap1);
	}
	
	private static <K extends Comparable<? super K>> void ppMap(Map<K, List<K>> aMap) {
		List<K> al = new ArrayList<K>(aMap.keySet());
		Collections.sort(al);
		for (K key : al) {
			System.out.println(key);
			for (K o : aMap.get(key)) {
				System.out.println(o);
			}
			System.out.println();
		}
	}


}
