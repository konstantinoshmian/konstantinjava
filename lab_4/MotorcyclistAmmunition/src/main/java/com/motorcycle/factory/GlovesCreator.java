package com.motorcycle.factory;

import com.motorcycle.model.Ammunition;
import com.motorcycle.model.Gloves;

public class GlovesCreator extends AmmunitionCreator {
    @Override
    public Ammunition createAmmunition(String[] args) {
        String brand = args[1].trim();
        double price = Double.parseDouble(args[2].trim());
        double weight = Double.parseDouble(args[3].trim());
        boolean isWinter = Boolean.parseBoolean(args[4].trim());
        String sliderMaterial = args[5].trim();

        return new Gloves(brand, price, weight, isWinter, sliderMaterial);
    }
}
