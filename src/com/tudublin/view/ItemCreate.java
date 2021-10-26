package com.tudublin.view;

import com.tudublin.controller.InventoryController;
import com.tudublin.model.item.Item;
import com.tudublin.model.item.impl.Gun;
import com.tudublin.model.item.impl.Tank;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ItemCreate {
    private Item item;
    private final Scanner scan;

    public ItemCreate(InventoryController controller) {
        this.scan = new Scanner(System.in);

        getType();
        getName();
        getDescription();
        getCountry();
        getOriginDate();

        controller.addItem(item);
    }

    private void getName() {
        System.out.println("What name has this item got?");
        this.item.setName(this.scan.nextLine());
    }

    private void getDescription() {
        System.out.println("What description has this item got?");
        this.item.setDescription(this.scan.nextLine());
    }

    private void getOriginDate() {
        System.out.println("What date has this item originated from? [yyyy-MM-dd]");
        var date = this.scan.nextLine();

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date formattedDate;

        try {
            formattedDate = format.parse(date);
        } catch (ParseException e) {
            System.out.println("Date is entered incorrectly... Try again...");
            getOriginDate();
            return;
        }

        this.item.setOriginDate(formattedDate);
    }

    private void getCountry() {
        System.out.println("What country is this item from?");
        this.item.setCountry(this.scan.nextLine());
    }

    private void getType() {
        System.out.println("What do you want to create? [gun/tank]");
        var input = this.scan.nextLine();

        switch (input.toLowerCase()) {
            case "gun" -> {
                this.item = new Gun();
            }
            case "tank" -> {
                this.item = new Tank();
            }
            default -> getType();
        }
    }
}