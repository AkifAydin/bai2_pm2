package util;

import java.util.Arrays;

public class Printer {

	public static void p(Object s) {System.out.println(s);}
	public static void print(Object s) {
		System.out.println(s);
	}

	public static void printf(String format, Object... s) {
		System.out.printf(format, s);
	}

	public static void printnb(Object s) {
		System.out.print(s);
	}

	public static void pAry(String msg, Object[] o) {
		System.out.println(msg+ ":" + Arrays.deepToString(o));
	}


	public static void pAry(String msg, boolean[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}

	public static void pAry(String msg, byte[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}
	public static void pAry(String msg, char[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}
	public static void pAry(String msg, short[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}

	public static void pAry(String msg, int[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}

	public static void pAry(String msg, long[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}

	public static void pAry(String msg, float[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}
	public static void pAry(String msg, double[] o) {
		System.out.println(msg+ ":" + Arrays.toString(o));
	}

	public static void pAry(Object[] o) {
		System.out.println( Arrays.deepToString(o));
	}

	public static void pAry(boolean[] o) {
		System.out.println( Arrays.toString(o));
	}

	public static void pAry(byte[] o) {
		System.out.println(Arrays.toString(o));
	}
	public static void pAry(char[] o) {
		System.out.println(Arrays.toString(o));
	}
	public static void pAry( short[] o) {
		System.out.println(Arrays.toString(o));
	}

	public static void pAry(int[] o) {
		System.out.println(Arrays.toString(o));
	}

	public static void pAry(long[] o) {
		System.out.println(Arrays.toString(o));
	}

	public static void pAry(float[] o) {
		System.out.println(Arrays.toString(o));
	}
	public static void pAry(double[] o) {
		System.out.println(Arrays.toString(o));
	}

}
