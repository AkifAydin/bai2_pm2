package assertions;

public class GGTAssertionSample {
	
	public static int ggt(int m, int n) {
		int r;
		int result = n;
		while (Math.abs(r = m % result) > 0) {
			m = n;
			result = r;
		}
		// result = Math.abs(result);
		assert result > 0: "ggt nicht positiv";
		assert m%result == 0: "ggt ist kein Teiler des 1'ten Arguments";
		assert n%result == 0: "ggt ist kein Teiler des 2'ten Arguments";
		return result;
	}


	public static void main(String[] args) {
		if (args.length < 2) throw new IllegalArgumentException("expecting 2 numeric args");
		int m = Integer.parseInt(args[0]);
		int n = Integer.valueOf(args[1]);

		System.out.println(ggt(m,n));
	}
	
}
