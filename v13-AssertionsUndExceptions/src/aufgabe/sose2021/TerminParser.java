package aufgabe.sose2021;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminParser {

    public static final String SEPARATOR="%%";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(TerminParser.lese("termine"));
    }

    public static List<Termin> lese(String filename) throws FileNotFoundException {

        List<Termin> termine = new ArrayList<>();
        File file = getFile(filename);
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String zeile = sc.nextLine();

            String[] terminPart = zeile.split(SEPARATOR);
            String betreff = null;
            if (terminPart.length==3) {
                betreff= terminPart[2];
            }
            /**
             * kritische Bereich. Das Parsen von Datum und Uhrzeit kann Fehler verursachen.
             */
            try {
                Termin termin = new Termin(Datum.parse(terminPart[0]), Uhrzeit.parse(terminPart[1]),betreff);
                termine.add(termin);
            } catch (DatumFormatException e) {
                System.out.println(String.format("%s:%s", e.getClass().getSimpleName(),e.getMessage()));
            } catch (UhrzeitFormatException e) {
                System.out.println(String.format("%s:%s", e.getClass().getSimpleName(),e.getMessage()));
            } catch (NumberFormatException e){
                System.out.println(String.format("ADDED %s:%s", e.getClass().getSimpleName(),e.getMessage()));
            } catch (IllegalArgumentException e){
                System.out.println(String.format("%s:%s", e.getClass().getSimpleName(),e.getMessage()));
            }
        }
        return termine;
    }

    private static File getFile(String filename) {
        String path = System.getProperty("java.class.path").split(File.pathSeparator)[0];
        String absoluteFilename = path + File.separator + filename;
        return new File(absoluteFilename);
    }
}
