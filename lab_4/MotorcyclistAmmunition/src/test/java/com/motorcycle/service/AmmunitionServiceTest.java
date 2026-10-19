package com.motorcycle.service;

import com.motorcycle.model.Ammunition;
import com.motorcycle.model.Helmet;
import com.motorcycle.model.Motorcyclist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class AmmunitionServiceTest {

    @Test
    public void testCalculateTotalCost() {
        AmmunitionService service = new AmmunitionService();
        Motorcyclist rider = new Motorcyclist("test-rider");

        rider.equip(new Helmet("Shoei", 400.0, 1.4, "ECE", "Integral"));
        rider.equip(new Helmet("AGV", 200.0, 1.3, "DOT", "Modular"));

        double totalCost = service.calculateTotalCost(rider);

        Assertions.assertEquals(600.0, totalCost, 0.001, "total cost math error");
    }

    @Test
    public void testSortByWeight() {
        AmmunitionService service = new AmmunitionService();
        List<Ammunition> list = new ArrayList<>();

        Ammunition heavy = new Helmet("HeavyBrand", 100.0, 2.5, "DOT", "Integral");
        Ammunition light = new Helmet("LightBrand", 100.0, 1.1, "DOT", "Integral");

        list.add(heavy);
        list.add(light);

        service.sortByWeight(list);

        Assertions.assertEquals(light, list.get(0), "sorting logic broken");
    }
}
