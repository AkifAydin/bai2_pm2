package maps.buecherindizieren;

public class Buch {
    private String titel, autor, isbn, jahr;

    public Buch(String titel,String autor,String isbn,String jahr){
        this.titel=titel;
        this.autor = autor;
        this.isbn = isbn;
        this.jahr = jahr;
    }

    public String getTitel() {
        return titel;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getJahr() {
        return jahr;
    }
    @Override
    public String toString() {
        return "Buch{" +
                "titel='" + titel + '\'' +
                ", autor='" + autor + '\'' +
                ", isbn='" + isbn + '\'' +
                ", jahr='" + jahr + '\'' +
                '}';
    }
}

