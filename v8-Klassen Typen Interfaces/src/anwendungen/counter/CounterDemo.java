package anwendungen.counter;


import methoden.Counter;
import methoden.LimitedStepCounter;
import methoden.StepCounter;

public class CounterDemo {

	public static void main(String[] args) {
		Counter c1 = new StepCounter(3);
		Counter c2 = new LimitedStepCounter(3,7);

		System.out.println(c1.inc().inc().inc().inc().getCount());
		System.out.println(c2.inc().inc().inc().inc().getCount());

	}

}
