package com.motorcycle.service;

import com.motorcycle.comparator.AmmunitionWeightComparator;
import com.motorcycle.model.Ammunition;
import com.motorcycle.model.Motorcyclist;

import java.util.ArrayList;
import java.util.List;

public class AmmunitionService {

    public double calculateTotalCost(Motorcyclist motorcyclist) {
        double total = 0;
        for (Ammunition ammo : motorcyclist.getEquippedAmmunition()) {
            total += ammo.getPrice();
        }
        return total;
    }

    public void sortByWeight(List<Ammunition> ammunitionList) {
        ammunitionList.sort(new AmmunitionWeightComparator());
    }

    public List<Ammunition> findByPriceRange(List<Ammunition> ammunitionList, double minPrice, double maxPrice) {
        List<Ammunition> found = new ArrayList<>();
        for (Ammunition ammo : ammunitionList) {
            if (ammo.getPrice() >= minPrice && ammo.getPrice() <= maxPrice) {
                found.add(ammo);
            }
        }
        return found;
    }
}
