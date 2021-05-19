package vergleichbar;

import com.sun.security.jgss.GSSUtil;

import java.util.*;

public class CollectionAndComparableDemo {

    public static void main(String[] args) {
        Collection<Kreis> skreis = new TreeSet<>();
        Kreis k1 = new Kreis(2,new Punkt(1,2));
        Kreis k2 = new Kreis(3,new Punkt(1,1));
        skreis.add(k1);
        skreis.add(k2);
        System.out.println(skreis);

        Object[] kreise1 = skreis.toArray();
        for (Object o: kreise1){
            System.out.print(o + " ");
            //System.out.print(((Kreis)o).getMp() + " ");
        }
        System.out.println();

        Kreis[] kreise2 = skreis.toArray(new Kreis[]{});
        for (Kreis k: kreise2){
            System.out.print(k.getRadius() +" ");
        }

        Kreis[] kreise3 = new Kreis[10];
        skreis.toArray(kreise3);
        System.out.println("kreise3 " + Arrays.toString(kreise3));

        System.out.println();
        System.out.println(Arrays.toString(kreise1));
        System.out.println(Arrays.toString(kreise2));

    }
}

class Kreis implements Comparable<Kreis> {
    private int radius;
    private Punkt mp;

    public Kreis(int radius, Punkt mp) {
        this.radius = radius;
        this.mp = mp;
    }

    public int getRadius() {
        return radius;
    }

    public Punkt getMp() {
        return mp;
    }

    @Override
    public String toString() {
        return String.format("Kreis:mp=%s,r=%d", mp,radius);
    }

    @Override
    public int compareTo(Kreis o) {
        return this.radius-o.radius;
    }
}

class Punkt{
    private int x;
    private int y;

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Punkt(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return String.format("(%d,%d)",x,y);
    }
}