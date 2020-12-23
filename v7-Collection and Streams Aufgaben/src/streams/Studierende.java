package streams;

import java.util.ArrayList;
import java.util.List;

public class Studierende {
	
	public static final Studierende UNKNOWN = new Studierende("UNKOWN", "UNKNOWN",new ArrayList<Kurs>() , 0);
	private String matnr;
	private String name;
	private List<Kurs> kurse;
	private int semester;

	public Studierende(String matnr, String name, List<Kurs> kurse, int semester) {
		this.matnr = matnr;
		this.name =name;
		this.kurse = kurse;
		this.semester = semester;
	}

	public String getMatnr() {
		return matnr;
	}

	@Override
	public String toString() {
		return "Studierende [matnr=" + matnr + ", name=" + name + ", kurse="
				+ kurse + ", semester=" + semester + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((kurse == null) ? 0 : kurse.hashCode());
		result = prime * result + ((matnr == null) ? 0 : matnr.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + semester;
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
		Studierende other = (Studierende) obj;
		if (kurse == null) {
			if (other.kurse != null)
				return false;
		} else if (!kurse.equals(other.kurse))
			return false;
		if (matnr == null) {
			if (other.matnr != null)
				return false;
		} else if (!matnr.equals(other.matnr))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (semester != other.semester)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public List<Kurs> getKurse() {
		return kurse;
	}

	public int getSemester() {
		return semester;
	}
}
