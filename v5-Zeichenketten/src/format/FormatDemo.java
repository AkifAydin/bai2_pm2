package format;

public class FormatDemo {

	public static void main(String[] args) {

		String formatString = "Der Abstand des Punktes (%f,%f) vom Ursprung ist %f";
		double x = 1;
		double y = 2.5;
		String s = String.format(formatString, x,y,Math.hypot(x, y));
		System.out.println(s);

		System.out.println(String.format("|%4d|",23));
		System.out.printf(String.format("|%-4d|%n",23));
		System.out.printf(String.format("|%12f|%n",Math.sqrt(2)));
		System.out.printf(String.format("|%12.2f|%n",Math.sqrt(2)));
		System.out.printf(String.format("|%12f|%n",1e20));
	}
}
