package com.motorcycle.parser;

import com.motorcycle.factory.AmmunitionCreator;
import com.motorcycle.factory.GlovesCreator;
import com.motorcycle.factory.HelmetCreator;
import com.motorcycle.factory.JacketCreator;
import com.motorcycle.model.Ammunition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AmmunitionDataParser {
    private static final Logger logger = LogManager.getLogger(AmmunitionDataParser.class);

    public List<Ammunition> loadAmmunitionFromFile(String fileName) {
        List<Ammunition> list = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is == null) {
                logger.error("file not found: {}", fileName);
                return list;
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) continue;

                    try {
                        Ammunition ammo = parseLine(line);
                        if (ammo != null) {
                            list.add(ammo);
                        }
                    } catch (Exception e) {
                        logger.warn("error line ignored: {} | reason: {}", line, e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("critical error: {}", e.getMessage());
        }
        return list;
    }

    private Ammunition parseLine(String line) throws IllegalArgumentException {
        String[] tokens = line.split(";");
        if (tokens.length < 4) {
            throw new IllegalArgumentException("invalid token count");
        }

        String type = tokens[0].trim().toLowerCase();
        AmmunitionCreator creator;

        switch (type) {
            case "helmet":
                creator = new HelmetCreator();
                break;
            case "jacket":
                creator = new JacketCreator();
                break;
            case "gloves":
                creator = new GlovesCreator();
                break;
            default:
                throw new IllegalArgumentException("unknown ammunition type: " + tokens[0]);
        }

        try {
            double price = Double.parseDouble(tokens[2].trim());
            double weight = Double.parseDouble(tokens[3].trim());
            if (price < 0 || weight <= 0) {
                throw new IllegalArgumentException("negative price or weight");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("number format error");
        }

        return creator.createAmmunition(tokens);
    }
}
