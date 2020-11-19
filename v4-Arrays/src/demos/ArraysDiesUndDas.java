package demos;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysDiesUndDas {

    public static void main(String[] args) {

        //System.out.println(arrayEquals(new int[] {1,2,3}, new int[] {1,2,3}));

        toObject(new Integer[]{1,2,3,4});
        toInteger(new Integer[]{1,2,3,4,5});
        System.out.println(Arrays.toString(new long[]{Long.MIN_VALUE,Long.MAX_VALUE}));
        int[] inInt = toInt(new long[]{Long.MIN_VALUE,Long.MAX_VALUE});
        System.out.println(Arrays.toString(inInt));
        //toInteger(new Object[] {1,2,3,4,5});

        //kovarianzUngeschuetzt();
        forEachAendertNichtInhalt(new int[] {1,2,3});


        int[] iAry = new int[]{1,2,3};
        System.out.println("iAry VOR forMitElementZugriffAendert " + Arrays.toString(iAry));
        forMitElementZugriffAendert(iAry);
        System.out.println("iAry NACH forMitElementZugriffAendert " + Arrays.toString(iAry));


        int[][] myMat = {{1,1,1},{2,2,2},{3,3,3}};

        System.out.println(Arrays.deepToString(myMat));
        korrumpiereMatrix(myMat);
        System.out.println(Arrays.deepToString(myMat));

        int[][] mat1 = {{1,1},{2,2},{3,3}};
        int[][] mat2,mat3,mat4;
        mat2 = mat1;

        mat3 = mat1.clone();
        mat4 = new int[3][2];
        for(int i =0; i < mat1.length; i++) {
            mat4[i] = mat1[i].clone();
        }

        System.out.println("Mat1 mat2");
        array2DVergleich(mat1,mat2);
        System.out.println("Mat1 mat3");
        array2DVergleich(mat1,mat3);
        System.out.println("Mat1 mat4");
        array2DVergleich(mat1,mat4);

    }

    public static void array2DVergleich(int[][] ary1, int[][] ary2) {

        System.out.println(Arrays.deepToString(ary1));
        System.out.println(Arrays.deepToString(ary2));

        System.out.println("equals");
        System.out.println(ary1.equals(ary2));

        System.out.println("Arrays equals()");
        System.out.println(Arrays.equals(ary1, ary2));

        System.out.println("Arrays deepEquals()");
        System.out.println(Arrays.deepEquals(ary1, ary2));

    }

    public static void korrumpiereMatrix(int[][] mat) {

        for (int i =0; i< mat.length; i++) {
            mat[i] =  new int[i];
        }

    }

    public static void forEachAendertNichtInhalt(int[] iAry){
        System.out.println(Arrays.toString(iAry));
        for (int elem: iAry) {
            elem *= 2;
            System.out.println(elem);
        }
        System.out.println(Arrays.toString(iAry));
    }

    public static void forMitElementZugriffAendert(int[] iAry){
        iAry = new int[]{7,8,9};
        System.out.println(Arrays.toString(iAry));
        for (int index =0; index < iAry.length;  index++) {
            iAry[index] = iAry[index]*2;
            System.out.println(iAry[index]*2);
        }
        System.out.println(Arrays.toString(iAry));
    }


    public static void kovarianzUngeschuetzt(){

        Object[] oAry = new String[2];
        oAry[0] = "eins";
        oAry[1] = 4.56;

    }

    public static void iteriere(int[] ary){
        for (int elem : ary) {
            System.out.println(elem);
        }
    }

    public static void kompatibel(){
        double d=1.0;
        int i=1;
        d = i;
        double[] dAry = new double[10];
        int[] iAry = new int[10];
        //dAry = iAry;
        Double dD;
        dD = d;
        Double[] dDAry = new Double[10];
        System.out.println(Arrays.toString(dDAry));
        //dDAry = dAry;
    }

    public static long[] toLong(int[] iAry) {
        long[] lAry = new long[iAry.length];
        for (int i=0; i <lAry.length; i++){
            lAry[i] = iAry[i];
        }
        return lAry;
    }

    public static float[] toFloat(int[] iAry) {
        float[] fAry = new float[iAry.length];
        for (int i=0; i <fAry.length; i++){
            fAry[i] = iAry[i];
        }
        return fAry;
    }

    public static int[] toInt(long[] lAry) {
        int[] iAry = new int[lAry.length];
        for (int i=0; i <lAry.length; i++){
            iAry[i] = (int)lAry[i];
        }
        return iAry;
    }

    public static Object[] toObject(Integer[] iAry){
        Object o = Integer.valueOf(89);
        //Double[] dAry = iAry;
        Object[] oAry = iAry;
        return iAry;
    }


    public static Object toSingleObject(int[] iAry){
        return iAry;
    }


    public static Integer[] toInteger(Object[] oAry){
        //Integer i = (Integer) new Object();
        //Double[] dAry = iAry;
        Integer[] iAry = (Integer[])oAry;
        return iAry;
    }


    public static boolean arrayEquals(int[] ary1, int[] ary2){
        System.out.println(Arrays.toString(ary1));
        System.out.println(Arrays.toString(ary2));
        if (ary1.length!= ary2.length)
            return false;

        for (int i =0; i < ary1.length; i++){
            if (ary1[i] != ary2[i])
                return false;
        }

        return true;
    }
}
