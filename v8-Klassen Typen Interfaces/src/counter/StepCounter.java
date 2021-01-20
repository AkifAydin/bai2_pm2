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
}
