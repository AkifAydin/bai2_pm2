package de.hawhh.informatik.generics.motivation.liste;

public class NichtGenerischeListeClient {

//    public static void main(String[] args) {
//        IntegerListe il = new IntegerListe();
//        Integer[] ai = {1,4,5,6,93,4,5,7};
//        for (Integer i: ai){
//            il.add(i);
//        }
//
//        int sum=0;
//        for (int i=0; i < il.size(); i++) {
//            // sum += ngl.get(i); Fehler
//            // Hier muss kein cast erfolgen, das il.get Integer zurückliefert
//            sum += il.get(i);
//        }
//        System.out.println(il);
//
////        String str = "";
////        for (int i=0; i < il.size(); i++) {
////            str += (String) il.get(i);
////        }
//        il.add("NO GO");
//    }


    public static void main(String[] args) {
        NichtGenerischeListe ngl = new NichtGenerischeListe();
        Integer[] ai = {1,4,5,6,93,4,5,7};
        for (Integer i: ai){
            ngl.add(i);
        }

        int sum=0;
        for (int i=0; i < ngl.size(); i++) {
            // sum += ngl.get(i); Fehler
            // Clients müssen Elemente auf den erwarteten Typ casten
            sum += (Integer) ngl.get(i);
        }

        System.out.println(ngl);
        String str = "";
        for (int i=0; i < ngl.size(); i++) {
            str += (String) ngl.get(i);
        }
    }



}
