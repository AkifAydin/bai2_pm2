package de.hawhh.informatik.bibliothek;

import java.io.Serializable;
import java.util.*;

import java.util.stream.Collectors;

public class Bibliothek implements Iterable<Map.Entry<String,Set<Buch>>> {

    private final String name;
    private Map<String, Set<Buch>> bestand;

    public Bibliothek(String name) {
        this.name = name;
        this.bestand = new HashMap<>();
    }

    public Bibliothek add2(Buch buch) {
       if (!bestand.containsKey(buch.getAutor())){
           bestand.put(buch.getAutor(),new HashSet<>());
       }
       bestand.get(buch.getAutor()).add(buch);
       return this;
    }

    public Bibliothek add(Buch buch) {
        bestand.computeIfAbsent(buch.getAutor(), v ->  new HashSet<>()).add(buch);
        return this;
    }
    //Methode alleBuecher(): Gibt alle Bücher der Bibliothek als Menge zurück.

    public Set<Buch> alleBuecher(){
        return bestand.values()
                .stream()
                .flatMap(Set::stream)
                .collect(Collectors.toSet());
    }

    public String produktivsterAutor() {
        Optional<Map.Entry<String,Set<Buch>>> optEntry = bestand.entrySet()
                .stream()
                .max((entry1,entry2) -> entry1.getValue().size()-entry2.getValue().size());
        if (optEntry.isPresent()) {
            return optEntry.get().getKey();
        }
        return null;
     }


    public Set<Buch> erschienenNach(int jahr) {
        return alleBuecher()
                .stream()
                .filter(b -> b.getErschienen() > jahr)
                .collect(Collectors.toSet());
    }

    public Map<String, Buch> inIsbnTabelle() {
        //return alleBuecher().stream().collect(Collectors.groupingBy(Buch::getIsbn));
//        Map<String,Buch> msb = new HashMap<>();
//        alleBuecher().forEach(b -> msb.put(b.getIsbn(),b));
//        return msb;
        return alleBuecher().stream().collect(Collectors.toMap(b -> b.getIsbn(), b -> b));
    }

    public Map<Integer, List<Buch>> gruppiereNachJahr() {
       return alleBuecher().stream().collect(Collectors.groupingBy(Buch::getErschienen));
    }

    // Methode sortiereNachAutorDannNachTitel(): Sortiert den Bestand der Bibliothek nach
    // Autoren und dann nach Titel.

    public List<Buch> sortiereNachAutorDannNachTitel() {
        return alleBuecher()
                .stream()
                .sorted(Comparator.comparing(Buch::getAutor)
                        .thenComparing(Buch::getTitel))
                .collect(Collectors.toList());
    }

    public List<Map.Entry<String,List<Buch>>> sortiereNachAutorMitTitel() {
        return bestand
                .entrySet()
                .stream()
                .map( entry -> Map.entry(entry.getKey(),
                        entry.getValue()
                                .stream()
                                .sorted(Comparator.comparing(Buch::getTitel))
                                .collect(Collectors.toList())))
                .sorted(Comparator.comparing(Map.Entry::getKey) )
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bibliothek entries = (Bibliothek) o;
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

    @Override
    public Iterator<Map.Entry<String, Set<Buch>>> iterator() {
        return bestand.entrySet().iterator();
    }


    public Set<Buch> get(String autor) {
        return bestand.get(autor);
    }
}
