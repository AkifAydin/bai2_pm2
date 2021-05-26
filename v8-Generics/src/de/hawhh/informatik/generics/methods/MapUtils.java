package de.hawhh.informatik.generics.methods;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {


    public static <T,U> Map<T,U> intersect1(Map<T,U> m1, Map<T,U> m2){
        Map<T,U> intersection = new HashMap<>();

        for(Map.Entry<T,U> entry: m1.entrySet()) {
            T m1key = entry.getKey();
            if (m2.containsKey(m1key) && m2.get(m1key).equals(entry.getValue())) {
                intersection.put(m1key,entry.getValue());
            }
        }
        return intersection;
    }


    public static <T,U> Map<T,U> intersect2(Map<? extends T,? extends U> m1, Map<? extends T,? extends U> m2){
        Map<T,U> intersection = new HashMap<>();

        for(Map.Entry<? extends T,? extends U> entry: m1.entrySet()) {
            T m1key = entry.getKey();
            if (m2.containsKey(m1key) && m2.get(m1key).equals(entry.getValue())) {
                intersection.put(m1key,entry.getValue());
            }
        }
        return intersection;
    }

//    public static <T,U> Map<? super T,? super U> intersect2(Map<? extends T,? extends U> m1, Map<? extends T,? extends U> m2){
//        Map<? super T,? super U> intersection = new HashMap<>();
//
//        for(Map.Entry<? extends T,? extends U> entry: m1.entrySet()) {
//            T m1key = entry.getKey();
//            if (m2.containsKey(m1key) && m2.get(m1key).equals(entry.getValue())) {
//                intersection.put(m1key,entry.getValue());
//            }
//        }
//        return intersection;
//    }
}
