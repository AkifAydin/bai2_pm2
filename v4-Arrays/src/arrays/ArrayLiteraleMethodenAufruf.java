package arrays;

import misc.Person;

import java.util.Arrays;

public class ArrayLiteraleMethodenAufruf {

    public static void printArray(int[] ary){
        System.out.println(Arrays.toString(ary));
    }

    public static void main(String[] args) {
        int[] printTheAry = {1,2,3,4};
        printArray(printTheAry);
        printArray(new int[]{1,2,3,4});
        Object[] oAry = new Object[4];
        oAry[0] = 7;
        oAry[1] = new Person("v","n");
        oAry[2] = Double.valueOf(3.4);
        oAry[3] = "Hi there";

        for (Object o : oAry) {
            if (o instanceof Person){
                Person p = (Person)o;
                p.setName("mod");
            }
            System.out.println(o);
        }

        String s = "Ein Tag im Jahr der Schlange.";
        System.out.println(s.length());

        char[] tag = new char[6];
        s.getChars(4,7,tag,0);
        System.out.println(Arrays.toString(tag));
        s.getChars(4,7,tag,1);
        System.out.println(Arrays.toString(tag));

        //char[] tag2 = new char[2];
        //s.getChars(4,7,tag2,0);

        char[] doppelTag = Arrays.copyOf(tag,tag.length*2);
        System.out.println(Arrays.toString(doppelTag));
        System.out.println(tag==doppelTag);

        int[][] ary2D = new int[7][20];

        for (int i = 0; i < ary2D.length; i++){
            int[] zeile = new int[i+1];
            for (int j= 0; j<zeile.length; j++){
                zeile[j] = j+1;
            }
            ary2D[i] = zeile;
        }
        System.out.println(Arrays.deepToString(ary2D));
    }
}
