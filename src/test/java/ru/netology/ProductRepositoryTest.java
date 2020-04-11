package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {


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

    @Test
    void save() {
    }

    @Test
    void getAll() {
    }

    @Test
    void removeById() {
    }


}