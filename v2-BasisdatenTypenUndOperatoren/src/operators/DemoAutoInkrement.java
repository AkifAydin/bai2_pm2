package operators;

import static util.Printer.print;

public class DemoAutoInkrement {
    public static void main(String[] args) {
        print("Autoin(de)krement");
        int i = 1, j;
        j = ++i; // Pre-Inkrement
        print("j = ++i : j ist " + j + " i ist " + i);
        j = i++; // Post-Inkrement
        print("j = i++ : j ist " + j + " i ist " + i);
        j = --i; // Pre-Dekrement
        print("j = --i : j ist " + j + " i ist " + i);
        j = i--; // Post-Dekrement
        print("j = i-- : j ist " + j + " i ist " + i);
        // siehe auch
        print("++i : " + ++i);
        print("i++ : " + i++);
        print("i : " + i);
        print("--i : " + --i);
        print("i-- : " + i--);
        print("i : " + i);
    }
}
