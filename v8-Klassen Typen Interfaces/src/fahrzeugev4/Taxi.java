package fahrzeugev4;

import java.util.List;

public class Taxi extends PersonenKraftfahrzeug implements PersonenBefoerderung {

	private PersonenBefoerderung pbf;

	public Taxi(Motorisiert motorisiert,PersonenBefoerderung pbf){
		super(motorisiert);
		this.pbf = pbf;
	}

	public boolean lizenz() {
		return pbf.lizenz();
	}

	public List<Integer> tarife() {
		return pbf.tarife();
	}
}