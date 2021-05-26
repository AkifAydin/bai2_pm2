package fingeruebungen;

import java.util.*;

public class EinzelAufgaben {

    public static void main(String[] args) {
        // Erzeugen Sie eine Map, deren Schlüssel Zeichenketten und deren Werte Listen von ganzen Zahlen sind.
        Map<String, List<Integer>> msli = new HashMap<>();
        //Befüllen Sie die Map mit 10 Paaren, in denen die Werte maximal die Länge 10 haben,
        // indem Sie für die Schlüssel und Werte zufällige Werte berechnen.
        Random rd = new Random(782537182);
        while (msli.size() < 10) {
            String key = "key" + rd.nextInt(20);
            List<Integer> value = new ArrayList<>();
            int max = rd.nextInt(11);
            for (int i = 0; i < max; i++) {
                value.add(rd.nextInt(30));
            }
            msli.put(key, value);
        }
        System.out.println(msli);

        //Verwenden Sie diese Map, um die Elemente zu berechnen, deren Werte am längsten sind. Sammeln Sie diese
        //Element in einer neuen Map.
        // 1. maximale Länge berechnen 2. alle Elemente mit der maximalen Länge einsammeln

        //Wandeln Sie die Werte der Map in ein zwei-dimensionales Array um.
        Integer[][] interAry = new Integer[msli.size()][];
        int ct = 0;
        for (List<Integer> li : msli.values()) {
            Integer[] elem = li.toArray(new Integer[]{});
            interAry[ct++] = elem;
        }
        System.out.println(Arrays.deepToString(interAry));

        //Deklarieren Sie eine Map, deren Schlüssel Zeichenketten und deren Werte Maps sind.
        // Die Schlüssel der Werte-Maps sind Integer die Werte allgemeine Objekte.
        Map<String, Map<Integer, Object>> msmio = new HashMap<>();

        //Befüllen Sie die Map mit 5 Elemente, indem Sie für die Schlüssel und Werte zufällige Werte berechnen.
        // Die enthaltenen Maps sollen 5 Elemente enthalten.

        while (msmio.size() < 5) {
            String key = "key" + rd.nextInt(20);
            Map<Integer, Object> value = new HashMap<>();
            while (value.size() < 5) {
                value.put(rd.nextInt(10), rd.nextInt(20));
            }
            msmio.put(key, value);
        }
        System.out.println(msmio);


        System.out.println(invert(msli));
        Map<List<Integer>,String> mlis = invert(msli);

        Map<String,String> mss = verknuepfe(msli,mlis);
        System.out.println(mss);
    }

    //Schreiben Sie eine statische Methode, die eine Map<String,List<Integer>> invertiert.
    public static  Map<List<Integer>,String> invert(Map<String,List<Integer>> msli) {
        Map<List<Integer>,String> mlis =  new HashMap<>();
        for (Map.Entry<String,List<Integer>> entry: msli.entrySet()) {
            mlis.put(entry.getValue(),entry.getKey());
        }
        return mlis;
    }

    //Schreiben Sie eine statische Methode, die zwei Maps m1, m2 verknuepft.
    // Wenn der Wert der ersten Map m1 mit dem key der zweiten Map m2 übereinstimmt,
    // dann trage das Paar key von m1 und value von m2
    // in das Ergebnis ein.

    public static Map<String,String> verknuepfe(Map<String,List<Integer>> m1, Map<List<Integer>,String> m2){
        Map<String,String> mio = new HashMap<>();
        for (Map.Entry<String,List<Integer>> entryM1: m1.entrySet()) {
            if (m2.containsKey(entryM1.getValue())) {
                mio.put(entryM1.getKey(),m2.get(entryM1.getValue()));
            }
        }
        return mio;
    }





}
