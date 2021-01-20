package fahrzeugev4;


import java.util.List;

public class Faehrschiff extends Motorschiff implements
		OeffentlichesVerkehrsmittel, PersonenBefoerderung {
	private double reiseGeschwindigkeit;
	private OeffentlichesVerkehrsmittel oef;
	private PersonenBefoerderung pbf;

	public Faehrschiff(double reisegeschwindigkeit, Motorisiert motorisiert,
			OeffentlichesVerkehrsmittel oef, PersonenBefoerderung pbf) {
		super(motorisiert);
		this.oef = oef;
		this.pbf = pbf;
		this.reiseGeschwindigkeit = reisegeschwindigkeit;
	}

	public double reiseGeschwindigkeit() {
		return reiseGeschwindigkeit;
	}

	@Override
	public String linie() {
		return oef.linie();
	}

	@Override
	public String verkehrsverbund() {
		return oef.verkehrsverbund();
	}

	@Override
	public boolean lizenz() {
		return pbf.lizenz();
	}

	@Override
	public List<Integer> tarife() {
		return pbf.tarife();
	}

	@Override
	public int plaetze() {
		return oef.plaetze();
	}

}