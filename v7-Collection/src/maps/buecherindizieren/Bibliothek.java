package maps.buecherindizieren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliothek {
    private Map<String,List<Buch>> bestand;

    public Bibliothek(){
        this.bestand = new HashMap<String, List<Buch>>();
    }

    public Bibliothek hinzufuegen(Buch buch) {

        if (!bestand.containsKey(buch.getAutor())) {
            bestand.put(buch.getAutor(), new ArrayList<>());
        }
        bestand.get(buch.getAutor()).add(buch);

        return this;
    }
}

