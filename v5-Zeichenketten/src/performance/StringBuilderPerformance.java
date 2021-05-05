package performance;

public class StringBuilderPerformance {
	public static void main(String[] args) {
		String harmless = "harmless";
		//int upperBound = Integer.parseInt(args[0]);
		int start = 100000;
		int iterations=5;
		stringBuildConcatRepeat(harmless,5, start);
		//stringBuildConcat(harmless, upperBound);
	}

	private static void stringBuildConcatRepeat(String str, int repeat, int start) {
		for (int i=0; i <repeat; i++) {
			stringBuildConcat(str,start);
			start *=2;
		}

	}
	private static void stringBuildConcat(String harmless, int upperBound) {
		long time = -System.nanoTime();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < upperBound; i++) {
			sb.append(harmless);
		}
		time += System.nanoTime();
		System.out.println("Builder Iterationen " + upperBound + " "+ time / 1.0e-6 + " ms");
	}

}
