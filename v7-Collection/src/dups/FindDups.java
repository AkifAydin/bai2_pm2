package dups;

import java.util.HashSet;
import java.util.Set;

public class FindDups {
	public static void main(String args[]) {
		Set<String> s = new HashSet<String>();
		for (String a : args)
			if (!s.add(a))
				System.out.println("Dublikat: " + a);

		System.out.println(s.size() + " Worte ohne Dublikat: " + s);
	}
}
