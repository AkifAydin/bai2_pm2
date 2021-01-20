package methoden;
import static util.Printer.*;

public class Counter {

	private int count;

	public Counter(){
		super();
		count =0;
	}	
	public Counter inc(){
		setCount(count+1);
		return this;
	}
	
	protected final void setCount(int count){
		this.count = count;
	}
	
	public int getCount(){
		return count;
	}
	
	public void reset(){
		setCount(0);
	}
	public static void main(String[] args) {
		Counter c1 = new Counter();
		Counter c2 = new StepCounter(2);
		Counter c3 = new LimitedStepCounter(3,10);	
		
		Class cC1 = Counter.class;
		Class cC2 = StepCounter.class;
		p(cC1==cC2);
		
		cC1 = c1.getClass();
		cC2 = c2.getClass();
		p(cC1==cC2);
		
		p(cC1);
		p(cC2);
		p(cC1.getClass());
		
		
		
		c1.inc().inc(); 
		c2.inc().inc();
		c3.inc().inc();
		p("c1 " + c1.getCount());
		p("c2 " + c2.getCount());
		p("c3 " + c3.getCount());
	}
}


