package nuetzliches;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class IterateMapsLists {

    public static void main(String[] args) {
        Map<Integer,Integer> mii = Map.of(1,2,3,4,5,6,7,8,9,10);

        mii.forEach((key,val) -> System.out.println(key +"->" + val));

        List<Integer> li = Arrays.asList(1,2,3,4,5,6,8,9);

        li.forEach(elem -> System.out.println(elem));
    }
}
