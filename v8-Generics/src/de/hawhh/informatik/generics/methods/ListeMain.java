package de.hawhh.informatik.generics.methods;

public class ListeMain {

    public static void main(String[] args) {
        Liste<Number> ln  = new Liste<>();

        // kein Compilerfehler
//        ln.concat1(new String[]{"oops"});
//        // kein Compilerfehler aber eine ClassCastException zur Laufzeit
//        for (Number d : ln) {
//            System.out.println(d);
//        }


        Liste<String> ls = new Liste<String>();
        Liste<Double> ld = new Liste<Double>();
        Liste<Object> lo = new Liste<Object>();
        // Compilerfehler Double nicht kompatibel zu String
        //ls.concat(ld);
        // ok String,Double kompatibel zu Object
        lo.concat(ls);
        lo.concat(ld);

        // Compilerfehler-Typfehler String nicht kompatibel zu Number
        //ld.concat2(new String[]{"oops"});
        // kein Compilerfehler
        ln.concat2(new Integer[]{1,2,32,4});
        // kein Compilerfehler Integer zu Number kompatibel
        for (Number d : ln) {
            System.out.println(d);
        }
    }
}
