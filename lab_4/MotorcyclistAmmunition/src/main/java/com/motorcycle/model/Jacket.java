package com.motorcycle.model;

public class Jacket extends Ammunition {
    private String material;
    private boolean hasBackProtection;

    public Jacket(String brand, double price, double weight, String material, boolean hasBackProtection) {
        super(brand, price, weight);
        this.material = material;
        this.hasBackProtection = hasBackProtection;
    }

    public String getMaterial() { return material; }
    public boolean isHasBackProtection() { return hasBackProtection; }

    @Override
    public String toString() {
        return "Jacket{" + super.toString() + ", Material: " + material + ", Back Protection: " + hasBackProtection + "}";
    }
}
