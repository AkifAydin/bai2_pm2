package de.hawhh.informatik.bibliothek;

import java.io.Serializable;
import java.util.*;

import java.util.stream.Collectors;

public class Bibliothek implements Iterable<Map.Entry<String, Set<Buch>>>, Serializable {

    private final String name;
    private Map<String, Set<Buch>> bestand;

    public Bibliothek(String name) {
        this.name = name;
        this.bestand = new HashMap<>();
    }


    @Override
    public Iterator<Map.Entry<String, Set<Buch>>> iterator() {
        return bestand.entrySet().iterator();
    }

//    public void add2(Buch buch) {
//        Set<Buch> buecher = new HashSet<>();
//        if (bestand.containsKey(buch.getAutor())){
//            buecher = bestand.get(buch.getAutor());
//        }
//        buecher.add(buch);
//        bestand.put(buch.getAutor(),buecher);
//    }

    public String produktivster1() {
        Optional<Map.Entry<String, Set<Buch>>> optEntry = bestand.entrySet().stream().max((entry1, entry2) ->
                entry1.getValue().size() - entry2.getValue().size());
        if (optEntry.isPresent()) {
            return optEntry.get().getKey();
        } else return null;
    }

    public String produktivster2() {
        if (bestand.isEmpty()) {
            return null;
        }
        return bestand.entrySet()
                .stream()
                .max(Comparator.comparingInt(entry -> entry.getValue().size())).get().getKey();
    }

    //Methode alleBuecher(): Gibt alle Bücher der Bibliothek als Menge zurück.
    //Methode alleBuecher(): Gibt alle Bücher der Bibliothek als Menge zurück.

    public Set<Buch> alleBuecher1() {
        HashSet<Buch> alle = new HashSet<>();
        bestand.forEach((autor, buecher) -> alle.addAll(buecher));
        return alle;
    }

    public Set<Buch> alleBuecher2() {
        return bestand.values().stream().reduce(new HashSet<>(),
                (alle, buecher) -> {
                    alle.addAll(buecher);
                    return alle;
                });
    }

    public Set<Buch> alleBuecher3() {
        return bestand.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
    }


    public Bibliothek add2(Buch buch) {
        if (!bestand.containsKey(buch.getAutor())) {
            bestand.put(buch.getAutor(), new HashSet<>());
        }
        bestand.get(buch.getAutor()).add(buch);
        return this;
    }

    public Bibliothek add(Buch buch) {
        bestand.putIfAbsent(buch.getAutor(), new HashSet<>());
        bestand.get(buch.getAutor()).add(buch);
        return this;
    }

    public Set<Buch> get(String autor) {
        if (!bestand.containsKey(autor))
            return null;
        return new HashSet<>(bestand.get(autor));
    }

    public String produktivsterAutor() {
        Optional<Map.Entry<String, Set<Buch>>> opt = bestand.entrySet().stream().
                max(Comparator.comparingInt(e -> e.getValue().size()));
        if (opt.isPresent()) {
            Map.Entry<String, Set<Buch>> entry = opt.get();
            return entry.getKey();
        } else return null;
    }

    public Set<Buch> erschienenNach1(int jahr) {
        return alleBuecher().stream().filter(e -> e.getErschienen() > jahr).collect(Collectors.toSet());
    }

    public Map<String, Buch> inIsbnTabelle1() {
        return alleBuecher().stream()
                .collect(Collectors.toMap(b -> b.getIsbn(), b -> b));
    }

    public Map<Integer, List<Buch>> gruppiereNachJahr1() {
        return alleBuecher().stream().collect(Collectors.groupingBy(Buch::getErschienen));
    }

    // Methode sortiereNachAutorMitTitel(): Sortiert den Bestand der Bibliothek nach
    // Autoren und sortiert auch die Bücher eines Autors nach Titel.
    public List<Map.Entry<String, List<Buch>>> sortiereNachAutorMitTitel1() {
        return bestand.entrySet().stream().collect(Collectors.toMap(
                entry -> entry.getKey(),
                entry -> entry.getValue().stream().sorted(Comparator.comparing(Buch::getTitel)).collect(Collectors.toList())))
                .entrySet().stream().sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
                .collect(Collectors.toList());
    }

    public Set<Buch> alleBuecher() {
        return bestand.values().stream().flatMap(Set::stream).collect(Collectors.toSet());
    }


    public Set<Buch> erschienenNach(int jahr) {
        return alleBuecher().stream().filter(e -> e.getErschienen() > jahr).collect(Collectors.toSet());
    }

    public Map<String, Buch> inIsbnTabelle() {
        return alleBuecher().stream().collect(Collectors.toMap(b -> b.getIsbn(), b -> b));
    }

    public Map<Integer, List<Buch>> gruppiereNachJahr() {
        return alleBuecher().stream().collect(Collectors.groupingBy(b -> b.getErschienen()));
    }

    public List<Buch> sortiereNachAutorMitTitel() {
        return alleBuecher().stream().
                sorted(Comparator.comparing(Buch::getAutor).thenComparing(Buch::getTitel)).collect(Collectors.toList());
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

}
