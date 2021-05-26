package de.hawhh.informatik.generics.motivation.liste;

public class IntegerListe extends NichtGenerischeListe {

    public void add(Object e) {
        if (!(e instanceof Integer)) throw new IllegalArgumentException();
        super.add(e);
    }

    public Integer get(int index){
       return (Integer)super.get(index);
    }

    public void set(int index, Object e){
        if (!(e instanceof Integer)) throw new IllegalArgumentException();
        super.set(index,e);
    }
}
