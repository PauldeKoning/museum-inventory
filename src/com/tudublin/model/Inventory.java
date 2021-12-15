package com.tudublin.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Inventory {
    private final ArrayList<Item> items;

    public Inventory() {
        items = new ArrayList<>();

        var gun1 = new Item();
        gun1.setName("Gun1");
        gun1.setDescription("Gun1");
        gun1.setCountry("GunCountry1");
        gun1.setOriginDate(new Date());
        items.add(gun1);

        var gun2 = new Item();
        gun2.setName("Gun2");
        gun2.setDescription("Gun2");
        gun2.setCountry("GunCountry2");
        gun2.setOriginDate(new Date());
        items.add(gun2);

        var gun3 = new Item();
        gun3.setName("Gun3");
        gun3.setDescription("Gun3");
        gun3.setCountry("GunCountry3");
        gun3.setOriginDate(new Date());
        items.add(gun3);

        var tank1 = new Item();
        tank1.setName("Tank1");
        tank1.setDescription("Tank1");
        tank1.setCountry("TankCountry1");
        tank1.setOriginDate(new Date());
        items.add(tank1);
        var tank2 = new Item();
        tank2.setName("Tank1");
        tank2.setDescription("Tank1");
        tank2.setCountry("TankCountry1");
        tank2.setOriginDate(new Date());
        items.add(tank2);

        this.sort();
    }

    public List<Item> getItems() {
        return this.items;
    }

    public void addItem(Item item) {
        // Add item to item array
        this.items.add(item);

        // Sort the array
        this.sort();
    }

    public void sort() { // Bubble sort
        // Set sort counter
        int sorted = 0;

        // While array is not sorted
        while (sorted < this.items.size() - 1) {
            // Reset sorted counter
            sorted = 0;
            for (int i = 0; i < this.items.size() - 1; i++) {
                // Check whether the current index should be higher than next index
                if (this.items.get(i).getName().toLowerCase().compareTo(this.items.get(i + 1).getName().toLowerCase()) > 0) {
                    // Switch them around
                    var temp = this.items.get(i);
                    this.items.set(i, this.items.get(i + 1));
                    this.items.set(i + 1, temp);
                } else {
                    // Else one value is sorted
                    sorted++;
                }
            }
        }
    }

    public List<Item> linearSearch(String name) {
        var found = new ArrayList<Item>();

        // Go through every element O(n)
        for (var item : this.items) {
            if (item.getName().equalsIgnoreCase(name)) {
                found.add(item);
            }
        }

        return found;
    }

    public List<Item> binarySearch(String name) {
        var found = new ArrayList<Item>();

        var low = 0;
        var high = this.items.size();
        var lastGuess = 0;

        while (true) {
            // Create guess which is in the middle of low and high
            var guess = (int)Math.floor((low + high) / 2.0);
            var guessObj = this.items.get(guess);

            // If there is no value found, break
            if (guess == lastGuess) break;

            // If item is found
            if (guessObj.getName().toLowerCase().equals(name)) {
                // Add item to found list
                found.add(guessObj);
                // Loop left, add other equal items
                for (int i = guess + 1; i < this.items.size(); i++) {
                    if (this.items.get(i).getName().equalsIgnoreCase(name)) found.add(this.items.get(i));
                }
                // Loop right, add other equal items
                for (int i = guess - 1; i >= 0; i--) {
                    if (this.items.get(i).getName().equalsIgnoreCase(name)) found.add(this.items.get(i));
                }
                // Break from loop
                break;
            }

            // If the guess is after search
            if (guessObj.getName().toLowerCase().compareTo(name) > 0) {
                high = guess; // Set high to current guess
            } else {
                low = guess; // Set low to current guess
            }

            // Set lastguess
            lastGuess = guess;
        }

        return found;
    }

    public void deleteItem(Item item) {
        this.items.remove(item);
    }
}
