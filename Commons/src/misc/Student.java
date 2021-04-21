package misc;

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
		// TODO Auto-generated method stub
		return String.format("S(%1$s,%2$s)", super.toString(), matnr);
	}

	@Override
	public int compareTo(Person o) {
		if (!(o instanceof Student)) {
			return -1;
		}
		Student os = (Student) o;
		if (super.compareTo(o) == 0) {
			return matnr == os.matnr ? 0 : (matnr < os.matnr ? -1 : 1);
		}
		return super.compareTo(o);
	}
}
