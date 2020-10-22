package basedatatypes;

public class NaNDemo {
	public static void main(String[] args) {
		Double d1 = 167.0;
		Double d2 = 0.0;
		Double d3 = d1 / d2;
		Double d4 = -d1 / d2;
		double d5 = d1 / 0.0;
		System.out.println(d3);
		System.out.println(d4);
		System.out.println(d5);
		System.out.println(Math.sqrt(-12));
	}
}
