package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book coreJava = new Book();
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");

    @Test
    public void shouldGetTwoBooks() {
        ProductManager manager = new ProductManager(repository);

        manager.add(first);
        manager.add(second);
        manager.add(third);

        repository.getAll();

        Product[] expected = new Product[]{first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        int idToRemove = 2;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        repository.removeById(idToRemove);

        Product[] expected = new Product[]{first, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveIfNotExists() {
        int idToRemove = 4;

        manager.add(first);
        manager.add(second);
        manager.add(third);

        repository.removeById(idToRemove);

        Product[] expected = new Product[]{first, second, third};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
