package original;

import java.util.Objects;

public class Punkt {

    private double y;
    private double x;

    public Punkt(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public double abstand(Punkt p) {
        if ((p.x - x) < 10e-5) {
            return Math.abs(p.y - y);
        }
        return Math.sqrt(Math.pow(p.y - y, 2) + Math.pow(p.x - x, 2));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Punkt)) return false;
        Punkt punkt = (Punkt) o;
        return Double.compare(punkt.getY(), getY()) == 0 &&
                Double.compare(punkt.getX(), getX()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getY(), getX());
    }

    @Override
    public String toString() {
        //return "(" + x+ "," + y +")";
        return String.format("(%.1f;%.1f)", x, y);
    }

}
