package ue7b12;

import java.util.*;


//Implementieren Sie eine iterierbare Klasse Liste mit den Methoden
//        add
//        remove
//        size
//        get
//        contains und
//        toString
//        sowie die Methode iterator(), die eine Objekt vom Typ Iterator zurückgibt.
//        Die Implementierung soll intern ein resizable Array der Größe M verwenden.
//        Wenn die Anzahl der Elemente beim Einfügen >= M/2 ist, dann soll das Array um das Doppelte vergrößert werden.
//        Wenn die Anzahl der Elemente beim Löschen <= M/4 ist, dann soll das Array um die Hälfte verkleinert werden.
//        Implementieren Sie den Iterator für die Klasse Liste. Das machen wir als innere Member Klasse. Was sich dahinter verbirgt, lernen wir später.
//        Zeigen Sie mittels eines foreach-Konstruktes, dass die Liste iterierbar ist.

public class Liste extends AbstractList<Object> {

    private static final int DEFAULT_CAP=2;
    private Object[] intern;
    private int count=0;

    public Liste(){
        intern = new Object[DEFAULT_CAP];
    }

    @Override
    public boolean add(Object obj) {
        if (size() >= intern.length/2) {
            resize(intern.length*2);
        }
        intern[count++] = obj;
        return true;
    }

    private void resize(int newSize) {
        Object[] tmp = new Object[newSize];
        for (int i=0; i < size(); i++) {
            tmp[i]=intern[i];
        }
        intern = tmp;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        return intern[index];
    }

    private void checkIndex(int index){
        if (index <0 || index >= size())
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        Object toRemove = intern[index];
        if (index < size()-1) {
            System.arraycopy(intern, index + 1, intern, index, size() - (index + 1));
        }
        if (size() <= intern.length/4) {
            resize(intern.length/2);
        }
        intern[--count]=null;
        return toRemove;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(intern,size()));
    }

    @Override
    public Iterator<Object> iterator() {
        return new MyIterator<Object>();
    }

    public static void main(String[] args) {
        Liste l = new Liste();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        for (Iterator<Object> iter = l.iterator(); iter.hasNext();){
            Object elem = iter.next();
            System.out.println("el:" + elem);
            System.out.println("hc:" + elem.hashCode()%3);
            if (elem.hashCode()%2==0) {
                iter.remove();
            }
        }

        System.out.println(l);
//        System.out.println(l);
//        l.remove(4);
//        l.remove(1);
//        System.out.println(l);
//        l.remove(0);
//        System.out.println(l);
    }

    private class MyIterator<T> implements Iterator<Object> {

        private int cursor=0;
        private boolean nextGiven=false;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public Object next() {
            nextGiven=true;
            return intern[cursor++];
        }

        @Override
        public void remove() {
            if (!nextGiven)
                throw new IllegalStateException();
            Liste.this.remove(--cursor);
            nextGiven=false;
        }
    }
}