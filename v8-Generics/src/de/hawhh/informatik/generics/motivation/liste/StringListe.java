package de.hawhh.informatik.generics.motivation.liste;

public class StringListe extends NichtGenerischeListe {

    @Override
    public void add(Object e) {
        if (! (e instanceof String)) throw new IllegalArgumentException("Nicht vom Typ String");
        super.add(e);
    }

    public void add(String e) {
        super.add(e);
    }

    @Override
    public String get(int index) {
        return (String)super.get(index);
    }

    @Override
    public void set(int index, Object e) {
        super.set(index, e);
    }

    public static void main(String[] args) {
        StringListe sl = new StringListe();
        sl.add("25");
        sl.add("45");
        sl.add("hi");

        String s1 = sl.get(1);

    }
}
