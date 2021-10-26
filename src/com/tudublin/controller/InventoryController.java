package com.tudublin.controller;

import com.tudublin.model.Inventory;
import com.tudublin.model.Item;
import com.tudublin.view.ItemInput;
import com.tudublin.view.ItemList;
import com.tudublin.view.ItemSearch;
import com.tudublin.view.Menu;

import java.util.List;
import java.util.Scanner;

public class InventoryController {

    private final Inventory inventory;
    private final ItemList itemList;
    private final ItemInput itemInput;
    private final ItemSearch itemSearch;


    public InventoryController() {
        this.inventory = new Inventory();

        final var menu = new Menu(this);
        this.itemList = new ItemList(this.inventory.getItems());
        this.itemInput = new ItemInput();
        this.itemSearch = new ItemSearch(this);

        var scan = new Scanner(System.in);

        while (true) {
            menu.show();

            System.out.println("Do you want to go back to the menu? [Y/n]");
            var input = scan.nextLine();

            if (input.equalsIgnoreCase("n")) break;
        }
    }

    public void listItems() {
        this.itemList.show();
    }

    public void createItem() {
        var item = new Item();
        this.itemInput.show(item);

        this.inventory.addItem(item);
    }

    public void searchItems() {
        this.itemSearch.show();
    }

    public List<Item> linearSearch(String name) {
        return this.inventory.linearSearch(name);
    }

    public List<Item> binarySearch(String name) {
        return this.inventory.binarySearch(name);
    }

    public void editItem(Item item) {
        this.itemInput.show(item);
        this.inventory.sort();
    }

    public void deleteItem(Item item) {
        this.inventory.deleteItem(item);
    }

    public void sort() {
        this.inventory.sort();
    }
}
