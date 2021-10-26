package com.tudublin.view;

import com.tudublin.model.Item;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ItemInput {
    private final Scanner scan;

    public ItemInput() {
        this.scan = new Scanner(System.in);
    }

    public void show(Item item) {
        item.setName(
                this.askInput(item.getName(), "What name should this item have?")
        );

        item.setDescription(
                this.askInput(item.getDescription(), "What description should this item have?")
        );

        item.setOriginDate(
                this.askInput(item.getOriginDate(),"What date has this item originated from? (yyyy-MM-dd)")
        );

        item.setCountry(
                this.askInput(item.getCountry(), "What country is this item from?")
        );

        item.setValue(
                this.askInput(item.getValue(), "What is the estimated value of this item?")
        );
    }

    private String askInput(String existing, String question) {
        // Ask question and show optional existing value
        System.out.println(question);
        if (existing != null)
            System.out.println("[" + existing + "]");

        // Get user input
        var input = this.scan.nextLine();

        // If there is no existing value, return current input immediately
        if (existing == null) return input;

        // Else if users type an empty string, keep existing. Else return input.
        return input.strip().equals("") ? existing : input;
    }

    private Float askInput(Float existing, String question) {
        System.out.println(question);
        if (existing != null)
            System.out.println("[" + existing + "]");

        var input = this.scan.nextLine();

        // Parse the float, if
        float parsedFloat;
        try {
            parsedFloat = Float.parseFloat(input);
        } catch (NumberFormatException ignored) {
            return this.askInput(existing, question);
        }

        if (existing == null) return parsedFloat;

        return input.equals("") ? existing : parsedFloat;
    }

    private Date askInput(Date existing, String question) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(question);
        if (existing != null)
            System.out.println("[" + format.format(existing) + "]");

        var input = this.scan.nextLine();

        if (existing != null && input.equals("")) {
            return existing;
        }

        Date formattedDate;

        try {
            formattedDate = format.parse(input);
        } catch (ParseException e) {
            System.out.println("Date is entered incorrectly... Try again...");
            return askInput(existing, question);
        }

        return formattedDate;
    }

}
