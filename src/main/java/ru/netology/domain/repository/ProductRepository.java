package ru.netology.domain.repository;

import ru.netology.domain.Product;

public class ProductRepository {

    private Product[] items = new Product[]{};

    public void save(Product item) {
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public Product[] getAll() {
        int length = items.length + 1;
        Product[] result = new Product[items.length];
        for (int i = 0; i < result.length; i++) {
            int index = items.length - 1;
            result[i] = items[index];
        }
        return result;
    }

    public Product[] findAll() {
        return items;
    }
}
