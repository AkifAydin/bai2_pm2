package de.hawhh.informatik.generics.motivation.liste;

public class ListeClient {

    public static void main(String[] args) {
        Liste<Integer> il = new Liste<Integer>();
        Integer[] ai = {1, 4, 5, 6, 93, 4, 5, 7};
        for (Integer i : ai) {
            il.add(i);
        }

        System.out.println(il);
        int sum = 0;
        for (int i = 0; i < il.size(); i++) {
            sum += il.get(i);     // kein Cast beim Lesen notwendig
        }

//        String first = (String) il.get(0); // Cast auf String beim Lesen nicht erlaubt
//
//
//        il.add("NO GO"); // Nur Schreiben von Integer Werten erlaubt
        // Compiler fehler
    }
}
