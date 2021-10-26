package com.tudublin.view;

import com.tudublin.model.Item;
import com.tudublin.util.ItemUtil;

import java.util.List;

public class ItemList {

    private final List<Item> items;

    public ItemList(List<Item> items) {
        this.items = items;
    }

    public void show() {
        for (var item : items) {
            ItemUtil.printItem(item);
        }
    }

}
