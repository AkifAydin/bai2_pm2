package counter;

public class LimitedCounter extends AbstractCounter  implements Counter {
	
	private int limit;

	public LimitedCounter(int limit){
		this.limit = limit;
	}

	@Override
	public LimitedCounter inc() {
		if (limit == count()){
			reset();
		} else {
			setCount(count()+1);
		}
		return this;
	}

	@Override
	public String toString() {
		return "LimitedCounter [limit=" + limit + ", counter()=" + count()
				+ "]";
	}	
}
