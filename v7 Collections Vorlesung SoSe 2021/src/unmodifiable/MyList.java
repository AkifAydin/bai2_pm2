package unmodifiable;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class MyList<T> extends AbstractList<T> {

    List<T> intern;
    public MyList(){
        intern = new ArrayList<>();
    }

    @Override
    public T get(int index) {
        return intern.get(index);
    }

    @Override
    public int size() {
        return intern.size();
    }

    @Override
    public void add(int index, T element) {
        intern.add(index,element);
    }

    @Override
    public T remove(int index) {
        return intern.remove(index);
    }

    @Override
    public T set(int index, T element) {
        intern.set(index,element);
        return element;
    }

    @Override
    public String toString() {
        return intern.toString();
    }
}
