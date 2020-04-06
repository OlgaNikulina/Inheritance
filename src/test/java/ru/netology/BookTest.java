package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookTest {
    @Mock
    private ProductRepository repository;
    @InjectMocks
    private ProductManager manager;
    private Product[] product;
    private Book[] book;
    private Book first = new Book(1, "Faust", 300, "Johann Wolfgang von Goethe");
    private Book second = new Book(2, "The Hobbit", 250, "John Ronald Reuel Tolkien");
    private Book third = new Book(3, "Доктор Живаго", 300, "Борис Пастернак");

    @BeforeEach
    @Test
    public void shouldGetFieldsFromSuperClass(){
        Book book = new Book();
    }

    @Test
    public void shouldCastFromParentClass(){
        Product product = new Book();
        if (product instanceof Book){
            Book book = (Book) product;
        }
    }

    @Test
    public void Set(){
        manager.add(first);
        manager.add(second);
        manager.add(third);
    }

    @Test
    public void shouldGetIfMatches() {
        String search = "Faust";
        Product[] returned = new Book[]{first, second, third};
        doReturn(returned).when(repository).getAll();
        doNothing().when(book).matches(search);

        book.matches(search);
        Product[] expected = new Book[]{first, second, third};
        Product[] actual = repository.findAll();
        assertEquals(expected, actual);

        verify(book).matches(search);
    }
}