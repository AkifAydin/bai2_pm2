package fahrzeugev3;

import java.util.ArrayList;
import java.util.List;

public class Rikscha extends Fahrrad implements PersonenBefoerderung {

	private boolean lizenz;
	private List<Integer> tarife;

	public Rikscha() {
		this.lizenz = false;
		this.tarife = new ArrayList<Integer>();
	}
	
	public boolean lizenz() {
		return lizenz;
	}
	public List<Integer> tarife() {
	return tarife;
	}
	
	@Override
	public int plaetze() {
		return 5;
	}
}