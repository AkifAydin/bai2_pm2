package controlflow;

import java.util.Random;

import static util.Printer.print;

public class RandomDemo {
    public static void main(String[] args) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random(256);
        Random rand4 = new Random(256);
        Random rand5 = new Random(257);

        // rand3, rand4 erzeugen gleiche Zahlenfolgen
        for (int i = 0; i < 5; i++) {
            print("Iteration " + (i + 1));
            print("rand1.nextInt() " + rand1.nextInt());
            print("rand2.nextInt() " + rand2.nextInt());
            print("rand3.nextInt() " + rand3.nextInt());
            print("rand4.nextInt() " + rand4.nextInt());
            print("rand5.nextInt() " + rand5.nextInt());
        }
    }
}
