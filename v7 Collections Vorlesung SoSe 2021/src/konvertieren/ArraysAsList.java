package konvertieren;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArraysAsList {

    public static void main(String[] args) {
        Integer[] iAry = new Integer[] {1,2,3,4,5,6};
        List<Integer> li = Arrays.asList(iAry);
        //li.add(2);
        //li.remove(3);
        //li.clear();
        li.set(1,77);
        //System.out.println(li);
        Collections.reverse(li);
        //System.out.println(li);
        li.toArray(iAry);
        System.out.println(Arrays.toString(iAry));

        // li soll in Größe modifizierbar werden
        List<Integer> liMod = new ArrayList<>(Arrays.asList(iAry));
    }
}
