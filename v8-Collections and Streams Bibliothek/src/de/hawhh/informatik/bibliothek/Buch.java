package de.hawhh.informatik.bibliothek;

import java.io.Serializable;
import java.util.Objects;

public class Buch implements Serializable {

    private final String autor;
    private final String titel;
    private final int erschienen;
    private final String isbn;

    public Buch(String autor, String titel, int erschienen, String isbn){
        this.autor=autor;
        this.titel=titel;
        this.erschienen=erschienen;
        this.isbn=isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitel() {
        return titel;
    }

    public int getErschienen() {
        return erschienen;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buch buch = (Buch) o;
        return erschienen == buch.erschienen &&
                Objects.equals(autor, buch.autor) &&
                Objects.equals(titel, buch.titel) &&
                Objects.equals(isbn, buch.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autor, titel, erschienen, isbn);
    }

    @Override
    public String toString() {
        return "Buch{" +
                "titel='" + titel + '\'' +
                ", autor='" + autor + '\'' +
                ", erschienen='" + erschienen + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }

}
