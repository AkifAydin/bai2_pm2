package operators;

import static util.Printer.print;

public class BitoperatorDemo {
    public static void main(String[] args) {
        int pos = 255001;
        int neg = -255001;
        print("BITSHIFT");
        bitShift(pos, neg);
        print("BITAND");
        bitAnd(pos, neg);
    }

    private static void bitAnd(int pos, int neg) {
        int pos1 = pos & 0xff;
        print(pos);
        print(pos1);
        int noLongerNeg = neg & 0xff;
        print(neg);
        print(noLongerNeg);
    }

    private static void bitShift(int pos, int neg) {
        print(pos);
        print(Integer.toBinaryString(pos));
        print(neg);
        print(Integer.toBinaryString(neg));
        int pos1 = pos >> 3;
        int neg1 = neg >> 3;
        int noLongerNeg = neg >>> 3;
        print(pos1);
        print(Integer.toBinaryString(pos1));
        print(neg1);
        print(Integer.toBinaryString(neg1));
        print(noLongerNeg);
        print(Integer.toBinaryString(noLongerNeg));
    }

}
