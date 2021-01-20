package fahrzeugev2;

import java.util.ArrayList;
import java.util.List;

public class Bus extends PersonenKraftfahrzeug implements PersonenBefoerderung {

	private boolean lizenz;
	private List<Integer> tarife;
	
	public Bus() {
		this.lizenz = true;
		this.tarife = new ArrayList<Integer>();
	}

	public boolean lizenz() {
		return lizenz;
	}

	public List<Integer> tarife() {
		return tarife;
	}
}