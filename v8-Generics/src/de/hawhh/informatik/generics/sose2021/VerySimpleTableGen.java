package de.hawhh.informatik.generics.sose2021;

import java.util.Arrays;

public class VerySimpleTableGen<Key,Val> {
    private Key[] keys;
    private Val[] values;
    private int n;

    public VerySimpleTableGen(int initialCapacity) {
        this.keys = (Key[])new Object[initialCapacity];
        this.values = (Val[])new Object[initialCapacity];
        n = 0;
    }

    public Val get(Key key) {
        int index = findIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    public void put(Key key, Val value) {
        int index = findIndex(key);
        if (index != -1) {
            values[index] = value;
            return;
        }
        if (n == keys.length) resize(n * 2);
        keys[n++] = key;
        values[n] = value;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(Key key) {
        return findIndex(key) != -1;
    }

    private void resize(int newSize) {
        keys = Arrays.copyOf(keys, newSize);
        values = Arrays.copyOf(values, newSize);
    }

    private int findIndex(Object key) {
        for (int i = 0; i < n; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

}
