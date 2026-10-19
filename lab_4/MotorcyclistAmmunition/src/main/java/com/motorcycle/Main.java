package com.motorcycle;

import com.motorcycle.model.Ammunition;
import com.motorcycle.model.Motorcyclist;
import com.motorcycle.parser.AmmunitionDataParser;
import com.motorcycle.service.AmmunitionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AmmunitionDataParser parser = new AmmunitionDataParser();
        AmmunitionService service = new AmmunitionService();

        logger.info("loading data from file");
        List<Ammunition> loadedAmmo = parser.loadAmmunitionFromFile("ammunition_data.txt");

        Motorcyclist rider = new Motorcyclist("alex");
        for (Ammunition ammo : loadedAmmo) {
            rider.equip(ammo);
        }

        logger.info("equipped ammunition successfully");
        for (Ammunition ammo : rider.getEquippedAmmunition()) {
            System.out.println(ammo);
        }

        double totalCost = service.calculateTotalCost(rider);
        System.out.printf("\nall ammunition total cost: %.2f\n", totalCost);

        System.out.println("\n--- sorting by weight (ascending) ---");
        service.sortByWeight(loadedAmmo);
        for (Ammunition ammo : loadedAmmo) {
            System.out.println(ammo);
        }

        double minPrice = 50.00;
        double maxPrice = 300.00;
        System.out.printf("\n--- items in price range from %.2f to %.2f ---\n", minPrice, maxPrice);
        List<Ammunition> filteredAmmo = service.findByPriceRange(loadedAmmo, minPrice, maxPrice);
        for (Ammunition ammo : filteredAmmo) {
            System.out.println(ammo);
        }
    }
}
