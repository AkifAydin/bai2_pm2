package fahrzeugev4;

import java.util.List;

public class Rikscha extends Fahrrad implements PersonenBefoerderung {

	private PersonenBefoerderung pbf;

	public Rikscha(PersonenBefoerderung pbf) {
		this.pbf = pbf;
	}
	
	public boolean lizenz() {
		return pbf.lizenz();
	}

	public List<Integer> tarife() {
		return pbf.tarife();
	}

	@Override
	public int plaetze() {
		return 5;
	}

}