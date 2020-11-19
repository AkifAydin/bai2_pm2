package allgemein;
import static util.Printer.p;
public class StringRegionMatches {

	public static void main(String[] args) {
		String str, s,s2;
		str = "Nachdem wir das Ziel aus unseren Augen verloren hatten, verdoppelten wir unsere Anstrengungen.";
		s = "Er ging mit offenen Auges durch die Welt.";
		s2 = "Parlament: Offene Aussprache";
		p(str.regionMatches(33,s, 20, 4));
		p(str.substring(33,37));
		p(s.substring(20, 24));
		p(s.indexOf("off"));
		p(s2.indexOf("Off"));
		p(s.regionMatches(12,s2, 11, 5));		
		p(s.regionMatches(true,12,s2, 11, 5));
		p(s.substring(12, 17));
		p(s2.substring(11,16));
	}
}
