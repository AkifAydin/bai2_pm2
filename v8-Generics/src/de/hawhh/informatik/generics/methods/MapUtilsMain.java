package de.hawhh.informatik.generics.methods;

import de.hawhh.informatik.generics.methods.komplexezahlen.Cartesian;
import de.hawhh.informatik.generics.methods.komplexezahlen.Complex;
import de.hawhh.informatik.generics.methods.komplexezahlen.Polar;

import java.util.HashMap;
import java.util.Map;

public class MapUtilsMain {


    public static void main(String[] args) {
        Map<Integer,Integer> mii1 = new HashMap<>();
        Map<Integer,Integer> mii2 = new HashMap<>();
        Map<Double,Integer> mdi1 = new HashMap<>();
        Map<Double,Integer> mdi2 = new HashMap<>();
        Map<Float,Integer> mdf = new HashMap<>();
        Map<Polar,Polar> mpp1 = new HashMap<>();
        Map<Polar,Polar> mpp2 = new HashMap<>();
        Map<Cartesian,Polar> mcp = new HashMap<>();

        // ok, da in allen Fällen die Typen für Schlüssel und Wert identisch sind
        MapUtils.intersect1(mii1,mii2);
        MapUtils.intersect1(mdi1,mdi2);
        MapUtils.intersect1(mpp1,mpp2);
        // Fehler, da die Typen der Schlüssel unterschiedlich sind
        //MapUtils.intersect1(mdi1,mdf);
        // MapUtils.intersect1(mpp1,mcp);

        // ok, da in beiden Fällen die Typen für Schlüssel und Wert identisch sind
        MapUtils.intersect2(mii1,mii2);
        MapUtils.intersect2(mdi1,mdi2);
        // ok, da die Typen der Schlüssel den gemeinsamen Supertyp Number haben
        Map<Number,Integer> mnn = MapUtils.intersect2(mdi1,mdf);
        // ok, da die Typen der Schlüssel und Wert den gemeinsamen Supertyp AbstractComplex / Complex haben
        Map<Complex, Complex> mcc = MapUtils.intersect2(mpp1,mcp);


    }

}
