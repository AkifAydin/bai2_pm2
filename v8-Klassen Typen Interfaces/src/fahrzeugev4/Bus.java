package fahrzeugev4;

import java.util.List;

import fahrzeugev4.Motorisiert;
import fahrzeugev4.PersonenBefoerderung;

public abstract class Bus extends PersonenKraftfahrzeug implements PersonenBefoerderung {
	private Motorisiert motorisiert;
	private PersonenBefoerderung pbf;
	
	public Bus(Motorisiert motorisiert,PersonenBefoerderung pbf) {
		super(motorisiert);
		this.motorisiert = motorisiert;
		this.pbf = pbf;
	}

	public String antriebsart() {
		return motorisiert.antriebsart();
	}

	public double co2() {
		return motorisiert.co2();
	}

	public double hoechstGeschwindigkeit() {
		return motorisiert.hoechstGeschwindigkeit();
	}

	public double kraftstoffverbrauch() {
		return motorisiert.kraftstoffverbrauch();
	}

	public int leistung() {
		return motorisiert.leistung();
	}

	public boolean lizenz() {
		return pbf.lizenz();
	}

	public List<Integer> tarife() {
		return pbf.tarife();
	}
	

}