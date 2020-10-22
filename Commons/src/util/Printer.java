package util;

public class Printer {
	public static void print(Object s) {
		System.out.println(s);
	}

	public static void printf(String format, Object... s) {
		System.out.printf(format, s);
	}

	public static void printnb(Object s) {
		System.out.print(s);
	}
}
