package controlflow;

import java.util.Random;

import static util.Printer.print;

public class RandomDemo2 {
    public static void main(String[] args) {
        Random rand1 = new Random();
        Random rand2 = new Random();
        Random rand3 = new Random(256);
        Random rand4 = new Random(256);
        Random rand5 = new Random(257);
        // auch für Boolean, Long, Float, Double
        print("rand1.nextBoolean() " + rand1.nextBoolean());
        print("rand1.nextLong() " + rand3.nextLong());
        print("rand1.nextFloat() " + rand4.nextFloat());
        print("rand1.nextDouble() " + rand5.nextDouble());

        // Intervall der Zufallszahlen: [0-10)
        for (int i = 0; i < 30; i++) {
            print("Iteration " + (i + 1));
            print("rand1.nextInt(10) " + rand1.nextInt(10));
            print("rand2.nextInt(10) " + rand2.nextInt(10));
        }
    }
}