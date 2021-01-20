package methoden;

public class StepCounter extends Counter {
	private int step;
	public StepCounter(int step){
		super();
		this.step = step;
	}
	public int getStep(){
		return step;
	}
	public StepCounter inc(){
		setCount(getCount()+step);
		return this;
	}
}
