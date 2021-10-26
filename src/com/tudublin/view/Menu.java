package com.tudublin.view;

import com.tudublin.controller.InventoryController;

import java.util.Scanner;

public class Menu {

    private final InventoryController controller;
    private final Scanner scan;

    public Menu(InventoryController controller) {
        this.controller = controller;
        this.scan = new Scanner(System.in);
    }

    public void show() {
        System.out.println("Welcome to the menu, please enter a following option:");
        System.out.println("l = List all items");
        System.out.println("c = Create an item");
        System.out.println("s = Search for item (Edit/Delete)");
        System.out.println("sort = Sort item list (Unnecessary, done automatically)");

        var input = scan.nextLine();

        switch (input.toLowerCase()) {
            case "l" -> controller.listItems();
            case "s" -> controller.searchItems();
            case "c" -> controller.createItem();
            case "sort" -> controller.sort();
        }
    }

}
