package Manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.repository.ProductRepository;
import ru.netology.domain.Manager.ProductManager;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;



@ExtendWith(MockitoExtension.class)
class ProductManagerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Book[] book;
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");

    @BeforeEach
    @Test
    public void Set(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    void shouldFindIfMatchesQuery() {
        String text = "Faust";
        Product[] returned = new Product[]{};
        doReturn(returned).when(repository).findAll();
        doNothing().when(manager.searchBy(text));

        manager.searchBy("Faust");
        Product[] expected = new Product[]{};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);

        verify(manager).searchBy(text);
    }
}
//E.g. thenReturn() may be missing.
//Examples of correct stubbing:
//    when(mock.isOk()).thenReturn(true);
//    when(mock.isOk()).thenThrow(exception);
//    doThrow(exception).when(mock).someVoidMethod();