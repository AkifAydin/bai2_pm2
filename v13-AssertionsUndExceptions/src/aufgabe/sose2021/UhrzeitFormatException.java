package aufgabe.sose2021;

public class UhrzeitFormatException extends Exception {
    public UhrzeitFormatException(Throwable dte) {
        super(dte);
    }

    public UhrzeitFormatException(String s) {
        super(s);
    }
}
