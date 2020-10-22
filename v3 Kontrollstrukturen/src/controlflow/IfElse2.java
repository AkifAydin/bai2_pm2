package controlflow;

import static util.Printer.print;

public class IfElse2 {
    static int test(int source, int target) {
        if (source > target)
            return 1;
        else if (source == target)
            return 0;
        else
            return -1;
    }

    public static void main(String[] args) {
        print(test(10, 5));
        print(test(2, 5));
        print(test(5, 5));
        return;
    }
}