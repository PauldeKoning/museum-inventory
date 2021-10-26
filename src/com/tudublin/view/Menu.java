package com.tudublin.view;

import com.tudublin.controller.InventoryController;

import java.util.Scanner;

public class Menu {
    private final InventoryController controller;

    public Menu(InventoryController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the menu, please enter a following option:");
        System.out.println("l = List all items");
        System.out.println("c = Create an item");
        System.out.println("s = Search for item (Edit/Delete)");

        var input = scan.nextLine();

        switch (input.toLowerCase()) {
            case "l" -> {
                this.controller.listItems();
            }
            case "s" -> {
                this.controller.searchItems();
            }
            case "c" -> {
                this.controller.createItem();
            }
        }
    }
}
