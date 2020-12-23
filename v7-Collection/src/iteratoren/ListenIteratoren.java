package iteratoren;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import static util.Printer.*;

public class ListenIteratoren {

	public static void main(String[] args) {
		List<Character> li = new ArrayList<Character>(Arrays.asList(new Character[] { 'a', 'b', 'c' }));
		ListIterator<Character> liter = li.listIterator();

		// Listen von vorne durchlaufen
		while (liter.hasNext()) {
			p("next_i: " + liter.nextIndex());
			p("prev_i: " + liter.previousIndex());
			p("e : " + liter.next());
		}
		p("next_i: " + liter.nextIndex());
		p("prev_i: " + liter.previousIndex());

		// Listen von hinten durchlaufen
		p("-------------------------------------");
		while (liter.hasPrevious()) {
			p("next_i: " + liter.nextIndex());
			p("prev_i: " + liter.previousIndex());
			p("e : " + liter.previous());
		}
		p("next_i: " + liter.nextIndex());
		p("prev_i: " + liter.previousIndex());

	}
}
