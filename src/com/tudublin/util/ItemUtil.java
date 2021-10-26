package com.tudublin.util;

import com.tudublin.model.item.Item;

public class ItemUtil {

    public static void printItem(Item item) {
        System.out.println("Name: " + item.getName());
        System.out.println("Origin: " + item.getOriginDate());
        System.out.println("Country: " + item.getCountry());
        System.out.println("Description: " + item.getDescription());
        System.out.println();
    }

}
