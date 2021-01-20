package overloadoverrideshadow;

public class Person {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Person other = (Person) obj;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}

	private String name;
	
	public Person(String name) {
		this.name = name;
	}

	public boolean equals(Person obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (name == null) {
			if (obj.name != null)
				return false;
		} else if (!name.equals(obj.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}


