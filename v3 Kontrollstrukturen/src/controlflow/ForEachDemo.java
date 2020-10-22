package controlflow;

import java.util.Random;

import static util.Printer.print;

public class ForEachDemo {
    public static void main(String[] args) {
        Random rand = new Random(50);
        float[] floats = new float[10];
        // klassisches for
        for (int i = 0; i < 10; i++)
            floats[i] = rand.nextFloat();
        // foreach Syntax
        for (float f : floats)
            print("f " + f);

    }
}