package iteratoren;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import static util.Printer.*;

public class LoeschenUndIterieren {

	public static void main(String[] args) {
		
		List<Integer> li = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,2,1,1,3,1,1,6}));
		Iterator<Integer> iiter = li.iterator();
		while (iiter.hasNext()){
			if (iiter.next() ==1 )
				iiter.remove();
		}
		p(li);
		li = new ArrayList<Integer>(Arrays.asList(new Integer[]{1,1,2,1,1,3,1,1,6}));
		for(int i = 0; i <li.size(); i++){
			if (li.get(i) == 1)
				li.remove(i);
		}
		p(li);
	}
}
