package zerlegen;

import java.util.Arrays;
import java.util.regex.Pattern;

import static util.Printer.p;

public class StringSplitDemo {

	public static void main(String[] args) {
	
		useSplitOfString();
		System.out.println("!------------------------------------------!");
		useSplitOfPattern();
	}

	
	private static void useSplitOfString() {
		
		String str = "Eins $ one  , zwei $ two  ,  drei $ three";

		String[] colonSep = str.split(",");
		String[] multiSep = str.split(",|\\$");
		String[] colonWithSpaceSep = str.split("\\s*,\\s*");
		String[] multiWithSpaceSep = str.split("\\s*,\\s*|\\s*\\$\\s*");

		p(Arrays.deepToString(colonSep));
		p(Arrays.deepToString(multiSep));
		p(Arrays.deepToString(colonWithSpaceSep));
		p(Arrays.deepToString(multiWithSpaceSep));		

	}
	
	private static void useSplitOfPattern() {
		
		String str = "Eins $ one  , zwei $ two  ,  drei $ three";
		
		Pattern colonSep = Pattern.compile(",");
		Pattern multiSep = Pattern.compile(",|\\$");
		Pattern colonWithSpaceSep = Pattern.compile("\\s*,\\s*");
		Pattern multiWithSpaceSep = Pattern.compile("\\s*,\\s*|\\s*\\$\\s*");
		
		p(Arrays.deepToString(colonSep.split(new StringBuilder(str))));
		p(Arrays.deepToString(multiSep.split(str)));
		p(Arrays.deepToString(colonWithSpaceSep.split(str)));
		p(Arrays.deepToString(multiWithSpaceSep.split(new StringBuffer(str))));
		
		
	}
}
