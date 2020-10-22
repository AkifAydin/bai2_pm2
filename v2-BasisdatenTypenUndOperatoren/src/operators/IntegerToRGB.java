package operators;

import java.util.Arrays;
import java.util.Scanner;

public class IntegerToRGB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int i = sc.nextInt();
            int[] rgb = intToRGB(i);
            System.out.printf("%d to rgb %s\n", i, Arrays.toString(rgb));
            int j = rgbToInt(rgb);
            System.out.printf("%s to int %d\n", Arrays.toString(rgb), j);
        }
    }

    // Nur für positive Zahlen, das obere Byte wird ignoriert
    private static int[] intToRGB(int i) {
        // extrahiere den Rotanteil
        int red = i >> 16 & 0xff;
        // extrahiere den Gruenanteil
        int green = i >> 8 & 0xff;
        // extrahiere den Blauanteil
        int blue = i & 0xff;
        return new int[]{red, green, blue};
    }

    private static int rgbToInt(int[] rgb) {
        // erzeugt nur positive Zahlen
        return ((rgb[0] << 16) | (rgb[1] << 8) | rgb[2]);
    }
}
