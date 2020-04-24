package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.junit.StrictStubsRunnerTestListener;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Smartphone h450 = new Smartphone(1, "h450", 15000, "Huawei");
    private Smartphone a71 = new Smartphone(2, "a71", 20000, "Samsung");
    private Smartphone l324g = new Smartphone(3, "l324g", 12000, "LG");
    private Product product = new Smartphone(2, "a71", 20000, "Samsung");
    private Smartphone smartphone = (Smartphone) product;

    @BeforeEach
    public void Set() {
        manager.add(h450);
        manager.add(a71);
        manager.add(l324g);
    }

    @Test
    public void shouldGetSmartphone() {
        String search = "Samsung";
        boolean actual = smartphone.matches(search);
        assertTrue(actual);
    }

    @Test
    public void shouldNotGetSmartphone() {
        String search = "miezu";
        boolean actual = smartphone.matches(search);
        assertFalse(actual);
    }
}
