package com.motorcycle.factory;

import com.motorcycle.model.Ammunition;
import com.motorcycle.model.Helmet;

public class HelmetCreator extends AmmunitionCreator {
    @Override
    public Ammunition createAmmunition(String[] args) {
        String brand = args[1].trim();
        double price = Double.parseDouble(args[2].trim());
        double weight = Double.parseDouble(args[3].trim());
        String safetyCert = args[4].trim();
        String helmetType = args[5].trim();

        return new Helmet(brand, price, weight, safetyCert, helmetType);
    }
}
