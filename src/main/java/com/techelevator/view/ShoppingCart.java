package com.techelevator.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {

    Map<Item, Integer> cartMap = new HashMap<>();

    public Map<Item, Integer> addItemToCart(Item item, int quantity) {
        if (cartMap.containsKey(item)) {
            cartMap.put(item, cartMap.get(item) + quantity);
        } else {
            cartMap.put(item, quantity);
        }
        return cartMap;
    }

    public String getPurchaseReport() {
        Set<Item> keys = cartMap.keySet();
        String report = "";
        double total = 0;
        for (Item key : keys) {
            String quantityOfItems = String.format("%-10s", key.getInitialQuantity() - key.getQuantity());
            String itemTypeAsWord = String.format("%-12s", key.convertItemTypeToWord());
            String itemName = String.format("%-21s", key.getName());
            String unitPrice = String.format("$%-12.2f", key.getPrice());
            String totalPriceOfUnits = String.format("$%.2f", key.getPrice() * (key.getInitialQuantity() - key.getQuantity()));
            total += key.getPrice() * (key.getInitialQuantity() - key.getQuantity());

            report += quantityOfItems + itemTypeAsWord + itemName + unitPrice + totalPriceOfUnits + "\n";
        }
        report += "\nTotal price is: $" + String.format("%.2f", total);
        return report;
    }

}
