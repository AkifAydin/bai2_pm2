package konvertieren;

import java.util.*;

public class CollectionInCollectionDemo {

    public static void main(String[] args) {

        List<Integer> li = Arrays.asList(1,5,7,8,9,23,4,6);
        Set<Integer> si = new HashSet<>(li);
        List<Integer> li2 = new ArrayList<>(si);
        System.out.println(li);
        System.out.println(si);
        System.out.println(li2);

//        for(Integer i: li){
//            si.add(i);
//        }
    }
}
