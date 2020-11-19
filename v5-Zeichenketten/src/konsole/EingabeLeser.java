package konsole;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import static util.Printer.*;

public class EingabeLeser {

	public static void main(String[] args) throws IOException {
		BufferedReader inStream = new BufferedReader(new InputStreamReader(
				System.in));
		Integer i = 0;
		String eingabe = "";
		boolean gueltig = false;
		do {
			try {
				p("Geben Sie eine ganze Zahl ein: ");
				eingabe = inStream.readLine();
				i = Integer.parseInt(eingabe);
				gueltig = true;
			} catch (NumberFormatException nfe) {
				p("keine gueltige ganze Zahl " + eingabe);
			}
		} while (!gueltig);
		p("ok lese " + i);
	}
}
