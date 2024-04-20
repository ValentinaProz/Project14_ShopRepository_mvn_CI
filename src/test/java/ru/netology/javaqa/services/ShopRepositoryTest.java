package ru.netology.javaqa.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {
    @Test
    public void shouldRemoveItemWhenItExists() {
        ShopRepository repository = new ShopRepository();
        Product productEggs = new Product(4, "Eggs", 150);
        Product productPasta = new Product(7, "Pasta", 130);
        Product productMilk = new Product(9, "Milk", 79);

        repository.add(productEggs);
        repository.add(productPasta);
        repository.add(productMilk);
        repository.remove(7);

        Product[] expected = {productEggs, productMilk};
        Product[] actual = repository.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveItemWhenItDoesntExist() {
        ShopRepository repository = new ShopRepository();
        Product productEggs = new Product(4, "Eggs", 150);
        Product productPasta = new Product(7, "Pasta", 130);
        Product productMilk = new Product(9, "Milk", 79);

        repository.add(productEggs);
        repository.add(productPasta);
        repository.add(productMilk);

        Assertions.assertThrows(NotFoundException.class, () -> {
            repository.remove(3);
        });
    }

}