import de.hawhh.informatik.bibliothek.Bibliothek;
import de.hawhh.informatik.bibliothek.BibliotheksLeser;
import de.hawhh.informatik.bibliothek.Buch;

import java.io.*;
import java.util.List;

public class BibliotheksTestHelper {

    public static void main(String[] args) throws IOException {
        BibliotheksLeser bl = new BibliotheksLeser("buecher");

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("classes/production/bai2_pm2/bibliotheksDaten"))
            ) {
            List<Buch> buecher = bl.leseBuecher();
            System.out.println(buecher);
            Bibliothek biblio = new Bibliothek("TINY LIB");
            buecher.stream().forEach(buch -> biblio.add(buch));
            oos.writeObject(biblio);
        }
    }
}
