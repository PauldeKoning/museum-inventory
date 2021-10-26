package com.tudublin.controller;

import com.tudublin.model.Inventory;
import com.tudublin.model.Item;
import com.tudublin.view.ItemCreate;
import com.tudublin.view.ItemList;
import com.tudublin.view.ItemSearch;
import com.tudublin.view.Menu;

import java.util.List;

public class InventoryController {
    private final ItemList itemList;
    private final Inventory inventory;

    public InventoryController() {
        this.inventory = new Inventory();
        this.itemList = new ItemList(this);

        Menu menu = new Menu(this);

        while (true) {
            menu.showMenu();
        }
    }

    public List<Item> getItems() {
        return this.inventory.getItems();
    }

    public void addItem(Item item) {
        this.inventory.addItem(item);
    }

    public void listItems() {
        this.itemList.listItems();
    }

    public void createItem() {
        new ItemCreate(this);
    }

    public void searchItems() {
        new ItemSearch(this);
    }

    public List<Item> linearSearch(String name) {
        return this.inventory.linearSearch(name);
    }

    public List<Item> binarySearch(String name) {
        return this.inventory.binarySearch(name);
    }

    public void editItem(Item item) {
        // TODO
    }

    public void deleteItem(Item item) {
        this.inventory.deleteItem(item);
    }
}
