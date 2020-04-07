package ru.netology;

public class ProductRepository {
        private Product[] items = new Product[0];

        public void save(Product item) {
            int length = items.length + 1;
            Product[] tmp = new Product[length];
            System.arraycopy(items, 0, tmp, 0, items.length);
            int lastIndex = tmp.length - 1;
            tmp[lastIndex] = item;
            items = tmp;
        }

        public Product[] getAll() {
            Product[] products = new Product[0];
            Product[] result = new Product[products.length];
            for (int i = 0; i < result.length; i++) {
                int index = products.length - i;
                result[i] = products[index];
            }
            return result;
        }

        public Product[] findAll() {
            return items;
        }

        public void removeById(int id) {
            int length = items.length - 1;
            Product[] tmp = new Product[length];
            int index = 0;
            for (Product item : items) {
                if (item.getId() != id) {
                    tmp[index] = item;
                    index++;
                }
            }
            items = tmp;
        }
    }
