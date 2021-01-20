package anwendungen.fahrzeuge;

import static util.Printer.p;

import java.util.ArrayList;
import java.util.List;

import fahrzeugev2.Faehrschiff;
import fahrzeugev2.LinienBus;
import fahrzeugev2.Motorisiert;
import fahrzeugev2.OeffentlichesVerkehrsmittel;
import fahrzeugev2.PersonenBefoerderung;
import fahrzeugev2.Privatfahrzeug;
import fahrzeugev2.Reisebus;
import fahrzeugev2.Rikscha;
import fahrzeugev2.Taxi;

public class Anwendungenv2 {


	public static void main(String[] args) {
		
		//kapazitaetPruefen();
		lizenzenPruefen();
		co2Ausstoss();
	}

	private static void co2Ausstoss() {
		List<Motorisiert> lm = new ArrayList<Motorisiert>();
		Faehrschiff f1 = new Faehrschiff();
		LinienBus b2  = new LinienBus();	
		Reisebus r1  = new Reisebus();
		Privatfahrzeug pf = new Privatfahrzeug();
		Taxi tx = new Taxi();
		lm.add(f1);
		lm.add(b2);
		lm.add(r1);
		lm.add(pf);
		lm.add(tx);
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
		List<PersonenBefoerderung> lpb = new ArrayList<>();
		LinienBus b1 = new LinienBus();
		Faehrschiff f1 = new Faehrschiff();
		Rikscha rk = new Rikscha();
		Taxi tx = new Taxi();
		
		lpb.add(b1);
		lpb.add(f1);
		lpb.add(rk);
		lpb.add(tx);
		
		List<PersonenBefoerderung>  lpbl= lizenzenPruefen(lpb);
		p(lpbl);
	}

	private static List<PersonenBefoerderung> lizenzenPruefen(
			List<PersonenBefoerderung> lpb) {
		List<PersonenBefoerderung> mitLizenz = new ArrayList<PersonenBefoerderung>();
		for (PersonenBefoerderung pb : lpb) {
			if(! pb.lizenz()){
				mitLizenz.add(pb);
			}
		}
		return mitLizenz;
	}

	private static void kapazitaetPruefen(){
		// Kapazitaet offentlicher Verkehrsmittel pruefen
		List<OeffentlichesVerkehrsmittel> loev = new ArrayList<OeffentlichesVerkehrsmittel>();
		
		LinienBus b1 = new LinienBus();
		Faehrschiff f1 = new Faehrschiff();
		LinienBus b2  = new LinienBus();	
		
		loev.add(b1);
		loev.add(b2);
		loev.add(f1);
		
		int zaehlung = 500;
		boolean ausreichend = kapazitaetPruefen(loev,500);
		p("Kapazitaet ausreichend? " + ausreichend);
		
	}
	
	private static boolean kapazitaetPruefen(
			List<OeffentlichesVerkehrsmittel> loev, int i) {
		int kap = 0;
		for (OeffentlichesVerkehrsmittel oev : loev) {
			// FEHLER kap += oev.plaetze();
			if (kap < i) return false;
		}
		return true;
	}

}
