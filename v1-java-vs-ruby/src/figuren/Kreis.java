package figuren;

import original.Punkt;

import java.util.ArrayList;
import java.util.List;

public class Kreis extends Figur {

    private Punkt mitte;
    private double radius;

    public Kreis(Punkt mitte, double radius) {
        super();
        this.mitte = mitte;
        this.radius = radius;
    }

    public Kreis(Punkt mitte){
        this(mitte,1);
    }

    public Kreis(){
        this(new Punkt(0,0));
    }

    public Punkt getMitte() {
        return mitte;
    }

    public double getRadius() {
        return radius;
    }

      @Override
    public String toString() {
        return "k(" +
                 mitte +
                ", " + radius +
                ')';
       //return String.format("k(%s;%.1f)", mitte, radius);
    }

    @Override
    public boolean in(Punkt p) {
        //return p >=0;
        return mitte.abstand(p) <= radius;
    }

    @Override
    public boolean equals(Object other){
        if (this==other) return true;
        if (other.getClass()!= this.getClass())
            return false;
        Kreis oKreis = (Kreis)other;
        return this.mitte.equals(oKreis.mitte) &&
                this.radius == oKreis.radius;
    }

    public static void main(String[] args) {
        Kreis k1 = new Kreis();
        Kreis k2 = new Kreis();
        System.out.printf("k1:%s\n",k1);
        System.out.printf("k2:%s\n",k2);

        System.out.println(k1.equals(k2));

        List<Kreis> lk = new ArrayList<>();
        lk.add(k1);
        System.out.println(lk);
        System.out.println(lk.contains(k2));
    }
}
