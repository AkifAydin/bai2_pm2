package fahrzeugev3;

import java.util.ArrayList;
import java.util.List;

public class Faehrschiff extends Motorschiff implements OeffentlichesVerkehrsmittel, PersonenBefoerderung {
	private double reiseGeschwindigkeit;
	private String verkehrsverbund;
	private String linie;
	private boolean lizenz;
	private List<Integer> tarife;
	private int plaetze;
	
	public Faehrschiff() {
		this.reiseGeschwindigkeit = 50;
		this.verkehrsverbund = "Unknown";
		this.linie ="Unknown";
		this.lizenz = false;
		this.plaetze = 500;
		this.tarife = new ArrayList<Integer>();
	}
	
	public double reiseGeschwindigkeit(){
		return reiseGeschwindigkeit;
	}
	@Override
	public String verkehrsverbund() {
		return verkehrsverbund;
	}
	@Override
	public String linie() {
		return linie;
	}

	@Override
	public boolean lizenz() {
		return lizenz;
	}

	@Override
	public List<Integer> tarife() {
		return tarife;
	}

	@Override
	public int plaetze() {
		return plaetze;
	}
}