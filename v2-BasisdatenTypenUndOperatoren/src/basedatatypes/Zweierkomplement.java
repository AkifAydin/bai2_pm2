package basedatatypes;

public class Zweierkomplement {

    public static void main(String[] args) {

        int i = 126;
        long l = 0x7fffffff;
        print(i);
        printBinary(i);
        print(-i);
        printBinary(-i);
        print(~i + 1);  // Bitkomplement +1
        print(l);
        printBinary(l);
        print(-l);
        print(~l + 1);  // Bitkomplement +1
        printBinary(-l);

    }

    private static void printBinary(int i) {
        System.out.println(Integer.toBinaryString(i));

    }

    private static void printBinary(long l) {
        System.out.println(Long.toBinaryString(l));
    }

    private static void print(Object o) {
        System.out.println(o);
    }


}
