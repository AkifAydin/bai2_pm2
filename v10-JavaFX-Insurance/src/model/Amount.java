package model;

import java.util.Objects;

public class Amount implements Comparable<Amount> {

    private int euro;

    public Amount(int euro) {
        this.euro = euro;
    }

    @Override
    public String toString() {
        return String.format("%s€",euro);
    }

    public Amount add(Amount o) {
        return new Amount(euro+o.euro);
    }
    public Amount add(int euro) {
        return new Amount(this.euro+euro);
    }
    public Amount sub(Amount o) {
        return new Amount(euro-o.euro);
    }

    public int getEuro() {
        return euro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Amount amount = (Amount) o;
        return this.euro == amount.euro;
    }

    @Override
    public int hashCode() {
        return Objects.hash(euro);
    }

    @Override
    public int compareTo(Amount o) {
        return euro-o.euro;
    }

}
