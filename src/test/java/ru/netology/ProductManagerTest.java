package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    @Test
    void add() {
    }

    @Test
    void searchBy() {
    }

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product[] product = new Product[]{};
    private Smartphone[] smartphone;
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");

    // @BeforeEach
    @Test
    public void Set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldFindIfMatchesQuery() {
        String text = "The Hobbit";

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.searchBy(text);

        Product[] expected = new Product[]{second};
        Product[] actual = repository.getAll();

        assertArrayEquals(expected, actual);
    }
}
