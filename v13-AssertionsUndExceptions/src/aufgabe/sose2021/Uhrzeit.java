package aufgabe.sose2021;

import java.time.DateTimeException;
import java.time.LocalTime;

public class Uhrzeit {

    private final int stunde;
    private final int minute;

    public Uhrzeit(int stunde, int minute) throws UhrzeitFormatException {
        try{
            LocalTime.of(stunde,minute);
        } catch (DateTimeException dte){
            throw new UhrzeitFormatException("keine gültigen Werte:" + stunde + ":" + minute);
        }
        this.stunde = stunde;
        this.minute = minute;

    }

    public static Uhrzeit parse(String datumString) throws UhrzeitFormatException {
        String[] datumParts = datumString.split(":");
        if (datumParts.length!=2) {throw new UhrzeitFormatException("kein korrektes Format:" + datumString+"|");}
        return new Uhrzeit(Integer.parseInt(datumParts[0].trim()),
                Integer.parseInt(datumParts[1].trim()));
    }

    @Override
    public String toString() {
        return String.format("%2d:%2d", stunde, minute);
    }
}
