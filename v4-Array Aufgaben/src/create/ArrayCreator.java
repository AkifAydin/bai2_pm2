package create;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ArrayCreator {



    /**
     * A2: Erzeugen Sie ein 2D int[][] Array der Länge n, dessen Zeilen die Länge 1 bis n haben
     *     und dessen Werte aus dem Array {1,2,…,n} kopiert werden.
     * @param n Länge des Ergebnisarrays und die Länge der Zeilen
     * @return int[][] Array mit {{1,2,...,n-1},...,{1,2,...,n-1}}
     */

    public static int[][] a2(int n){
        int[] ary1n = new int[n-1];
        for(int i =0; i < n; i++){
            ary1n[i] =i;
        }
        Random rd = new Random();
        //int[][] ary2D = new int[n][ary1n.length];
        int[][] ary2D = new int[n][];
        for( int zi = 0; zi < n; zi++){
//            for (int si = 0; si <ary1n.length; si++){
//                ary2D[zi][si] = ary1n[si];
//            }
            ary2D[zi] = ary1n.clone();
        }
        return ary2D;
    }

    /**
     * A3: Erzeugen Sie ein 3D String[][][] Array, der Länge n, dessen Inhalte
     * Zeichenketten sind,
     * die durch Kombination der Indizes der 3-Dimensionen entstehen, sind.
     * @param n Breite, Hoehe und Tiefe des Würfels
     *
     * @return Würfel mit Inhalte für n=3 { {{"000", "001", "002"},..,{"020",...,}}, ...
     *                                      {{"200",...}, ..., {"220",...}} }
     */
    public static String[][][] a3(int n){
        String[][][] wuerfel = new String[n][n][n];
        for( int x = 0; x < n; x++){
            for( int y = 0; y < n; y++){
                for( int z = 0; z < n; z++){
                    wuerfel[x][y][z] = ""+x+y+z;
                }
            }
        }
        return wuerfel;
    }

    // A4: Erzeugen Sie ein 2D short[][] Array der Länge n,
    // mit Spalten der Länge m, deren Werte im Intervall
    // [Short.MIN_VALUE, SHORT.MAX_VALUE] liegen.
    // Um zu prüfen, ob Methode das vollständige Intervall abdeckt, schreiben Sie die folgenden Methoden:
    //isShort(int value), die prüft, ob ein Wert im Wertebereich von short liegt.
    //untilShortMin(int range), die zählt, wie lange die Methode benötigt, um Short.Min_Value zu erreichen. Dabei soll ein Fehler geworfen werden, wenn ein Wert außerhalb des gültigen Wertebereichs von short liegt.
    //untilShortMax(int range): analog für Short.MAX_VALUE.

    /**
     *
     * @param n Anzahl Zeilen
     * @param m Anzahl Spalten
     * @return short[][] mit Werten aus [Short.MIN_VALUE,Short.MAX_VALUE]
     */
    public static short[][] a4(int n,int m){
        short[][] sAry = new short[n][m];
        Random rd = new Random();
        for( int zi = 0; zi < n; zi++) {
            for (int si = 0; si < m; si++) {
                // Werte in das  Intervall [0, Short.MAX_VALUE - Short.MIN_VALUE] umrechnen
                // [Short.MIN_VALUE -Short.MIN_VALUE, Short.MAX_VALUE - Short.MIN_VALUE] auswürfeln
                int max = Short.MAX_VALUE - Short.MIN_VALUE +1;
                System.out.println("max" + max);
                // Wert in den Bereich [Short.MIN_VALUE,Short.MAX_VALUE] zurückrechnen
                int value = rd.nextInt(max)+ Short.MIN_VALUE;
                if (!isShort(value)){
                    throw new IllegalArgumentException("not a short "+ value);
                }
                sAry[zi][si] = (short)value;
            }
        }
        return sAry;
    }

    /**
     * A5: Erzeugen Sie ein int[] Array der Länge n,
     *    dessen Werte im Intervall [0..n) liegen und umgekehrt sortiert sind.
     * @param n Länge des Arrays
     * @return Array mit Werten (n-1,n-2, ..., 0)
     */
    public static int[] a5(int n){
        int[] iAry = new int[n];
        for(int zi=n-1; zi >=0; zi--){
            iAry[n-1-zi]=zi;
        }
        return iAry;
    }

    //A6: Erzeugen Sie ein int[][] Array der Länge n mit Zeilenlänge m,
    // deren Werte aufsteigend im Intervall [0..n*m) liegen.
    // Bsp.: n=3 und m=4: {{0,1,2,3},
    //                     {4,5,6,7},
    //                     {8,9,10,11}}
    public static int[][] a6(int n, int m){
        int[][] iAry = new int[n][m];

        for (int zi =0 ; zi < n; zi++) {
            for (int si = 0; si < m; si++) {
                // für das Beispiel:
                // zi=0 m=4 j = [0..3]: 0,1,2,3
                // zi=1 m=4 j = [0..3]: 4,5,6,7
                // ...
                iAry[zi][si] = zi*m +si;
            }
        }
        return iAry;
    }

    // A7: Traversieren Sie das Array aus A6 von rechts nach links und
    // sammeln Sie die Elemente in einer ArrayList<Integer> ein.
    public static List<Integer> a7(int[][] iAry){
        List<Integer> list = new ArrayList<>(); // list.add(elem)
        int n = iAry.length;
        int m = iAry[0].length;
        for (int zi = n-1; zi >=0; zi--){
            for (int si=m-1; si >= 0; si--){
                list.add(iAry[zi][si]);
            }
        }
        return list;
    }

    //  A8: Modifizieren Sie A7, indem Sie Elemente in einem Array ohne
    //  Verwendung eines separaten Zählers einsammeln.
    public static int[] a8(int[][] iAry){
        int n = iAry.length;
        int m = iAry[0].length;
        int arySize = n*m;
        int[] ary = new int[arySize];

        for (int zi = n-1; zi >=0; zi--){
            for (int si=m-1; si >= 0; si--){
              ary[arySize-1-(zi*m+si)] = iAry[zi][si];
            }
        }
        return ary;
    }


    // A9: Traversieren Sie das Array aus A3 von rechts nach links und
    // sammeln Sie die Elemente in einer ArrayList<Integer> ein.
    public static List<Integer> a9(String[][][] sAry){
        List<Integer> list = new ArrayList<>();
        return list;
    }

    // A10: Traversieren Sie das Array aus A5 und geben Sie
    // dabei jeweils die gegenüberliegenden Werte aus.
    public static void a10(int[] iAry){
        int mitte = (iAry.length-1)/2;
        int n = iAry.length;
        for (int i=0; i<=mitte; i++){
            System.out.print(iAry[i] +"<->" + iAry[n-1-i] +"\n");
        }
    }



    //A11: Erzeugen Sie eine flache Kopie der Arrays aus A1 und A3.
    public static int[][] a11(int[][] iAry){
        //int[][] kopie = null;
        return iAry.clone();
    }
    public static String[][][] a11(String[][][] iAry){
//        String[][][] kopie = null;
        return iAry.clone();
    }
    //A12: Erzeugen Sie eine tiefe Kopie der Arrays aus A1 und A3.
    public static int[][] a12(int[][] iAry){
        int[][] tiefeKopie = new int[iAry.length][];
        for (int i=0; i<iAry.length; i++){
            tiefeKopie[i] = iAry[i].clone();
        }
        return tiefeKopie;
    }
    public static String[][][] a12(String[][][] iAry){
        String[][][] tiefeKopie = new String[iAry.length][][];
        for (int i=0; i<iAry.length; i++){
            String[][] kopie2D = new String[iAry[i].length][];
            for (int j=0; j<iAry[i].length; j++){
                kopie2D[j] = iAry[i][j].clone();
            }
            tiefeKopie[i] = kopie2D;
        }
        return tiefeKopie;
    }

    public static String[][][] a12Regulaer(String[][][] iAry){
        // Arrays haben auf allen Ebenen gleiche Länge und es ist auf jeder Ebene mindestens 1 Array enthalten
        String[][][] tiefeKopie = new String[iAry.length][iAry[0].length][iAry[0][0].length];
        for (int i=0; i<iAry.length; i++){
            //String[][] kopie2D = new String[iAry[i].length][];
            for (int j=0; j<iAry[i].length; j++){
                //kopie2D[j] = iAry[i][j].clone();
                for (int z=0; z<iAry[i][j].length; z++){
                    //kopie2D[j] = iAry[i][j].clone();
                    tiefeKopie[i][j][z] = iAry[i][j][z];
                }
            }
            //tiefeKopie[i] = kopie2D;
        }
        return tiefeKopie;
    }
    // A13: Erstellen Sie aus dem Array aus A1 eine Kopie,
    // die jeweils die Hälfte der enthaltenen Arrays kopiert.
    public static int[][] a13(int[][] iAry){
        int n = iAry.length;
        int[][] kurzeKopie = new int[n][];
        for (int zi=0; zi <n; zi++){
            kurzeKopie[zi] = Arrays.copyOf(iAry[zi],(iAry[zi].length+1)/2);
        }
        return kurzeKopie;
    }

    //A14: Erstellen Sie aus dem Array aus A1 eine flache Kopie,
    // die jeweils ab der Hälfte der enthaltenen Arrays kopiert.

    public static int[][] a14(int[][] iAry){
        int[][] kurzeKopie = new int[iAry.length][];
        for (int zi=0; zi <iAry.length; zi++){
            int mitte = iAry[zi].length/2;
            kurzeKopie[zi] = Arrays.copyOfRange(iAry[zi],mitte,iAry[zi].length);
        }
        return kurzeKopie;
    }

    public static void main(String[] args) {
        int[][][] iAry = {{{1, 2}}};
        a012(iAry);

        int[][] iAry2 = {{1, 2},
                {3, 4},
                {5, 6}};

        a03(iAry2);

        System.out.println(Arrays.deepToString(a1(5,4,30)));
        System.out.println(Arrays.deepToString(a3(3)));
        System.out.println(Arrays.deepToString(a4(5, 4)));
        System.out.println(Arrays.toString(a5(5)));
        int[][] ary = a6(4,3);
        System.out.println(Arrays.deepToString(ary));
        System.out.println(a7(ary));
        System.out.println(Arrays.toString(a8(ary)));
        int[] a5Ary10 = a5(10);
        int[] a5Ary7 = a5(7);
        System.out.println(Arrays.toString(a5Ary10));
        a10(a5Ary10);
        System.out.println();
        System.out.println(Arrays.toString(a5Ary7));
        a10(a5Ary7);
        int[][] aryA1 = a1(6,7,30);
        System.out.println(Arrays.deepToString(aryA1));
        System.out.println(Arrays.deepToString(a13(aryA1)));
        System.out.println(Arrays.deepToString(a14(aryA1)));

        ary = a6(5,6);
        System.out.println(Arrays.deepToString(ary));
        System.out.println(Arrays.deepToString(a15(ary)));

    }
    //A15: Erzeugen Sie aus dem Array aus A1 ein neues Array,
    //in dem immer 2 enthaltene Arrays zu einem zusammengefasst werden.

    public static int[][] a15(int[][] iAry){
        int[][] kopie = new int[iAry.length/2][];
        for (int i =0; i < iAry.length; i+=2){
            int[] zweiInEins = Arrays.copyOf(iAry[i],iAry[i].length+iAry[i+1].length);
            System.arraycopy(iAry[i+1],0,zweiInEins,iAry[i].length,iAry[i+1].length);
            kopie[i/2] = zweiInEins;
        }
        return kopie;
    }

    public static boolean isShort(long value){
        return Short.MIN_VALUE <= value && value <= Short.MAX_VALUE;
    }

    public static void a011(Object[] ary) {
        System.out.println(Arrays.deepToString(ary));
    }

    public static void a013(int[][] ary) {
        System.out.println(Arrays.deepToString(ary));
    }

    public static void a012(int[] ary) {
        System.out.println(Arrays.toString(ary));
    }

    public static void a011(int[][] ary) {
        for (int[] elem : ary) {
            System.out.println(Arrays.toString(elem));
        }
    }

    public static void a03(int[][] ary) {
        for (int si = 0; si < ary[0].length; si++) {
            for (int zi = 0; zi < ary.length; zi++) {
                System.out.print(ary[zi][si] + " ");
            }
            // ein Spalte ist ausgegeben
            System.out.println();
        }
    }


    public static void a012(int[][][] ary) {
        for (int[][] elem : ary) {
            System.out.println(Arrays.deepToString(elem));
        }
    }

    /**
     * @param n Anzahl der Elemente
     * @param k maximale Länge der Zeile, minimale ist 1
     * @param max [-max,+max] zufällige Werte in den Arrays
     * @return int[][] Array der Länge n
     */
    public static int[][] a1(int n, int k, int max) {
        Random rd = new Random();
        int[][] iAry = new int[n][];
        for(int zi=0; zi <n; zi++){
            int laenge = rd.nextInt(k)+1; // min 0 max k-1 [1..k]
            int[] zAry = new int[laenge];
            for (int si =0; si < zAry.length; si++){
                int value = rd.nextInt(2*max+1)-max;
                zAry[si] = value;
            }
            iAry[zi] = zAry;
        }
        return iAry;
    }

    public static int[] reverseArray(int n) {
        return null;
    }

    public static short[][] shortMinMaxArray(int n, int m) {

        return null;
    }

    private static int untilShortMin(int range) {
        return 0;
    }

    private static int untilShortMax(int range) {
        return 0;
    }

//    public static int[][] mnAry(int n, int m){
//
//    }
//
//    public static List<Integer> rightToLeft(int[][] iAry){
//
//    }
//
//    public static int[] rightToLeftArray(int[][] iAry) {
//    }
}
