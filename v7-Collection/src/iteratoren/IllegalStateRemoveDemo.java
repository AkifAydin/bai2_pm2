package iteratoren;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IllegalStateRemoveDemo {

	public static void main(String[] args) {

		List<Integer> li = new ArrayList<Integer>(Arrays.asList(new Integer[] {
				1, 2, 1, 1, 1, 1, 6 }));
		Iterator<Integer> iiter = li.iterator();
		// Illegal State Exception
		// remove darf nur nach next aufgerufen werden
		//iiter.remove();

		// keine konkurriende Modifikationen
		while (iiter.hasNext()) {
			li.remove(3);
			if (iiter.next() % 2 == 1)
				iiter.remove();
		}
		
		// keine konkurriende Modifikationen
		Iterator<Integer> iiter2 = li.iterator();
		while (iiter.hasNext()) {
			iiter2.next();
			iiter2.remove();
			iiter.next();
		}
		
	}
}
