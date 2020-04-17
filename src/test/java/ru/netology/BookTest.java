package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BookTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");

    @Test
    public void shouldGetFieldsFromSuperClass() {
        Book book = new Book();
    }

    @Test
    public void Set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldGetIfMatches() {
        Product product = new Product(1, "Faust", 300);
        String search = "Faust";

        manager.add(first);
        manager.add(second);
        manager.add(third);
        product.matches(search);

        Product[] expected = new Product[]{first};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}