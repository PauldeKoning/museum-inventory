package com.tudublin.view;

import com.tudublin.controller.InventoryController;
import com.tudublin.util.ItemUtil;

public class ItemList {

    private final InventoryController controller;

    public ItemList(InventoryController controller) {
        this.controller = controller;
    }

    public void listItems() {
        var items = this.controller.getItems();

        for (var item : items) {
            ItemUtil.printItem(item);
        }
    }
}
