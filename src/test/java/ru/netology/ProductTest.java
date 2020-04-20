package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product product = new Product(25, "bananas", 75);

    @Test
    void shouldGetProduct() {
        String search = "bananas";
        manager.add(product);
        product.matches(search);
        boolean actual = product.matches(search);
        Assertions.assertEquals(true, actual);
    }

    @Test
    void shouldNotGetProduct() {
        String search = "apples";
        manager.add(product);
        product.matches(search);
        boolean actual = product.matches(search);
        Assertions.assertEquals(false, actual);
    }
}
