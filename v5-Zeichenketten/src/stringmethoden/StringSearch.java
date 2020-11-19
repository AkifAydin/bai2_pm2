package stringmethoden;

import static util.Printer.p;

public class StringSearch {

	public static void main(String[] args) {
		String str, s;
		char c = 'v';
		str = "Nachdem wir das Ziel aus unseren Augen verloren hatten, "
				+ "verdoppelten wir unsere Anstrengungen.";
		s = "ver";
		p(str.contains(s));
		p(str.indexOf(c));
		p(str.indexOf((int) c + 2)); // char = x
		p(str.indexOf(s, str.indexOf(s) + 1));
		p(str.lastIndexOf(s));
		p(str.lastIndexOf(s, str.lastIndexOf(s) - 1));

		p("http://informatik.haw-hamburg.de".startsWith("http"));
		p("http://informatik.haw-hamburg.de/scripts/v4.pdf".endsWith("pdf"));

	}
}
