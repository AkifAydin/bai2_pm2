package nuetzliches;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFlatten {


    public static void main(String[] args) {
        Map<Integer, List<Integer>> mili = new HashMap<>();
        mili.put(1, Arrays.asList(1,2,3,4,5,6));
        mili.put(2, Arrays.asList(8,9,5,6));
        mili.put(3, Arrays.asList(5,6,11,12));

        /**
         * Sammelt die Elemente der Listen (der Werte in dem Hash) in einer Menge von Integerwerten eine
         */
        Set<Integer> si = mili.values()
                .stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());

        System.out.println(si);
    }

}
