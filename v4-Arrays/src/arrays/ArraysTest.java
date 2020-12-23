package arrays;

import java.util.Arrays;

import static util.Printer.p;
import static util.Printer.pAry;

public class ArraysTest {
    public static void main(String[] args) {
        p("Soll eine Matrix spaltenweise gefüllt werden, muss man die einzelnen Elemente in den Spalten setzen");
        p("Dazu iterieren wir über die Spalten und füllen einzeln die Positionen in den Zeilen");
        p("si ist der Spaltenindex, zi ist der Zeilenindex");
        int[][] matrix1 = new int[4][7];
        int[] fourInts = {8,9,10,11};
        for (int si = 0; si < matrix1[0].length; si++) {
            for(int zi=0; zi < matrix1.length; zi++) {
                matrix1[zi][si] = fourInts[zi];
               // p("matrix1[" + zi + "][" + si + "]= " + matrix1[zi][si]);
            }
        }
        System.out.println(Arrays.deepToString(matrix1));
    }
}
