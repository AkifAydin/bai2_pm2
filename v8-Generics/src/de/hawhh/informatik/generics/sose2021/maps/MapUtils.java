package de.hawhh.informatik.generics.sose2021.maps;

import maps.MapUtil;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static <K,V> Map<K,V> intersect(Map<K,V> map1, Map<K,V> map2){
        Map<K,V> intersection = new HashMap<>();
        map1.forEach((k1,v1) -> {
            if (v1.equals(map2.get(k1))) {
                intersection.put(k1,v1);
            }
        });
        return intersection;
    }

    public static <K,V> Map<K,V> intersect2(Map<? extends K,? extends  V> map1,
                                            Map<? extends K,? extends V> map2){
        Map<K,V> intersection = new HashMap<>();
        map1.forEach((k1,v1) -> {
            if (v1.equals(map2.get(k1))) {
                intersection.put(k1,v1);
            }
        });
        return intersection;
    }

    public static <K,V> Map<K,V> intersect3(Map<K, V> map1,
                                            Map<? extends K,? extends V> map2){
        Map<K,V> intersection = new HashMap<>();
        map1.forEach((k1,v1) -> {
            if (v1.equals(map2.get(k1))) {
                intersection.put(k1,v1);
            }
        });
        return intersection;
    }

    public static void main(String[] args) {
        Map<Integer,Double> mid1 = Map.of(1,1.1, 2,2.2, 3, 3.3);
        Map<Integer,Double> mid2 = Map.of(1, 1.9, 2,2.2, 3, 3.3, 4, 4.11);
        Map<Integer,Double> intersect1 = MapUtils.intersect(mid1,mid2);
        System.out.println(intersect1);
        Map<Number, Number> mnn = Map.of(1, 1.9, 2,2.2, 3, 3.3, 4, 4.11);
        // Compilerfehler
        // Map<Number, Number> intersect2 = MapUtils.intersect(mid1,mnn);
        // ok
        Map<Number, Number> intersect21 = MapUtils.intersect2(mid1,mnn);
        Map<Integer, Double> intersect3 = MapUtils.intersect2(mid1,mid2);
        //
        Map<Number, Double> mnd = Map.of(1, 1.9, 2,2.2, 3, 3.3, 4, 4.11);
        Map<Integer,Number> min = Map.of(1,1.1, 2,2.2, 3, 3.3);
        Map<Number, Number> intersect4 = MapUtils.intersect2(mnd,min);
        //
        Map<Integer,Number> intersect5 = MapUtils.intersect3(min,mid2);

        System.out.println(intersect21);
    }
}
