package ue7b13bisb19;

import java.util.HashMap;
import java.util.Map;

public class MapUebungen {

    public static void main(String[] args) {
        Map<String, Double> msd  = new HashMap<>();

        String[] keys = {"e1", "e2", "e3"};
        Double[] vals = {1.1,1.2,1.3};

        for (int i=0; i < keys.length; i++){
            msd.put(keys[i],vals[i]);
        }
        System.out.println(msd);
        Map<Double,String> mds = invertiere(msd);
        System.out.println(mds);
    }

    private static Map<Double, String> invertiere(Map<String, Double> msd) {
        Map<Double,String> mds = new HashMap<>();

        for (Map.Entry<String,Double> esd : msd.entrySet()){
            mds.put(esd.getValue(),esd.getKey());
        }
        return mds;
    }
}
