package de.hawhh.informatik.generics.sose2021;

import java.util.Arrays;

/**
 * Implementierung einer sehr einfachen Tabelle auf Basis von Arrays.
 * Aufgabe: Wandeln Sie die Implementierung in eine generische Klasse um.
 */

public class VerySimpleTable {
    private Object[] keys;
    private Object[] values;
    private int n;

    public VerySimpleTable(int initialCapacity) {
        this.keys = new Object[initialCapacity];
        this.values = new Object[initialCapacity];
        n = 0;
    }

    public Object get(Object key) {
        int index = findIndex(key);
        if (index != -1) {
            return values[index];
        }
        return null;
    }

    public void put(Object key, Object value) {
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

    public boolean containsKey(Object key) {
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
