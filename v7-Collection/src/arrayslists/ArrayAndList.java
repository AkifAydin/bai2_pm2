package arrayslists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayAndList {

    public static void main(String[] args) {
        String[][][] ary = {{{null, null, null, null}, {null}, {null, null}},
                {{null}},
                {{"claus", null, null, null, null, null}, {null, null, null},
                        {null, null, null, null}, {null}, {"claus", null}},
                {{"claus", null, null}, {null}},
                {{null, null, null, null, null, "claus"}},
                {{"claus", null, "claus", null}}
        };
        System.out.println(count("claus", ary));
    }

    public static List<List<Integer>> count(String elem, String[][][] ary) {
        List<List<Integer>> lli = new ArrayList<>();
        for (int i = 0; i < ary.length; i++) {
            for (int j = 0; j < ary[i].length; j++) {
                for (int z = 0; z < ary[i][j].length; z++) {

                    if (elem.equals(ary[i][j][z])) {
                        lli.add(Arrays.asList(i, j, z));
                    }
                }
            }
        }
        return lli;
    }
}
