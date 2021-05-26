package de.hawhh.informatik.generics.methods;

public class ArrayUtilsMain {

    public static void main(String[] args) {
        String[] strAry = new String[] { "foo", "foo", "bar" };
        // ok, Integer implementiert Comparable
        ArrayUtils.min(3, 1, 7);
        // ok, String implementiert Comparable
		ArrayUtils.<String>min(new String[] { "foo", "foo", "bar" });
		// Fehler, Object nicht Comparable
        //ArrayUtils.min(new Object[] {});
    }
}
