package com.motorcycle.model;

import java.util.ArrayList;
import java.util.List;

public class Motorcyclist {
    private String name;
    private List<Ammunition> equippedAmmunition;

    public Motorcyclist(String name) {
        this.name = name;
        this.equippedAmmunition = new ArrayList<>();
    }

    public String getName() { return name; }

    public List<Ammunition> getEquippedAmmunition() {
        return equippedAmmunition;
    }

    public void equip(Ammunition ammo) {
        if (ammo != null) {
            this.equippedAmmunition.add(ammo);
        }
    }
}
