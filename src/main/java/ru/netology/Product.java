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
        Product[] items = new Product[0];

        if (product instanceof Book) {
            Book book = (Book) product;
            if (book.getName().equalsIgnoreCase(search)) {
                return true;
            }
            if (book.getAuthor().equalsIgnoreCase(search)) {
                return true;
            }

            if (product instanceof Smartphone) {
                Smartphone smartphone = (Smartphone) product;
                if (smartphone.getName().equalsIgnoreCase(search)) {
                    return true;
                }
                if (smartphone.getProducer().equalsIgnoreCase(search)) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}

