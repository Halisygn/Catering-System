package com.techelevator;

import com.techelevator.view.*;

public class CateringSystemCLI {
    private Inventory inventory = new Inventory();
    private CashRegister cashRegister = new CashRegister();
    private FileWriter fileWriter = new FileWriter();
    private ShoppingCart shoppingCart = new ShoppingCart();
    private UserInterface ui;

    public CateringSystemCLI(UserInterface ui) {
        this.ui = ui;
    }

    public static void main(String[] args) {
        UserInterface menu = new UserInterface();
        CateringSystemCLI cli = new CateringSystemCLI(menu);
        cli.run();
    }

    public void run() {
        boolean isRunning = true;
        inventory.createItemList();
        while (isRunning) {
            String mainMenuResponse = ui.printMainMenu();
            if (mainMenuResponse.equalsIgnoreCase("1")) { //Display Catering Items
                ui.printListOfItems(inventory.getItemNameList());
            } else if (mainMenuResponse.equalsIgnoreCase("2")) { // order submenu
                boolean submenuIsRunning = true;
                while (submenuIsRunning) {
                    String subMenuResponse = ui.printSubMenu(cashRegister.getBalance());
                    if (subMenuResponse.equalsIgnoreCase("1")) { // add money to balance
                        double response = Double.parseDouble(ui.getAmountToFeed());
                        if (response > 5000 || cashRegister.getBalance() + response > 5000) { // balance limited with $5000
                            ui.printErrorMessage("Balance may not exceed $5000. Please try again.");
                        } else {
                            cashRegister.feedMoney(response); // add money
                            ui.showBalance(cashRegister.getBalance());
                            fileWriter.feedMoneyWriter(response, cashRegister.getBalance()); // log add money
                        }
                    } else if (subMenuResponse.equalsIgnoreCase("2")) { // choose an item
                        ui.printListOfItems(inventory.getItemNameList());
                        String userItemChoice = ui.getUserChoice();
                        if (!inventory.getMapOfItems().containsKey(userItemChoice)) { // check to see if the item exists
                            ui.printErrorMessage("Item cannot be found. Please try again.");
                        } else {
                            Item item = inventory.getMapOfItems().get(userItemChoice); // assign item to user choice
                            try {
                                int userQuantityDesired = ui.getUserQuantityDesired();
                                if (userQuantityDesired > item.getQuantity()) { // check to see if we have enough items left
                                    ui.printErrorMessage("Insufficient quantity. Please try again.");
                                } else {
                                    double priceOfItemChoice = item.getPrice() * userQuantityDesired;
                                    if (priceOfItemChoice > cashRegister.getBalance()) {
                                        ui.printErrorMessage("Insufficient funds. Please try again.");
                                    } else {
                                        int updatedQuantity = item.getQuantity() - userQuantityDesired;
                                        item.setQuantity(updatedQuantity); // update item quantity
                                        shoppingCart.addItemToCart(item, userQuantityDesired); // add to shopping cart
                                        fileWriter.logItemChoice(item, userQuantityDesired, cashRegister.getBalance()); // log purchase
                                        cashRegister.removeFromBalance(priceOfItemChoice); // remove item price from the balance
                                    }
                                }
                            } catch (NumberFormatException e) {
                                ui.printErrorMessage("It is not a number!");
                            }
                        }
                    } else if (subMenuResponse.equalsIgnoreCase("3")) {
                        ui.printPurchaseReport(shoppingCart.getPurchaseReport()); // show purchase report
                        ui.printChange(cashRegister.displayChange()); // give chance
                        fileWriter.chanceWriter(cashRegister.getBalance()); // log set balance to zero
                        cashRegister.setZero();
                        submenuIsRunning = false;
                    }
                }
            } else if (mainMenuResponse.equalsIgnoreCase("3")) {
                fileWriter.closeFileWriter(); // close the file writer
                isRunning = false;
            }
        }
    }
}
