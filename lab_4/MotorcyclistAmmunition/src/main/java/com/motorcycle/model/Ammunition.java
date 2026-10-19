package com.motorcycle.model;

import java.util.Objects;

public abstract class Ammunition {
    private String brand;
    private double price;
    private double weight;

    public Ammunition(String brand, double price, double weight) {
        this.brand = brand;
        this.price = price;
        this.weight = weight;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public double getWeight() { return weight; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ammunition that = (Ammunition) o;
        return Double.compare(that.price, price) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, price, weight);
    }

    @Override
    public String toString() {
        return String.format("Brand: %s, Price: %.2f, Weight: %.2f", brand, price, weight);
    }
}
