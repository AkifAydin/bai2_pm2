
package operators;

import static java.lang.Math.*;
import static util.Printer.print;

public class MathLibDemo {
    public static void main(String[] args) {
        print(abs(-45));
        print(abs(-67.98));
        print(sin(PI));
        print(log10(100));
        print(exp(2));
        print(cbrt(27));
        print(ceil(7878.99));
        float f = 56.8f;
        print(pow(f, f));
    }
}
