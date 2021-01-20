package de.hawhh.informatik.bibliothek;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class BibliothekLoesung implements Iterable<Map.Entry<String, Set<Buch>>>, Serializable {

    private final String name;
    private Map<String, Set<Buch>> bestand;

    public BibliothekLoesung(String name) {
        this.name = name;
        this.bestand = new HashMap<>();
    }

    public BibliothekLoesung add(Buch buch) {
        bestand.putIfAbsent(buch.getAutor(), new HashSet<>());
        bestand.get(buch.getAutor()).add(buch);
        return this;
    }

    public Set<Buch> get(String autor){
        if (!bestand.containsKey(autor))
            return null;
        return new HashSet<>(bestand.get(autor));
    }

    public String produktivsterAutor() {
        Optional<Map.Entry<String, Set<Buch>>> ossb =
                bestand.entrySet().stream().
                        max(Comparator.comparing(entry -> entry.getValue().size()));
        if (ossb.isPresent()) {
            return ossb.get().getKey();
        } else return null;
    }

    public Set<Buch> alleBuecher(){
        return bestand.entrySet().stream().map(entry-> entry.getValue()).flatMap(Set::stream).collect(Collectors.toSet());
    }

    public Set<Buch> erschienenNach(int jahr) {
        return alleBuecher().stream().filter(buch -> buch.getErschienen()>jahr).collect(Collectors.toSet());
    }

    public Map<String,Buch> inIsbnTabelle(){
        return alleBuecher().stream().collect(Collectors.toMap(buch -> buch.getIsbn(),buch -> buch));
    }

    public Map<Integer,List<Buch>> gruppiereNachJahr(){
        return alleBuecher().stream().collect(Collectors.groupingBy(Buch::getErschienen));
    }

    public List<Buch> sortiereNachAutorMitTitel(){
        return alleBuecher().stream().
                sorted(Comparator.comparing(Buch::getAutor).thenComparing(Buch::getTitel)).collect(Collectors.toList());
    }

    @Override
    public Iterator<Map.Entry<String, Set<Buch>>> iterator() {
        return bestand.entrySet().iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BibliothekLoesung entries = (BibliothekLoesung) o;
        return Objects.equals(name, entries.name) &&
                Objects.equals(bestand, entries.bestand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bestand);
    }

    @Override
    public String toString() {
        return "Bibliothek{" +
                "name='" + name + '\'' +
                ", bestand=" + bestand +
                '}';
    }
}
