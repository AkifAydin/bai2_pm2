package misc;

public class Person implements Cloneable, Comparable {
	
	private String name;
	private String vorname;
	public Person(String vorname, String name) {
		this.name = name;
		this.vorname = vorname;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "P(" + vorname + "," + name+ ")";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof Person)) {
			return -1;
		}
		Person op = (Person)o;
		return (name+vorname).compareTo(op.name+op.vorname);
	}
}
