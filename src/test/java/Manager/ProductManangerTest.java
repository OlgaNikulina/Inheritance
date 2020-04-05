package Manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.repository.ProductRepository;
import ru.netology.domain.Manager.ProductMananger;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductManangerTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductMananger mananger;

    @Test
    void shouldFindIfMatchesQuery() {
        String text = "Федиатрия";
        Product[] returned = new Product[]{};
        doReturn(returned).when(repository).findAll();
        doNothing().when(mananger.searchBy(text));

        mananger.searchBy("Федиатрия");
        Product[] expected = new Product[]{};
        Product[] actual = repository.getAll();
        assertArrayEquals(expected, actual);

        verify(mananger).searchBy(text);
    }
}
//E.g. thenReturn() may be missing.
//Examples of correct stubbing:
//    when(mock.isOk()).thenReturn(true);
//    when(mock.isOk()).thenThrow(exception);
//    doThrow(exception).when(mock).someVoidMethod();