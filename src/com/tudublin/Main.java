package com.tudublin;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        //Creating the Frame
        JFrame frame = new JFrame("Museum Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Museum Inventory Items");
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label); // Components Added using Flow Layout

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.setVisible(true);
    }
}
