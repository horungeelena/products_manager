package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;
import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);

    Product product1 = new Book(1, "First", 500,"First First");
    Product product2 = new Book(2,"Second", 300, "Second Second");
    Product product3 = new Smartphone(3,"Smart", 5000, "Third");
    Product product4 = new Smartphone(4, "Phone", 3000, "Fourth");

    @BeforeEach
    void setUp() {
        manager.addProduct(product1);
        manager.addProduct(product2);
        manager.addProduct(product3);
        manager.addProduct(product4);
    }

    @Test
    void shouldSearchByBookName() {
        Product[] expected = {new Book(1, "First", 500,"First First")};
        Product[] actual = manager.searchBy("First");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByBookAuthor() {
        Product[] expected = {new Book(2,"Second", 300, "Second Second")};
        Product[] actual = manager.searchBy("Second Second");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneName() {
        Product[] expected = {new Smartphone(3,"Smart", 5000, "Third")};
        Product[] actual = manager.searchBy("Smart");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySmartphoneManufacturer() {
        Product[] expected = {new Smartphone(4, "Phone", 3000, "Fourth")};
        Product[] actual = manager.searchBy("Fourth");
        assertArrayEquals(expected, actual);
    }
}