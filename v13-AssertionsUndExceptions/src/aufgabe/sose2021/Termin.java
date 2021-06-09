package aufgabe.sose2021;

public class Termin {

    private final Datum dat;
    private final Uhrzeit uhrzeit;
    private final String betreff;

    public Termin(Datum dat, Uhrzeit zeit, String betreff) {
        if (betreff == null) throw new IllegalArgumentException("Betreff ist null");
        this.dat= dat;
        this.uhrzeit = zeit;
        this.betreff=betreff;
    }

    @Override
    public String toString() {
        return String.format("%s %s:%s",dat,uhrzeit,betreff);
    }
}
