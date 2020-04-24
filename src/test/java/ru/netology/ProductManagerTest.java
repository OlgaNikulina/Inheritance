package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");
    private Smartphone h450 = new Smartphone(1, "h450", 15000, "Huawei");
    private Smartphone a71 = new Smartphone(2, "a71", 20000, "Samsung");
    private Smartphone l324g = new Smartphone(3, "l324g", 12000, "LG");

    @BeforeEach
    public void Set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(h450);
        manager.add(a71);
        manager.add(l324g);
    }

    @Test
    void shouldFindBook() {
        String text = "The Hobbit";

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSmartphone() {
        String text = "Huawei";

        Product[] expected = new Product[]{h450};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBook() {
        String text = "Three pigs";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphone() {
        String text = "Miezu";

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }
}
