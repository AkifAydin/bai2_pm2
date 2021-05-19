package unmodifiable;

import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        MyList<Integer> mli = new MyList<>();
        mli.add(1);
        mli.add(2);
        mli.add(3);
        mli.remove(2);
        System.out.println(mli);
        mli.set(0 , 5);
        System.out.println(mli);

        mli.add(4);
        mli.add(6);

        System.out.println(mli);

        mli.retainAll(Arrays.asList(1,5,4));
        mli.add(0,1);
        mli.add(0,1);
        mli.add(1);
        mli.add(1);
        mli.add(1);
        mli.add(99);

        // Iterieren mit dem Iterator explizit
        Iterator<Integer> iiter = mli.iterator();
        while (iiter.hasNext()){
            System.out.print(iiter.next() + " ");
        }
        System.out.println();
        // Iterieren mit dem foreach Konstrukt
        for(Integer elem: mli){
            System.out.print(elem + " ");
        }

        System.out.println();
        System.out.println(mli);
        System.out.println("Bist Du am Ende?:" + !iiter.hasNext());

        iiter = mli.iterator();

        while (iiter.hasNext()){
            int nextI = iiter.next();
            if (nextI==1) iiter.remove();
        }

//        for(int i=0; i < mli.size(); i++){
//            if (mli.get(i) ==1) {
//                mli.remove(i);
//            }
//        }
        System.out.println(mli);
    }
}
