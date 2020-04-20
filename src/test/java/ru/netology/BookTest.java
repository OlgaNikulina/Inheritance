package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");
    private Product product = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book book = (Book) product;
    @Test
    public void Set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldGetBook() {
        String search = "Johann Wolfgang von Goethe";
        manager.add(first);
        boolean actual = book.matches(search);
        Assertions.assertEquals(true, actual);
    }

    @Test
    public void shouldNotGetBooks() {
        String search = "Three pigs";
        manager.add(first);
        manager.add(second);
        manager.add(third);
        boolean actual = book.matches(search);
        Assertions.assertEquals(false, actual);
    }
}
