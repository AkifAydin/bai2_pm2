package konvertierungen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListAndArray {

	public static void main(String[] args) {
		listAndArray();
		arraysAsList();
		unmodifiableLists();
	}

	private static void listAndArray() {
		List<String> lst = Arrays.asList(new String[] { "eins", "zwei", "drei" });
		Object[] objs = lst.toArray();
		//Integer[] integers =  (Integer[])lst.toArray(); // ClassCastException
		String[] strings = lst.toArray(new String[] {});
		System.out.println("lst:" + lst);
		System.out.println("objs: " + objs);
		System.out.printf("strings: " + strings);

		System.out.println(Arrays.toString(strings));
		System.out.println(Arrays.toString(objs));
	}
	

	private static void arraysAsList() {
		String[] strings = new String[] { "eins", "zwei", "drei" };
		List<String> lst = Arrays.asList(strings);
		List<String> lstDirect = Arrays.asList("eins", "zwei", "drei");

		System.out.println(lst);
		System.out.println(lstDirect);
		lst.set(0, "dummy");
		System.out.println(lst);
	}

	private static void unmodifiableLists() {
		List<String> lst1 = new ArrayList<String>();
		lst1.add("eins");
		lst1.add("zwei");
		lst1.clear();
		List<String> lst2 = Arrays.asList(new String[] { "eins", "zwei" });
		//lst2.clear(); // UnsupportedOperationException
		//lst2.add("anything"); // UnsupportedOperationException
		// Unwandeln in modifizierbare Listen
		lst2 = new LinkedList<String>(Arrays.asList( "eins", "zwei" ));
		lst2.clear();
		lst2.add("anything");
	}

}
