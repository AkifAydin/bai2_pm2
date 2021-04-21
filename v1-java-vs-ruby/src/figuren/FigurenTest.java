package figuren;

import original.Punkt;

public class FigurenTest {

    public static void main(String[] args) {
        Rechteck r1;
        Figur k2;
        Kreis k3;
        Figur f1;
        String s="12";

        alternative.Punkt ap = new alternative.Punkt(4,7);


        k2 = new Kreis(new Punkt(4, 4));
        r1 = new Rechteck(new Punkt(3, 3));

        k3 = new Kreis(new Punkt(1,1),4);

        f1 = new Rechteck(new Punkt(2, 2));
        f1 = new Kreis(new Punkt(1,1),4);

        s.concat("34");

      // k2.radius = 15;

        r1.in(new Punkt(1, 9));
        k2.in(new Punkt(1, 9));

        System.out.println(k2);

        System.out.println(r1);

        Punkt punkt = new Punkt(3, 4);
        System.out.println(r1.in(punkt));

        String o = readme();

        int[] iary = new int[10];

        iary[9] = 45;
    }

    public static String readme() {
        System.out.println("Readme");
        return "Readme";
    }
}