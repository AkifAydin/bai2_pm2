package de.hawhh.informatik.generics.methods;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste<T> implements Iterable<T> {
    //private T[] elements;
    public T[] elements;
    private int writeCursor=0;
    private int capacity;

    public Liste() {
        capacity = 10;
        writeCursor=0;
        elements = (T[])new Object[capacity];
    }
    public void add(T elem){
        if (writeCursor==elements.length)
            elements = Arrays.copyOf(elements,elements.length+capacity);
        elements[writeCursor++] = elem;
    }
    public T remove(int index) {
        T toRemove = elements[index];
        System.arraycopy(elements, index, elements, index+1, writeCursor-index-1);
        writeCursor--;
        return toRemove;
    }

    public void set(int index,T elem){
        if (index <0 || index >= size()) throw new IndexOutOfBoundsException(index);
        elements[index] = elem;
    }

    public T get(int index){
        if (index <0 || index >= size()) throw new IndexOutOfBoundsException(index);
        return elements[index];
    }

    public int size(){
        return elements.length;
    }


    /* Destruktives Konkatenieren mit dem Inhalt eines Arrays
        Nicht Typsicher: Cast von u auf T
        Compiler meldet nur eine Warnung
        Zur Laufzeit wird eine ClassCastException generiert;
     */
    public <U> Liste<T> concat1(U[] array) {
       for (U u: array)
            this.add((T)u);
        return this;
    }

    /* Destruktives Konkatenieren mit einer Liste
    * Typsicher durch den Upper-Type-Bound im Parameter
    */

    public Liste<T> concat(Liste<? extends T> other) {
        for (T u: other)
            this.add(u);
        return this;
    }

    /* Destruktives Konkatenieren mit dem Inhalt eines Arrays
        Typsicher: Upper Typebound auf der Typvariable U <U extends T> stellt sicher,
        dass die Elemente in uAry kompatibel zu den Elementen der Liste (this) sind.
     */
    public <U  extends T> Liste<T> concat2(U[] uAry) {
        for (U u: uAry)
            this.add(u);
        return this;
    }

    @Override
    public Iterator<T> iterator() {
        return new ListeIterator();
    }

    private class ListeIterator implements Iterator<T> {
        private int readCursor=0;
        private boolean nextGiven=false;
        @Override
        public boolean hasNext() {
            return readCursor<writeCursor;
        }
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            nextGiven = true;
            return elements[readCursor++];
        }
        @Override
        public void remove() {
            if (nextGiven) {
                Liste.this.remove(readCursor-1);
                readCursor--;
            } else {
                throw new IllegalStateException();
            }
            nextGiven = !nextGiven;
        }
    }
}
