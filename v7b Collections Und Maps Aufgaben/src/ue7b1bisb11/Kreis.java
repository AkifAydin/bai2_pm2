package ue7b1bisb11;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kreis {

    private final int radius;
    private final String farbe;

    public Kreis(int radius, String farbe) {
        this.radius = radius;
        this.farbe = farbe;
    }


    public int getRadius() {
        return radius;
    }

    public String getFarbe() {
        return farbe;
    }

    @Override
    public String toString() {
        return "(" + radius +
                "," + farbe +')';
    }


    public static void main(String[] args) {
        Kreis k1 =  new Kreis(3,"blue");
        Kreis k2 =  new Kreis(4,"blue");
        Kreis k3 =  new Kreis(2,"red");
        Kreis k4 =  new Kreis(7,"yellow");
        List<Kreis> kreise = Arrays.asList(k1,k2,k3,k4);

        Collections.shuffle(kreise);
        System.out.println(kreise);

        FarbComparator fc = new FarbComparator();

        Collections.sort(kreise, fc);
        System.out.println(kreise);

        Collections.sort(kreise, new Comparator<Kreis>() {
            @Override
            public int compare(Kreis k1, Kreis k2) {
                return k1.radius-k2.radius;
            }
        });

        System.out.println(kreise);
    }

    static class FarbComparator implements Comparator<Kreis> {
        @Override
        public int compare(Kreis k1, Kreis k2) {
            return k1.getFarbe().compareTo(k2.getFarbe());
        }
    }

}