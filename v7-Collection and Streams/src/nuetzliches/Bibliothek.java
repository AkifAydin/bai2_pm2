package nuetzliches;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Bibliothek{

    Map<String, Set<String>> buecher;

    public Bibliothek(){
        this.buecher = new HashMap<>();
    }

    /**
     * Trägt zu einem Autor ein Buch in die Menge der Bücher dieses Autors ein.
     * Wenn zu dem Autor noch keine Bücher vorhanden sind, dann soll initial eine leere Menge erzuegt werden.
     * @param autor
     * @param buch
     */
    public void eintragen(String autor, String buch){
        if (!buecher.containsKey(autor)) {
            buecher.put(autor,new HashSet<>());
        }
        buecher.get(autor).add(buch);
    }

    /**
     * Trägt zu einem Autor ein Buch in die Menge der Bücher dieses Autors ein.
     * Wenn zu dem Autor noch keine Bücher vorhanden sind, dann soll initial eine leere Menge erzuegt werden.
     * Diese Lösung verwendet die Kurzform computeIfAbsent.
     * @param autor
     * @param buch
     */
    public void eintragen_1(String autor, String buch){
        buecher.computeIfAbsent(autor, buecherListe -> new HashSet<>()).add(buch);
    }

    @Override
    public String toString() {
        return String.format("Biblio:%s",buecher);
    }
}