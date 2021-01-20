package person;

public class Person implements Comparable<Person>, Cloneable {
	private String vorname, name;	
	public Person(String vorname, String name) {
		this.name = name;
		this.vorname = vorname;
	}
	@Override
	public int compareTo(Person po) {
		int res = name.compareTo(po.name);
		return (res==0) ?  vorname.compareTo(po.vorname): res; 
	}
	@Override
	public  Object clone() throws CloneNotSupportedException {
		Person p = (Person)super.clone();
		return p;
	}
	// getter und setter
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return String.format("Person(%1$s,%2$s)",vorname,name) ;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
		return result;
	}

	public boolean equals(Person obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (vorname == null) {
			if (other.vorname != null)
				return false;
		} else if (!vorname.equals(other.vorname))
			return false;
		return true;
	}

	public static void main(String[] args) {

	}
}
