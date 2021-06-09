package counter;

public class StepCounter extends AbstractCounter implements Counter{
	private int step;
	public StepCounter(int step) {
		this.step = step;
	}

	@Override
	public StepCounter inc() {
		setCount( count() + step);
		return this;
	}

	@Override
	public String toString() {
		return "StepCounter [step=" + step + ", count()=" + count() + "]";
	}

	public static void main(String[] args) {
		StepCounter sc = new StepCounter(2);
		sc.inc().inc().inc();
		System.out.println(sc.count());
		System.out.println(sc);
	}
}
