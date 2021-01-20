package fahrzeugev1;

import java.util.List;

public class Rikscha extends Fahrrad  {
	private boolean lizenz;
	private List<Integer> tarife;
	
	public Rikscha(String name, String hersteller, double gewicht,int plaetze,boolean lizenz,List<Integer> tarife){
		super(name, hersteller, gewicht,plaetze);
		this.lizenz = lizenz;
		this.tarife = tarife;
	}
	public boolean lizenz() {
		return lizenz;
	}

	public List<Integer> tarife() {
		return tarife;
	}

}