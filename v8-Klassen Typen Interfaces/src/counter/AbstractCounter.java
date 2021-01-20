package counter;

public abstract class AbstractCounter implements Counter {
	private int count;
	public AbstractCounter(){
		this.count =0;
	}
	@Override
	public int count() {
		return count;
	}
	protected void setCount(int count){
		this.count = count;
	}
	@Override
	public void reset() {
		count = 0;
	}
	@Override
	public abstract Counter inc();
}
