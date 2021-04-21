package figuren;

import original.Punkt;

public class Rechteck extends Figur {

    private Punkt lu;
    private float hoehe, breite;

    public Rechteck(Punkt lu, float hoehe, float breite) {
        super();
        this.lu = lu;
        this.hoehe = hoehe;
        this.breite = breite;
    }

    public Rechteck(Punkt lu) {
        this(lu, 1, 1);
    }

    public boolean in(Punkt p) {
        return (lu.getX() <= p.getX() && p.getX() <= lu.getX() + breite && lu.getY() <= p.getY() && p.getY() <= lu.getY() + hoehe);
    }

    public String toString() {
        // TODO Auto-generated method stub
        // return  "r("+ lu + "," + hoehe + "," + breite+ ")";
        return String.format("r(%1$s,%2$.1f,%3$.1f)", lu.toString(), hoehe, breite);
    }

}
