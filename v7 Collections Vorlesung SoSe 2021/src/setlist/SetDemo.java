package setlist;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetDemo {

    public static void main(String[] args) {
        // Erzeugen Sie n unterschiedliche zufällige Zahlen aus dem Intervall [0..100)
        // und tragen Sie diese in ein Array ein.
        // Reihenfolge der Elemente entspricht der Reihenfolge des Eintragen.
        Random rand = new Random();
        int n = 20;
        Integer[] zahlen = new Integer[n];
        int cursor = 0;
        Set<Integer> controlSet = new HashSet<>();
        while (controlSet.size() < n){
            int zahl = rand.nextInt(100);
            if (controlSet.add(zahl)) {
                zahlen[cursor++] = zahl;
            }
        }
        System.out.println(Arrays.toString(zahlen));
    }
}
