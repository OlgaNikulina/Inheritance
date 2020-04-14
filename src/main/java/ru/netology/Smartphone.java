package ru.netology;

import java.util.Objects;

public class Smartphone extends Product {
    private String producer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Smartphone)) return false;
        Smartphone that = (Smartphone) o;
        return getProducer().equals(that.getProducer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducer());
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "producer='" + producer + '\'' +
                "} " + super.toString();
    }

    @Override
    public boolean matches(String search) {

        return super.matches(search) || getProducer().equals(getProducer());
        }
    }
