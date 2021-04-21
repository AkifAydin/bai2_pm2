package arrays;
import java.util.Arrays;

import static util.Printer.pAry;
import static util.Printer.p;
public class ArraysKopieren {

    public static void main(String[] args) {

        int[] iAry = {0,1,2,3,4,5,6,7,8,9};
        pAry(iAry);

        p("1. Kopieren mit Größenangabe");
        p("1.1 Eine flache Kopie (wie clone)");
        pAry(Arrays.copyOf(iAry,iAry.length));

        p("1.2. Kopieren und Größe verdoppeln");
        pAry(Arrays.copyOf(iAry,2*iAry.length));

        p("1.3. Kopieren und Größe halbieren");
        pAry(Arrays.copyOf(iAry,iAry.length/2));

        p("2. Bereichs-Kopien");
        pAry(Arrays.copyOfRange(iAry,3,iAry.length));
        pAry(Arrays.copyOfRange(iAry,3,iAry.length-3));

        p("3. Bereiche umkopieren mit System.arrayCopy");
        int[] iAryClone = iAry.clone();
        int[] copyTo1 = new int[iAry.length];

        p("3.1 Eine flache Kopie");
        System.arraycopy(iAry,0,copyTo1,0,iAry.length);
        pAry(copyTo1);

        p("3.2 Bereich von Index 5 (plus Länge-Index) in iAry auf Pos 0 in copyTo1 umkopieren");
        copyTo1 = new int[iAry.length];
        System.arraycopy(iAry,5,copyTo1,0,iAry.length-5);
        pAry(copyTo1);

        p("3.3 Bereich von Index 5 (plus Länge-Index) in iAry auf Pos 0 in copyTo2 umkopieren");
        int[] copyTo2 = new int[iAry.length/2];
        System.arraycopy(iAry,5,copyTo2,0,iAry.length-5);
        pAry(copyTo2);

        p("3.4 Inplace-Kopieren von Index 5 (plus Länge-Index) auf Pos 0 in iAry");
        System.arraycopy(iAry,5,iAry,0,iAry.length-5);
        pAry(iAry);


    }
}
