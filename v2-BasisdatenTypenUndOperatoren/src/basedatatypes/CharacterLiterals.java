package basedatatypes;

public class CharacterLiterals {

    public static void main(String[] args) {
        char c1, c2, c3;
        c1 = 226; // int Darstellung
        c2 = '\u00E2'; // Unicode Darstellung (Hexadezimal 4 Stellen)
        c3 = 'â'; // Zeichendarstellung
        print("c1 : " + c1);
        print("c2 : " + c2);
        print("c3 : " + c3);
        print("c1 int value : " + (int) c1);
        print("c2 int value : " + (int) c2);
        print("c3 int value : " + (int) c3);
        // arithmetische Ops
        print("c1 + 1: " + (c1 + 1));
        print("c1 / 3: " + (c1 / 3));
        print("-c1: " + (-c1));
    }

    private static void print(String string) {
        System.out.println(string);
    }
}
