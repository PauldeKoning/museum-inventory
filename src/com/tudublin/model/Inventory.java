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
        this.items.add(item);
        this.sort();
    }

    private void sort() { // Bubble sort
        int sorted = 0;

        while (sorted < this.items.size() - 1) {
            sorted = 0;
            for (int i = 0; i < this.items.size() - 1; i++) {
                if (this.items.get(i).getName().toLowerCase().compareTo(this.items.get(i + 1).getName().toLowerCase()) > 0) {
                    var temp = this.items.get(i);
                    this.items.set(i, this.items.get(i + 1));
                    this.items.set(i + 1, temp);
                } else {
                    sorted++;
                }
            }
        }
    }

    public List<Item> linearSearch(String name) {
        var found = new ArrayList<Item>();

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
        var lastGuess = (int)Math.floor((low + high) / 2.0);

        while (true) {
            var guess = (int)Math.floor((low + high) / 2.0);
            var guessObj = this.items.get(guess);

            if (guess == lastGuess) break;

            if (guessObj.getName().toLowerCase().equals(name)) {
                found.add(guessObj);
                for (int i = guess + 1; i < this.items.size(); i++) {
                    if (this.items.get(i).getName().equalsIgnoreCase(name)) found.add(this.items.get(i));
                }
                for (int i = guess - 1; i >= 0; i--) {
                    if (this.items.get(i).getName().equalsIgnoreCase(name)) found.add(this.items.get(i));
                }
                break;
            }

            if (guessObj.getName().toLowerCase().compareTo(name) > 0) {
                high = guess;
            } else {
                low = guess;
            }
        }

        return found;
    }

    public void deleteItem(Item item) {
        this.items.remove(item);
    }
}
