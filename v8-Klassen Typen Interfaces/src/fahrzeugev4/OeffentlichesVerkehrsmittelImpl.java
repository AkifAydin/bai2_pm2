package fahrzeugev4;

public class OeffentlichesVerkehrsmittelImpl implements
		OeffentlichesVerkehrsmittel {

	private String linie;
	private String verkehrsverbund;
	private int plaetze;

	public OeffentlichesVerkehrsmittelImpl(String linie,
			String verkehrsverbund, int plaetze) {
		this.linie = linie;
		this.verkehrsverbund = verkehrsverbund;
		this.plaetze = plaetze;
	}

	@Override
	public String linie() {
		return linie;
	}

	@Override
	public String verkehrsverbund() {
		return verkehrsverbund;
	}

	@Override
	public int plaetze() {
		return plaetze;
	}
}
