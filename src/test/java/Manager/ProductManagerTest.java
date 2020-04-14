package Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.repository.ProductRepository;
import ru.netology.domain.Manager.ProductManager;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);
    private Product[] product = new Product[]{};
    private Smartphone[] smartphone;
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");

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

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFind() {
        String text = "The three pigs";

        manager.add(first);
        manager.add(second);
        manager.add(third);

        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

}