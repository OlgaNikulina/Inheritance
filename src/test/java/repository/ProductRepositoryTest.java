package repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Manager.ProductManager;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.domain.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Book coreJava = new Book();
    private Smartphone nokiaA52 = new Smartphone();
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");
    private Smartphone i545 = new Smartphone(11, "i545", 15000, "Huawei");
    private Smartphone a71 = new Smartphone(12, "a71", 300, "Samsung");
    private Smartphone g643m = new Smartphone(13, "g643m", 300, "LG");

    @Test
    void shouldSaveOneBook() {
        repository.save(coreJava);

        Product[] expected = new Product[]{coreJava};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSaveOneSmartphone(){
        repository.save(nokiaA52);

        Product[] expected = new Product[]{nokiaA52};
        Product[]actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetEmpty() {
        repository.getAll();

        Product[] expected = new Product[]{};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldGetThreeBooks() {
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
    public void shouldGetTwoSmartphone() {
        ProductManager manager = new ProductManager(repository);

        manager.add(i545);
        manager.add(a71);
        manager.add(g643m);

        repository.getAll();

        Product[] expected = new Product[]{i545, a71, g643m};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }
}
