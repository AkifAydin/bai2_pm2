package aufgabe.sose2021;

import java.time.DateTimeException;

public class DatumFormatException extends Exception {
    public DatumFormatException(Throwable dte) {
        super(dte);
    }

    public DatumFormatException(String s) {
        super(s);
    }
}
