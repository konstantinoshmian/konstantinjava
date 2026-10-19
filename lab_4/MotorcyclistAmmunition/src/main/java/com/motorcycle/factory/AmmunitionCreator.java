package com.motorcycle.factory;

import com.motorcycle.model.Ammunition;

public abstract class AmmunitionCreator {
    public abstract Ammunition createAmmunition(String[] args);
}
