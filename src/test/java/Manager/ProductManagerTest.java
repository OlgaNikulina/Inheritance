package Manager;


import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.repository.ProductRepository;
import ru.netology.domain.Manager.ProductManager;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");
    private Smartphone i545 = new Smartphone(11, "i545", 15000, "Huawei");
    private Smartphone a71 = new Smartphone(12, "a71", 300, "Samsung");
    private Smartphone g643m = new Smartphone(13, "g643m", 300, "LG");
    private Product product = new Product(99, "Bananas", 510);

    @Test
    public void Set() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(i545);
        manager.add(a71);
        manager.add(g643m);
        manager.add(product);
    }

    @Test
    void shouldFindBookIfMatchesQuery() {
        String text = "The Hobbit";

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindBook() {
        String text = "The three pigs";

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindIfSmartphoneMatchesQuery() {
        String text = "Samsung";

        manager.add(i545);
        manager.add(a71);
        manager.add(g643m);

        Product[] expected = new Product[]{a71};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindSmartphone() {
        String text = "Miezu";

        manager.add(i545);
        manager.add(a71);
        manager.add(g643m);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }
    @Test
    void shouldNotFindProduct() {
        String text = "Bananas";

        manager.add(product);


        Product[] expected = new Product[]{product};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }
}
