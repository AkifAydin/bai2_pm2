package bestellung;

public class Position {
	private String name;
	private int menge;
	private String bemerkung;

	public Position(String name, int menge, String bemerkung) {
		this.name = name;
		this.menge = menge;
		this.bemerkung = bemerkung;
	}

	public Position(String name, int menge) {
		this(name, menge, "");
	}

	public String getName() {
		return name;
	}

	public int getMenge() {
		return menge;
	}

	public String getBemerkung() {
		return bemerkung;
	}

	public String toString() {
		if (bemerkung == null | bemerkung.isEmpty()) {
			return String.format("P(%1$s,%2$d)", name, menge);
		}
		return String.format("P(%1$s,%2$d,%3$s)", name, menge, bemerkung);
	}

}