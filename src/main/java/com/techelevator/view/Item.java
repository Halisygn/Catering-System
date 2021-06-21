package com.techelevator.view;

public class Item {
    private String name;
    private String itemType;
    private String itemCode;
    private double price;
    private final int initialQuantity=50;
    private int quantity = 50;

    public Item(String itemCode, String name, double price, String itemType) {
        this.name = name;
        this.itemType = itemType;
        this.itemCode = itemCode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemCode() {
        return itemCode;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInitialQuantity() {
        return initialQuantity;
    }

    @Override
    public String toString() {

        String itemCodeString = String.format("%-6s", itemCode);
        String itemNameString = String.format("%-25s", name);
        String itemPriceString = String.format("$%-8.2f", price);
        String itemTypeString = String.format("%-8s", itemType);
        String itemQuantityString = String.format("%d", quantity);
        if (itemQuantityString.equals("0")) {
            itemQuantityString = String.format("%s", "Sold out");
        }

        return itemCodeString + itemNameString + itemPriceString + itemTypeString + itemQuantityString;
    }

    public String convertItemTypeToWord() {
        String word = null;
        if (itemType.equalsIgnoreCase("a")) {
            word = "Appetizer";
        }
        if (itemType.equalsIgnoreCase("b")) {
            word = "Beverage";
        }
        if (itemType.equalsIgnoreCase("e")) {
            word = "Entree";
        }
        if (itemType.equalsIgnoreCase("d")) {
            word = "Dessert";
        }
        return word;
    }

}
