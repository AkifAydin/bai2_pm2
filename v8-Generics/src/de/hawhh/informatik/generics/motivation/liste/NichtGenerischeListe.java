package de.hawhh.informatik.generics.motivation.liste;

import java.util.Arrays;

public class NichtGenerischeListe {
    private int n;
    private Object[] intern = new Object[1];
    public int size(){return n;}
    public boolean isEmpty(){return size()==0;}
    public void add(Object e) {
        if (n==intern.length)
            resize(2*n);
        intern[n++]=e;
    }

    public Object get(int index){
        checkIndex(index);
        return intern[index];
    }

    public void set(int index, Object e){
        checkIndex(index);
        intern[index] = e;
    }
    public boolean contains(Object e){
        for(Object o : intern) {
            if (e==null && o==null || o.equals(e)) return true;
        }
        return false;
    }
    private void resize(int newSize){
        intern = Arrays.copyOf(intern,newSize);
    }

    private void checkIndex(int index){
        if (index <0 || index >= size()) throw new IndexOutOfBoundsException(index);
    }
    @Override
    public String toString() {
        return Arrays.deepToString(intern);
    }
}
