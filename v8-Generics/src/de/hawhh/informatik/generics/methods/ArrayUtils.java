package de.hawhh.informatik.generics.methods;

public class ArrayUtils {
    static <T extends Comparable<? super T>> T min(T... tAry) {
        T min = null;
        for (int i = 0; i < tAry.length; i++) {
            if (min == null)
                min = tAry[i];
            else {
                T tElem = tAry[i];
                if (min.compareTo(tElem) > 0)
                    min = tElem;
            }
        }
        return min;
    }
}