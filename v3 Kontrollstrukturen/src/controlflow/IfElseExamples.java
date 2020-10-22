package controlflow;

import static util.Printer.print;
import static util.Printer.printf;

public class IfElseExamples {

	public static void main(String[] args) {

		// Beispiel 1
		double temperature = -9.0;
		if (temperature < 0)
			print("Eiszeit");

		if (temperature < 0) {
			print("Eiszeit");
			temperature = -temperature;
			print(temperature);
		}

		// Beispiel 2
		double x = -17;
		double a;

		if (x >= 0) {
			a = x;
			print("x >= 0" + x);
			print("a = x");
		} else {
			a = -x;
			print("x < 0: " + x);
			print("a = -x");
		}

		// Beispiel 3
		int month = 5;
		int days = -1;

		if (month == 1)
			days = 31;
		else if (month == 2)
			days = 28;
		else if (month == 3)
			days = 31;
		else if (month == 4)
			days = 30;

		printf("Month %d Days %d\n ", month, days);

	}

}
