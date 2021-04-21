package arrays;
import misc.Person;

import java.util.Arrays;

import static util.Printer.pAry;
import static util.Printer.p;
public class ArraysKopieren {

    public static void main(String[] args) {

        int[] iAry = {0,1,2,3,4,5,6,7,8,9};
        pAry(iAry);

        p("1. Kopieren mit Größenangabe");
        p("1.1 Eine flache Kopie (wie clone)");
        int[] kopie = Arrays.copyOf(iAry,iAry.length);
        pAry(kopie);
        System.out.println(iAry==kopie);

        p("1.2. Kopieren und Größe verdoppeln");
        pAry(Arrays.copyOf(iAry,2*iAry.length));

        p("1.3. Kopieren und Größe halbieren");
        pAry(Arrays.copyOf(iAry,iAry.length/2));

        p("2. Bereichs-Kopien");
        pAry(Arrays.copyOfRange(iAry,3,iAry.length));
        pAry(Arrays.copyOfRange(iAry,3,iAry.length-3));
        pAry(Arrays.copyOfRange(iAry,4,iAry.length));
        pAry(Arrays.copyOfRange(iAry,5,iAry.length-2));  // ab Index i=5 ohne die letzten n=2
        pAry(Arrays.copyOfRange(iAry,5,iAry.length-5+2)); // ab Index i =5 plus die nächsten n=2

        p("3. Bereiche umkopieren mit System.arrayCopy");
        int[] copyTo1 = new int[iAry.length];
        Person[] pAry = {new Person("p","1"),new Person("p","2")};
        Person[] pAryCopy = new Person[2];

        p ("3.1 mit Person[]");
        System.arraycopy(pAry,0,pAryCopy,0,pAry.length);

        System.out.println(pAry==pAryCopy);

        for (int i =0; i < pAry.length; i++){
            System.out.println(pAry[i] == pAryCopy[i]);
        }

        pAry[0].setName("$ALIEN$");
        pAryCopy[1].setName("$Korrupt$");

        System.out.println(Arrays.toString(pAry));
        System.out.println(Arrays.toString(pAryCopy));

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
