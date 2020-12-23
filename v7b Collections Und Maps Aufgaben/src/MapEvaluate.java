import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapEvaluate {

    public static void main(String[] args) {
        Map<String, List<Integer>> msli = new HashMap<>();
        msli.put("eins", Arrays.asList(1, 3, 4, 5, 6, 7));
        msli.put("drei", Arrays.asList(1, 3, 4, 5, 6, 7));
        msli.put("zwei", Arrays.asList(1, 3, 4, 5));
        //Verwenden Sie diese Map, um die Elemente zu berechnen,
        // deren Werte am längsten sind. Sammeln Sie diese Element in einer neuen Map.
        int maxLength = 0;
        Map<String, List<Integer>> msliMax = new HashMap<>();
        for (List<Integer> entry : msli.values()) {
            if (maxLength < entry.size()) {
                maxLength = entry.size();
            }
        }
        // maxLength ist berechnet
        for (Map.Entry<String, List<Integer>> entry : msli.entrySet()) {
            if (maxLength == entry.getValue().size()) {
                msliMax.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println(msliMax);
    }


}
