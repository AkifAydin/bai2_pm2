package methoden;

public class LimitedStepCounter extends StepCounter {
	private int limit;
	public LimitedStepCounter(int step,int limit){
		super(step);
		this.limit = limit;
	}
	public StepCounter inc() {
		if (getCount()+ getStep() > limit) {
			reset();
		}
		return super.inc();
	}
}
