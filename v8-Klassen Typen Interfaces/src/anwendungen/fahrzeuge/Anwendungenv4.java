package anwendungen.fahrzeuge;

import static util.Printer.p;

import java.util.ArrayList;
import java.util.List;

import fahrzeugev4.Faehrschiff;
import fahrzeugev4.Motorisiert;
import fahrzeugev4.MotorisiertImpl;
import fahrzeugev4.OeffentlichesVerkehrsmittel;
import fahrzeugev4.OeffentlichesVerkehrsmittelImpl;
import fahrzeugev4.PersonenBefoerderung;
import fahrzeugev4.PersonenBefoerderungImpl;

public class Anwendungenv4 {

	public static void main(String[] args) {

		kapazitaetPruefen();
		lizenzenPruefen();
		co2Ausstoss();
	}

	private static void co2Ausstoss() {
		List<Motorisiert> lm = new ArrayList<Motorisiert>();

		Motorisiert motorisiert = new MotorisiertImpl("Diesel", 500, 80, 200,
				766);
		OeffentlichesVerkehrsmittel oef = new OeffentlichesVerkehrsmittelImpl(
				"N67", "HVV", 500);
		PersonenBefoerderung pbf = new PersonenBefoerderungImpl(false,
				new ArrayList<Integer>());
		Faehrschiff f1 = new Faehrschiff(65, motorisiert, oef, pbf);
		lm.add(f1);
		double co2 = co2Ausstoss(lm);
		p("CO2 " + co2);
	}

	private static double co2Ausstoss(List<Motorisiert> lm) {
		int ausstoss = 0;
		for (Motorisiert motorisiert : lm) {
			ausstoss += motorisiert.co2();
		}
		return ausstoss;
	}

	private static void lizenzenPruefen() {
		List<PersonenBefoerderung> lpb = new ArrayList<PersonenBefoerderung>();
		Motorisiert motorisiert = new MotorisiertImpl("Diesel", 500, 80, 200,
				766);
		OeffentlichesVerkehrsmittel oef = new OeffentlichesVerkehrsmittelImpl(
				"N67", "HVV", 500);
		PersonenBefoerderung pbf = new PersonenBefoerderungImpl(false,
				new ArrayList<Integer>());
		Faehrschiff f1 = new Faehrschiff(65, motorisiert, oef, pbf);

		lpb.add(f1);

		List<PersonenBefoerderung> lpbl = lizenzenPruefen(lpb);
		p(lpbl);
	}

	private static List<PersonenBefoerderung> lizenzenPruefen(
			List<PersonenBefoerderung> lpb) {
		List<PersonenBefoerderung> lpbung = new ArrayList<PersonenBefoerderung>();
		for (PersonenBefoerderung pb : lpb) {
			if (!pb.lizenz()) {
				lpbung.add(pb);
			}
		}
		return lpbung;
	}

	private static void kapazitaetPruefen() {
		// Kapazitaet offentlicher Verkehrsmittel pruefen
		List<OeffentlichesVerkehrsmittel> loev = new ArrayList<OeffentlichesVerkehrsmittel>();

		Motorisiert motorisiert = new MotorisiertImpl("Diesel", 500, 80, 200,
				766);
		OeffentlichesVerkehrsmittel oef = new OeffentlichesVerkehrsmittelImpl(
				"N67", "HVV", 500);
		PersonenBefoerderung pbf = new PersonenBefoerderungImpl(false,
				new ArrayList<Integer>());
		Faehrschiff f1 = new Faehrschiff(65, motorisiert, oef, pbf);
		loev.add(f1);
		boolean ausreichend = kapazitaetPruefen(loev, 500);
		p("Kapazitaet ausreichend? " + ausreichend);
	}

	private static boolean kapazitaetPruefen(
			List<OeffentlichesVerkehrsmittel> loev, int i) {
		int kap = 0;
		for (OeffentlichesVerkehrsmittel oev : loev) {
			kap += oev.plaetze();
			if (kap < i)
				return false;
		}
		return true;
	}

}
