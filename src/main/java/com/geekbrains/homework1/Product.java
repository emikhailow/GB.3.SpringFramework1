package com.geekbrains.homework1;

import java.util.Random;

public class Product {

    private int id;
    private double cost;
    private String title;

    private static Random random = new Random();
    private static final int minPrice = 1;
    private static final int maxPrice = 1000;

    public Product(int id, double cost) {
        this.id = id;
        this.cost = cost;
        this.title = String.format("Item %d", id);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", cost=" + cost +
                ", title='" + title + '\'' +
                '}';
    }

    public Product(int id) {
        this.id = id;
        this.title = String.format("Item %d", id);
        this.cost = minPrice + (maxPrice - minPrice) * random.nextDouble();
    }

    public int getId() {
        return id;
    }

    public double getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }
}
