package anwendungen.fahrzeuge;

import fahrzeugev2.*;

import java.util.Arrays;
import java.util.List;

public class Zaehlung {

    public static void main(String[] args) {

//        Faehrschiff[] schiffe = {new Faehrschiff(),new Faehrschiff()};
//        LinienBus[] linienBusse = {new LinienBus(),new LinienBus()};
//        Reisebus[] reiseBusse = {new Reisebus(),new Reisebus()};
//        Privatfahrzeug[] pfv = {new Privatfahrzeug(),new Privatfahrzeug()};
//        Taxi[] taxis = {new Taxi(),new Taxi()};

        Fahrzeug[] fahrzeuge = { new Faehrschiff(),new Faehrschiff(),new LinienBus(),new LinienBus()
                ,new Reisebus(),new Reisebus(),new Privatfahrzeug(),new Privatfahrzeug(),new Taxi(),new Taxi()};

        Faehrschiff[] schiffe = {new Faehrschiff(),new Faehrschiff()};
        zaehlen(schiffe);

        int anzahl = zaehlen(fahrzeuge);

//        int anzahl = zaehlen(schiffe);
//        anzahl += zaehlen(linienBusse);
//        anzahl += zaehlen(reiseBusse);
//        anzahl += zaehlen(pfv);
//        anzahl += zaehlen(taxis);
    }


    private static int zaehlen(Fahrzeug[] objects){
        System.out.println("zaehlen für Fahrzeug");

        for(Fahrzeug fz : objects){
            System.out.println(fz.hersteller());
            System.out.println(fz.getClass().getSimpleName());
        }
        return objects.length;
    }


    private static int zaehlen(Faehrschiff[] objects) {
        System.out.println("zaehlen für Faehrschiff");
        for(Faehrschiff fs : objects){
            System.out.println(fs.verdraengung());
        }
        return objects.length;
    }


//    private static int zaehlen(LinienBus[] objects) {
//        return objects.length;
//    }
//    private static int zaehlen(Reisebus[] objects) {
//        return objects.length;
//    }
//    private static int zaehlen(Privatfahrzeug[] objects) {
//        return objects.length;
//    }
//    private static int zaehlen(Taxi[] objects) {
//        return objects.length;
//    }

}
