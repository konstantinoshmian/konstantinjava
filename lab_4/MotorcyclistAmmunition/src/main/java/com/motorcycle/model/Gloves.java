package com.motorcycle.model;

public class Gloves extends Ammunition {
    private boolean isWinter;
    private String sliderMaterial;

    public Gloves(String brand, double price, double weight, boolean isWinter, String sliderMaterial) {
        super(brand, price, weight);
        this.isWinter = isWinter;
        this.sliderMaterial = sliderMaterial;
    }

    public boolean isWinter() { return isWinter; }
    public String getSliderMaterial() { return sliderMaterial; }

    @Override
    public String toString() {
        return "Gloves{" + super.toString() + ", Winter: " + isWinter + ", Slider: " + sliderMaterial + "}";
    }
}
