package fahrzeugev4;

import java.util.List;

public class PersonenBefoerderungImpl implements PersonenBefoerderung {

	private boolean lizenz;
	private List<Integer> tarife;
	
	public PersonenBefoerderungImpl(boolean lizenz, List<Integer> tarife) {
		this.lizenz = lizenz;
		this.tarife = tarife;
	}

	@Override
	public boolean lizenz() {
		return lizenz;
	}

	@Override
	public List<Integer> tarife() {
		return tarife;
	}
}
