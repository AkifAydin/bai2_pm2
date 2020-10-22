package overunderflow;

import static util.Printer.print;
import static util.Printer.printnb;

public class FloatingPointPrecision {
    public static void main(String[] args) {

        // 1'tes Beispiel
        int j = Integer.MAX_VALUE;
        print("overflows produces negative number: " + (j + 1));
        double d = 1e308;
        printnb("overflow produces infinity: ");
        print(d + "*10==" + d * 10);

        print("----------------------------");
        // 2tes Beispiel Rundungsfehler
        // An example of inexact results and rounding:
        print("rounding errors with float:");
        for (int i = 0; i < 100; i++) {
            float z = 1.0f / i;
            if (z * i != 1.0f)
                printnb(" " + i);
        }
        print("");
        // Another example of inexact results and rounding:
        print("rounding errors with double:");
        for (int i = 0; i < 100; i++) {
            double z = 1.0 / i;
            if (z * i != 1.0)
                printnb(" " + i);
        }

        print("----------------------------");

        d = 1e-305 * Math.PI;
        print("gradual underflow: " + d);
        for (int i = 0; i < 4; i++)
            print(d /= 100000);

        double s = 0;
        for (int i = 0; i < 260; i++) {
            s += 0.1;
            print(s);
        }
        print("s =" + s);
        double s1 = 0.1 * 260;
        print("s1=" + s1);
        print("Fehler: " + Math.abs(s - s1));
        double epsilon = 1e-15;
        if (Math.abs(s - s1) < epsilon)
            print("s gleich s1, Fehler: " + Math.abs(s - s1));
        else
            print("s ungleich s1, Fehler: " + Math.abs(s - s1));

        /* das gleiche nochmals für float */
        float f = 0;
        for (int i = 0; i < 260; i++) {
            f += 0.1;
            print(f);
        }
        print("f =" + f);
        float f1 = 0.1f * 260;
        print("f1=" + f1);
        print("Fehler: " + Math.abs(f - f1));

        if (Math.abs(f - f1) < epsilon)
            print("f gleich f1, Fehler: " + Math.abs(f - f1));
        else
            print("f ungleich f1, Fehler: " + Math.abs(f - f1));
    }
}
