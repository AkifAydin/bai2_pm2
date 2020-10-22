package operators;

import static util.Printer.print;

public class OperatorZuweisungDemo {

    public static void main(String[] args) {
        // analog fuer char, byte, short, int, long, double
        print("Operator Zuweisung Demo");
        float u, v;
        u = 16.890f;
        v = 156.e14f;
        print("u : " + u);
        print("v : " + v);
        print("u : " + u);
        print("u += v : " + (u += v));
        print("u -= v : " + (u -= v));
        print("u *= v : " + (u *= v));
        print("u /= v : " + (u /= v));
    }
}

