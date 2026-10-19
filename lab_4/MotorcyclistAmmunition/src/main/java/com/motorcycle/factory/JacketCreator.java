package com.motorcycle.factory;

import com.motorcycle.model.Ammunition;
import com.motorcycle.model.Jacket;

public class JacketCreator extends AmmunitionCreator {
    @Override
    public Ammunition createAmmunition(String[] args) {
        String brand = args[1].trim();
        double price = Double.parseDouble(args[2].trim());
        double weight = Double.parseDouble(args[3].trim());
        String material = args[4].trim();
        boolean hasBackProtection = Boolean.parseBoolean(args[5].trim());

        return new Jacket(brand, price, weight, material, hasBackProtection);
    }
}
