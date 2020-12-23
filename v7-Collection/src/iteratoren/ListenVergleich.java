package iteratoren;

import static util.Printer.p;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListenVergleich {

	public static void main(String[] args) {
		List<Integer> li1 = Arrays.asList(1,2,3,4,5);
		List<Integer> li2 = Arrays.asList(1,35);
		List<Integer> li3 = Arrays.asList(1,2,3);
		List<Integer> li4 = Arrays.asList(1,2,3,4,5,6,7,8);
		List<Integer> liEqual = Arrays.asList(1,2,3,4,5);
		p(listCompare(li1, li2));
		p(listCompare(li1, li3));
		p(listCompare(li1, li4));
		p(listCompare(li1, liEqual));
	}

	private static <T extends Comparable<? super T>> int  listCompare(List<T> l1, List<T> l2) {
		Iterator<T> l1Iter = l1.iterator();
		Iterator<T> l2Iter = l2.iterator();
		
		/*
		 * l1 und l2 unterscheiden sich in einem Element
		 */
		while (l1Iter.hasNext() && l2Iter.hasNext()) {
			
			T l1Next = l1Iter.next();
			T l2Next = l2Iter.next();
			if (l1Next.compareTo(l2Next) !=0) {
				return l1Next.compareTo(l2Next);
			}
		}
		/*
		 * l2 ist echter Präfix von l1
		 */
		if (l1Iter.hasNext() && ! l2Iter.hasNext()) {
			return 1;
		}
		/*
		 * l1 ist echter Präfix von l2
		 */
		if (l2Iter.hasNext() && ! l1Iter.hasNext()) {
			return -1;
		}
		// l1 und l2 sind inhaltsgleich
		return 0;
	}
}
