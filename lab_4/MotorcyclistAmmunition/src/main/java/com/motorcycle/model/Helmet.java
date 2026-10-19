package com.motorcycle.model;

public class Helmet extends Ammunition {
    private String safetyCert;
    private String helmetType;

    public Helmet(String brand, double price, double weight, String safetyCert, String helmetType) {
        super(brand, price, weight);
        this.safetyCert = safetyCert;
        this.helmetType = helmetType;
    }

    public String getSafetyCert() { return safetyCert; }
    public String getHelmetType() { return helmetType; }

    @Override
    public String toString() {
        return "Helmet{" + super.toString() + ", Cert: " + safetyCert + ", Type: " + helmetType + "}";
    }
}
