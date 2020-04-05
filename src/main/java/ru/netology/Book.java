package ru.netology;

import java.util.Objects;

public class Book extends Product{
    private  String author;

    public Book() {
        super();
    }

    public Book(int id, String name, int price, String author) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return getAuthor().equals(book.getAuthor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAuthor());
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                '}';
    }

    @Override
    public boolean matches(String search) {
        if (this == search) return true;
        if (search = null || getClass() != search.getClass()) return false;
        if (!super.matches(search)) return false;
        Book book = (Book) search;
        return author == book.author &&
                Objects.equals(author, book.author);
    }
}


