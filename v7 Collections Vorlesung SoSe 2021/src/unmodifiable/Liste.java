package unmodifiable;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Liste<T> extends AbstractList<T> implements Iterable<T> {
    private T[] intern;
    private static final int INITIAL_CAPACITY = 1;
    private int n=0;

    public Liste(){
        this(INITIAL_CAPACITY);
    }
    public Liste(int initialCapacity){
       intern = (T[])new Object[initialCapacity];
    }

    public void checkIndex(int index, int max){
        if( index <0 || index >max) throw new IndexOutOfBoundsException();
    }

    private void resize(int newSize){
        intern = Arrays.copyOf(intern,newSize);
    }

    @Override
    public boolean add(T t) {
        if (n >= intern.length) resize(2*n);
        intern[n]=t;
        n++;
        return true;
    }

    @Override
    public T remove(int index) {
        checkIndex(index,size()-1);
        T elem = get(index);
        // Elemente ab index+1 nach vorne kopieren
        if (index != size()-1) {
            System.arraycopy(intern, index + 1, intern, index, size() - index - 1);
        }
        // letztes Element löschen also auf null setzen
        intern[n-1] = null;
        // Anzahl dekrementieren
        n--;
        // Wenn zuviel Platz benötigt wird
        if (n <= intern.length/4) resize(intern.length/2);
        return elem;
    }

    @Override
    public T set(int index, T element) {
        checkIndex(index,size()-1);
        return intern[index]=element;
    }

    @Override
    public T get(int index) {
        checkIndex(index,size()-1);
        return intern[index];
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(intern,size()));
    }

    @Override
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<T> {
        private int cursor = 0;
        private boolean nextGiven=false;

        @Override
        public boolean hasNext() {
            return cursor < n;
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T elem = intern[cursor];
            cursor++;
            nextGiven=true;
            return elem;
        }

        @Override
        public void remove() {
            if (!nextGiven) throw new IllegalStateException();
            // loesche das Element, das mit next gelesen wurde.
            // cursor steht dahinter
            Liste.this.remove(cursor-1);
            cursor--;
            nextGiven = false;
        }
    }

}
