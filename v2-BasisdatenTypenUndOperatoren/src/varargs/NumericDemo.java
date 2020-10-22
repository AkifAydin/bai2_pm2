package varargs;

import static util.Printer.print;

class NumericDemo {
	public static int sum(int... args) {
		int sum = 0;
		for (int i : args)
			sum += i;
		return sum;
	}

	public static void main(String[] args) {

		// Varargs
		print(NumericDemo.sum(1, 2, 3, 4, 5));

		// äquivalent zu
		print(NumericDemo.sum(new int[]{1, 2, 3, 4, 5}));
	}
}


