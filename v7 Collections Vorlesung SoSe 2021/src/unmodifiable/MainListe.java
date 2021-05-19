package unmodifiable;

import java.util.Iterator;

public class MainListe {

    public static void main(String[] args) {

        Liste<Integer> li = new Liste<>();

        li.add(1);
        li.add(1);
        li.add(2);
        li.add(3);
        li.add(4);
        li.add(1);
        li.add(1);
        li.add(1);
        li.add(5);
        li.add(6);
        li.add(1);
        li.add(1);
        System.out.println(li);

        Iterator<Integer> iiter = li.iterator();
        while (iiter.hasNext()) {
            System.out.print(iiter.next() + " ");
        }

        // Lösche alle Einsen
        Iterator<Integer> iiter2 = li.iterator();
        while (iiter2.hasNext()){
            int nextI = iiter2.next();
            if (nextI==1) iiter2.remove();
        }
        System.out.println();
        System.out.println(li);

//        System.out.println(li.get(0));
//        System.out.println(li.get(2));
//        System.out.println(li.get(5));
//
//        li.remove(0);
//        System.out.println(li);
//        System.out.println(li.size());
//
//        li.remove(li.size()-1);
//        System.out.println(li);
//        System.out.println(li.size());
//
//        li.remove(2);
//        System.out.println(li);
//        System.out.println(li.size());
    }
}
