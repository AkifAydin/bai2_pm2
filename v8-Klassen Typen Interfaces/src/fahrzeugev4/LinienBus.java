package fahrzeugev4;

import fahrzeugev4.Motorisiert;
import fahrzeugev4.OeffentlichesVerkehrsmittel;
import fahrzeugev4.PersonenBefoerderung;

public class LinienBus extends Bus implements OeffentlichesVerkehrsmittel {
	private OeffentlichesVerkehrsmittel oefv;

	public LinienBus(Motorisiert motorisiert, PersonenBefoerderung pbf,OeffentlichesVerkehrsmittel oefv) {
		super(motorisiert, pbf);
		this.oefv = oefv;
	}

	public String linie() {
		return oefv.linie();
	}

	public String verkehrsverbund() {
		return oefv.verkehrsverbund();
	}
}