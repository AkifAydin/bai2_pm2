package streams;

public class Kurs {


	private String name;
	private int ects;

	public Kurs(String name, int ects) {
		this.name = name;
		this.ects = ects;
	}

	public String getName() {
		return name;
	}

	public int getEcts() {
		return ects;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ects;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kurs other = (Kurs) obj;
		if (ects != other.ects)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Kurs [name=" + name + ", ects=" + ects + "]";
	}
	
}
