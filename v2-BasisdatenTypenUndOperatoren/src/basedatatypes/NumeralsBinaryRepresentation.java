package basedatatypes;

import static util.Printer.print;

public class NumeralsBinaryRepresentation {

    public static void main(String[] args) {
        int i1 = 0x2f; // hexadecimal
        print("i1: " + Integer.toBinaryString(i1));
        // analog für i2 und i3
        char c = 0xffff; // max char in hex
        print("c: " + Integer.toBinaryString(c));
        byte b = 0x7f; // max byte in hex
        print("b: " + Long.toBinaryString(b));
        short s = 0x7fff; // max short in hex
        print("s: " + Integer.toBinaryString(s));
        long n1 = 200L; // long suffix
        print("n1: " + Long.toBinaryString(n1));
    }
}
