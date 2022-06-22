package ru.netology.domain;
import java.util.Objects;

public class Book extends Product {
    private String author;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author);
    }

    public Book(String author, String name, int id, int price) {
        super(name, id, price);
        this.author = author;
    }
}