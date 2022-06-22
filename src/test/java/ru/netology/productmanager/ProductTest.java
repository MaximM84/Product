package ru.netology.productmanager;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductTest {
    Product book1 = new Book("Franz Kafka", "Castle", 351, 289);
    Product book2 = new Book("Ernest Hemingway", "Goodbye arms", 999, 545);
    Product smartphone1 = new Smartphone("Huawei", "P40 Pro+", 66888, 99999);
    Product smartphone2 = new Smartphone("Huawei", "NOVA 9", 55500, 39999);
    CartRepository repo = new CartRepository();
    ProductManager manager = new ProductManager(repo);

    @Test
    void addProducts() {
        manager.add(book1);
        manager.add(smartphone1);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void searchByOneMatch() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("P40 Pro+");
        Product[] expected = {smartphone1};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void searchByNoMatch() {
        manager.add(book1);
        manager.add(smartphone1);
        manager.add(book2);
        manager.add(smartphone2);
        Product[] actual = manager.searchBy("frost");
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void searchWithoutProducts() {
        Product[] actual = manager.searchBy("P40 Pro+");
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void saveTwoProducts() {
        repo.save(book1);
        repo.save(smartphone1);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void removeById() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.removeById(999);
        Product[] actual = repo.findAll();
        Product[] expected = {book1, smartphone1, smartphone2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void removeByIdLastProduct() {
        repo.save(smartphone1);
        repo.removeById(66888);
        Product[] actual = repo.findAll();
        Product[] expected = {};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void removeByIdTwoProducts() {
        repo.save(book1);
        repo.save(smartphone1);
        repo.save(book2);
        repo.save(smartphone2);
        repo.removeById(351);
        repo.removeById(999);
        Product[] actual = repo.findAll();
        Product[] expected = {smartphone1, smartphone2};
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void searchById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        Product[] actual = repo.findById(55500);
        Product[] expected = {smartphone2};
        Assertions.assertArrayEquals(actual, expected);


    }


}