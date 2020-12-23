package maps;

import java.util.Iterator;
import java.util.Map;

public class MapBasics {
    public static void main(String[] args) {
        Map<Integer,String> mis2 = Map.of(1,"eins",2,"zwei",3,"drei");
        Map<Integer,String> mis3 = Map.of(1,"eins",2,"zwei",3,"drei",4,"vier");
        Map<Integer,String> mis4 = Map.of(1,"eins",2,"zwei",3,"drei",4,"vier",5,"fuenf");
        Map<Integer,String> mis5 = Map.of(1,"eins",2,"zwei",3,"drei",4,"vier",5,"fuenf",6,"sechs");
        Map<Integer,String> mis10 = Map.of(1,"eins",2,"zwei",3,"drei",4,"vier",5,"fuenf",6,"sechs",7,"sieben",8,"acht",9,"neun",10,"zehn");
        // Fehler maximale Argumentzahl für of ist 20
        // Map<Integer,String> mis11 = Map.of(1,"eins",2,"zwei",3,"drei",4,"vier",5,"fuenf",6,"sechs",7,"sieben",8,"acht",9,"neun",10,"zehn",11,"elf");


        for (Integer key : mis2.keySet())
            System.out.println(key);

        for (Iterator<Integer> i = mis2.keySet().iterator(); i.hasNext(); )
            System.out.println(i.next());

        for (Map.Entry<Integer, String> e : mis2.entrySet() )
            System.out.println(e.getKey() + ": " + e.getValue());
    }
}
