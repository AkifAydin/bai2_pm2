package utilitycollections;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class CollectionsDemo {

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(7,4,1,9,-5,34,2);
        List<Integer> liKopie = new ArrayList<>(li);

        System.out.println(liKopie);

        Collections.sort(liKopie);

        System.out.println(liKopie);
        System.out.println(li);

        Comparator<Integer> comp = new MyComparator();
        Collections.sort(liKopie,comp);


//        Collections.sort(liKopie, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });

        System.out.println(liKopie);
        List<Kreis> skreis = new ArrayList<>();
        Kreis k1 = new Kreis(5,new Punkt(1,2));
        Kreis k2 = new Kreis(3,new Punkt(1,1));
        skreis.add(k1);
        skreis.add(k2);
        System.out.println(skreis);
        Collections.sort(skreis, new Comparator<Kreis>() {

            @Override
            public int compare(Kreis o1, Kreis o2) {
                return o1.getRadius()-o2.getRadius();
            }
        });

        System.out.println(skreis);
    }

}

class MyComparator implements Comparator<Integer>{
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

class Kreis {
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