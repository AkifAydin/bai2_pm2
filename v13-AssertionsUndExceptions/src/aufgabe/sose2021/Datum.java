package aufgabe.sose2021;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Datum {

    private final int tag;
    private final int monat;
    private final int jahr;

    public Datum(int tag, int monat, int jahr) throws DatumFormatException {
        try {
            LocalDate.of(jahr, monat, tag);
        } catch(DateTimeException dte){
            throw new DatumFormatException(dte);
        }
        this.tag=tag;
        this.monat=monat;
        this.jahr=jahr;
    }

    public static Datum parse(String datumString) throws DatumFormatException {
        String[] datumParts = datumString.split("\\.");
        if (datumParts.length!=3) {throw new DatumFormatException("kein korrektes Format:" + datumString+"|");}
        return new Datum(Integer.parseInt(datumParts[0].trim()),
                Integer.parseInt(datumParts[1].trim()), Integer.parseInt(datumParts[2].trim()));
    }

    @Override
    public String toString() {
        return String.format("%2d.%2d.%d",tag,monat,jahr);
    }
}
