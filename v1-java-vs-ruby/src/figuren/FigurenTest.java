package figuren;

public class FigurenTest {

    public static void main(String[] args) {
        Rechteck r1;
        Figur k2;

        k2 = new Kreis(new Punkt(4, 4));
        r1 = new Rechteck(new Punkt(3, 3));

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