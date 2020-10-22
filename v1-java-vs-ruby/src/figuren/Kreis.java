package figuren;

public class Kreis extends Figur {

    private Punkt mitte;
    private double radius;

    public Kreis(Punkt mitte, double radius) {
        super();
        this.mitte = mitte;
        this.radius = radius;
    }

    public Kreis(Punkt m) {
        this(m, 1);
    }

    @Override
    public String toString() {
//        return "k(" +
//                 mitte +
//                ", " + radius +
//                ')';
        return String.format("k(%s;%.1f)", mitte, radius);
    }

    @Override
    public boolean in(Punkt p) {
        return mitte.abstand(p) <= radius;
    }
}
