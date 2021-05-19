package nuetzliches;

import java.util.*;

public class EintragenInMaps {

    public static void main(String[] args) {
        Bibliothek biblio = new Bibliothek();
        biblio.eintragen_1("a1", "b11");
        biblio.eintragen_1("a2","b21");
        biblio.eintragen_1("a1", "b12");
        System.out.println(biblio);
    }

}


