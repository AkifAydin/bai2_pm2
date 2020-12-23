package iteratoren;

import static util.Printer.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class PalindromErkenner {

	public static void main(String[] args) {
		p(istPalindrom("Uhu"));
		p(istPalindrom("Trug Tim eine so helle Hose nie mit Gurt"));
		String s = "Trug Tim eine so helle Hose nie mit Gurt";
	}
	private static boolean istPalindrom(String string) {
		char[] chars = string.replaceAll("\\s","").toLowerCase().toCharArray();
		List<Character> lc = new ArrayList<>();
		for (Character c : chars) {
			lc.add(c);
		}
		ListIterator<Character> forth, back;
		forth = lc.listIterator();
		back = lc.listIterator(lc.size());
		while (forth.hasNext() && back.hasPrevious() && (back.previousIndex() > forth.nextIndex())) {
			Character cf, cb;
			if ((cf = forth.next()) != (cb = back.previous())) {
				return false;
			}
			p("f:" + cf + " b:" + cb);
		}
		return true;
	}
}
