package zerlegen.scanner;

import static util.Printer.p;
import static util.Printer.println;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ScannerSplitStringDemo {

	public static void main(String[] args) {

		ArrayList<MatchResult> allMatches = new ArrayList<MatchResult>();		
		// Beispiel 1: Sequenzen von Leerzeichen sind Trenner
		p("Beispiel 1");
		String str1 ="Ein    Tag    im Jahr   der   Schlange";
		Scanner scanner = new Scanner(str1);
		scanner.useDelimiter("\\s+");
		while (scanner.hasNext()){
			scanner.next();
			allMatches.add(scanner.match());
		}
		printMatches(allMatches);
		println();
		
		// Beispiel 2
		String str2 ="b2345 %    Computer $    200 &  Drucker $ 200";
		p("Beispiel 2");
		scanner = new Scanner(str2);
		allMatches = new ArrayList<MatchResult>();
		scanner.useDelimiter(Pattern.compile("\\s*(%|\\$|&)\\s*"));
		while (scanner.hasNext()) {
			scanner.next();
			allMatches.add(scanner.match());
		}
		printMatches(allMatches);
	}

	private static void printMatches(List<MatchResult> allMatches) {
		for (MatchResult match : allMatches) {
			p(String.format("%-12s %d-%d", match.group(), match.start(),
					match.end()));
		}

	}
}

