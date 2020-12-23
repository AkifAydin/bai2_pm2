package coreservlets.missing;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {

	public static <T> void printStreamAsList(
				Stream<T> s, String message) {
		System.out.printf("%s: %s.%n" 
				,message
				,s.collect(Collectors.toList()));
	}
}
