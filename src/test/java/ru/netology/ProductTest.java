package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    Product[] product = new Product[]{};

    @Test
    void shouldGetBookIfMatches() {
        Product product = new Product();
        String search = "The Hobbit";
        manager.add(first);
        manager.add(second);
        manager.add(third);

        product.matches(search);

        Product[] expected = new Product[]{second};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }
}