package com.techelevator.view;

import java.util.HashMap;
import java.util.Map;

public class CashRegister {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public Map<String, Integer> makeChange() {
        Map<String, Integer> changeMap = new HashMap<>();
        Integer[] numberOfBillsAndCoins = new Integer[7];
        double remainder = 0;

        numberOfBillsAndCoins[0] = (int) balance / 20;
        remainder = balance % 20;
        numberOfBillsAndCoins[1] = (int) remainder / 10;
        remainder = remainder % 10;
        numberOfBillsAndCoins[2] = (int) remainder / 5;
        remainder = remainder % 5;
        numberOfBillsAndCoins[3] = (int) remainder;
        remainder = remainder % 1;
        numberOfBillsAndCoins[4] = (int) (remainder / 0.25);
        remainder = remainder % 0.25;
        numberOfBillsAndCoins[5] = (int) (remainder / 0.10);
        remainder = remainder % 0.10;
        numberOfBillsAndCoins[6] = (int) (remainder / 0.05);
        remainder = remainder % 0.05;

        changeMap.put("Nickels", numberOfBillsAndCoins[6]);
        changeMap.put("Dimes", numberOfBillsAndCoins[5]);
        changeMap.put("Quarters", numberOfBillsAndCoins[4]);
        changeMap.put("Dollars", numberOfBillsAndCoins[3]);
        changeMap.put("Fives", numberOfBillsAndCoins[2]);
        changeMap.put("Tens", numberOfBillsAndCoins[1]);
        changeMap.put("Twenties", numberOfBillsAndCoins[0]);

        return changeMap;

    }

    public double feedMoney(double amountToAdd) {
        return balance += amountToAdd;
    }

    public double setZero() {
        return balance = 0;
    }

    public String displayChange() {
        String changeMessage = "";
        for (Map.Entry<String, Integer> change : makeChange().entrySet()) {
            if (change.getValue() > 0) {
                changeMessage += change.getKey() + ": " + change.getValue() + " \n";
            }
        }
        return changeMessage;
    }

    public double removeFromBalance(double cartBalance) {
        return balance -= cartBalance;
    }
}
