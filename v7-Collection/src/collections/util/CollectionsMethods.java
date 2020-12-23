package collections.util;

import static util.Printer.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


public class CollectionsMethods {
	public static void main(String[] args) {
		List<String> lst1 = new ArrayList<String>(
				Arrays.asList(new String[] { "eins", "zwei", "drei", "vier", "fuenf" }));
		List<Integer> lst2 = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
		p("Original: " + lst1);
		polymorphMethodsColls(lst1);
		p("Original: " + lst2);
		polymorphMethodsColls(lst2);
	}

	private static <T extends Comparable<? super T>> void polymorphMethodsColls(List<? extends T> aList) {
		p("   * executing: polymorphMethodsColls");
		p("   * shuffle, sort, reverse arbeiten destruktiv");
		Collections.shuffle(aList);
		p("random: " + aList);
		Collections.sort(aList);
		p("sort: " + aList);      
		Collections.reverse(aList);
		p("reverse: " + aList);
	}
}
