package ru.netology;

public class Product {
    private int id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


    public boolean matches(String search) {
        ProductRepository repository = new ProductRepository();
        Book book = new Book();
        Product[] result = new Product[]{};
        for (Product product : repository.findAll())
            if (this.matches(search) = book.getName()) {
                Product[] tmp = new Product[result.length];
                System.arraycopy(product, 0, tmp, 0, result.length);
                tmp[tmp.length] = product;
                result = tmp;
            }
        return true;
    }
}



