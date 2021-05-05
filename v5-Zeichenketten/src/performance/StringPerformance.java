package performance;

public class StringPerformance {
	public static void main(String[] args) {
		String harmless = "harmless";
		System.out.println("started");
		int start = 50000;
		int iterations=5;
		stringConcatRepeat(harmless,iterations, start);
		//stringBuildConcat(harmless, upperBound);
	}

	private static void stringConcatRepeat(String str, int repeat, int start) {
		for (int i=0; i <repeat; i++) {
			stringConcat(str,start);
			start *=2;
		}
	}

	private static void stringConcat(String harmless, int upperBound) {
		long time = -System.currentTimeMillis();
		String becomesHarmful = "";
		for (int i = 0; i < upperBound; i++) {
			becomesHarmful = becomesHarmful + harmless;
		}
		time += System.currentTimeMillis();
		System.out.println("String Iterationen " + upperBound + " "+ time + " ms");
	}
}
