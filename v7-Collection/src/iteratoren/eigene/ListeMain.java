package iteratoren.eigene;

import java.util.Iterator;

public class ListeMain {

    public static void main(String[] args) {
        Liste l = new Liste(4);
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        Iterator<Object> iter = l.iterator();

        System.out.println(l);
        System.out.println(l.internToString());
        while (iter.hasNext()) {
            Object o = iter.next();
            if (o.equals(1)) {
                iter.remove();
                if (iter.hasNext()) {
                }
            }
        }
        System.out.println(l);
        System.out.println(l.internToString());
        iter = l.iterator();
        while(iter.hasNext()) {
            iter.next();
            iter.remove();
        }
        System.out.println(l);
        System.out.println(l.internToString());
    }

}
