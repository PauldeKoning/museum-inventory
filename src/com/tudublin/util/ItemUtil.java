package com.tudublin.util;

import com.tudublin.model.Item;

import java.text.SimpleDateFormat;

public class ItemUtil {

    public static void printItem(Item item) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("Name: " + item.getName());
        System.out.println("Origin: " + format.format(item.getOriginDate()));
        System.out.println("Country: " + item.getCountry());
        System.out.println("Description: " + item.getDescription());
        System.out.println("Value: " + item.getValue());
        System.out.println();
    }

}
