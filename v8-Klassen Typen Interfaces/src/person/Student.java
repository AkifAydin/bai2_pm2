package person;

public class Student extends Person {
	
	private int matnr;

	public Student(String vorname, String name, int matnr) {
		super(vorname, name);
		this.matnr = matnr;
	}

	public int getMatnr() {
		return matnr;
	}
	
	@Override
	public String toString() {
		return String.format("S(%1$s,%2$s)",super.toString(),matnr);
	}
	
}
