package com.tudublin.view;

import com.tudublin.controller.InventoryController;
import com.tudublin.model.Item;
import com.tudublin.util.ItemUtil;

import java.util.List;
import java.util.Scanner;

public class ItemSearch {
    private final Scanner scan;
    private final InventoryController controller;

    public ItemSearch(InventoryController controller) {
        this.scan = new Scanner(System.in);
        this.controller = controller;
    }

    public void show() {
        getSearchAlgorithm();
    }

    private void getSearchAlgorithm() {
        System.out.println("How would you like to search? Linear or Binary? [l/b]");

        var algorithm = this.scan.nextLine();

        switch (algorithm.toLowerCase()) {
            case "l" -> itemsFound(this.controller.linearSearch(getName()));
            case "b" -> itemsFound(this.controller.binarySearch(getName()));
            default -> getSearchAlgorithm();
        }
    }

    private void itemsFound(List<Item> found) {
        if (found.size() == 0) {
            System.out.println("No items found...");
            return;
        }

        int index = 0;

        if (found.size() > 1) {
            for (int i = 0; i < found.size(); i++) {
                System.out.println("ID: " + (i + 1));
                ItemUtil.printItem(found.get(i));
            }

            System.out.println("Please select one item.");
            index = Integer.parseInt(this.scan.nextLine()) - 1;

            System.out.println("Selected:");
        }

        var selected = found.get(index);
        ItemUtil.printItem(selected);

        itemAction(selected);
    }

    private void itemAction(Item item) {
        System.out.println("What would you like to do with this item? Nothing, Edit, Delete? [n/e/d]");

        var action = this.scan.nextLine();

        switch (action.toLowerCase()) {
            case "n" -> {}
            case "e" -> this.controller.editItem(item);
            case "d" -> this.controller.deleteItem(item);
            default -> itemAction(item);
        }
    }

    private String getName() {
        System.out.println("What name would you like to search for?");
        return this.scan.nextLine().toLowerCase();
    }
}
