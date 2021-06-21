package com.techelevator.view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface() {
        scanner = new Scanner(System.in);
    }

    public String printMainMenu() {
        System.out.println("(1) Display Catering Items");
        System.out.println("(2) Order");
        System.out.println("(3) Quit");
        System.out.println("Please select your choice (number only): ");
        return scanner.nextLine();
    }

    public String printSubMenu(double balance) {
        String balanceString = String.format("%.2f", balance);
        System.out.println("(1) Add Money");
        System.out.println("(2) Select Products"); //user will type code here
        System.out.println("(3) Complete Transaction");
        System.out.println("Current Account Balance: $" + balanceString);
        System.out.println("Please select your choice (number only): ");

        return scanner.nextLine();
    }

    public void printErrorMessage(String message) {
        System.out.println(message + "\n");
    }

    public void printChange(String changeMessage) {
        System.out.println("Your change is \n" + changeMessage);
    }

    public void printListOfItems(List<Item> itemList) {
        String itemCodeTitle = String.format("%-6s", "Code");
        String itemNameTitle = String.format("%-25s", "Name");
        String itemPriceTitle = String.format("%-8s", "Price");
        String itemTypeTitle = String.format("%-8s", "Type");
        String itemQuantityTitle = String.format("%s", "Quantity");

        System.out.println(itemCodeTitle + itemNameTitle + itemPriceTitle + itemTypeTitle + itemQuantityTitle);
        for (Item item : itemList) {
            System.out.println(item.toString());
        }
    }

    public void printPurchaseReport(String reportMessage) {
        System.out.printf("%-10s%-12s%-21s%-12s%s\n", "Quantity", "Item Type", "Item Name", "Item Price", "Total Item Price");
        System.out.println(reportMessage);
    }

    public String getUserChoice() {
        System.out.println("Please enter the code for the item you wish to purchase: ");
        return scanner.nextLine();
    }

    public int getUserQuantityDesired() {
        System.out.println("Please enter the quantity of items you wish to purchase: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public String getAmountToFeed() {
        System.out.println("Please enter the amount you wish to add to your balance (in whole dollar amounts up to $5000): ");
        return scanner.nextLine();
    }

    public void showBalance(double balance) {
        String balanceString = String.format("%.2f", balance);
        System.out.println("Your current balance is : $" + balanceString);
    }

}
