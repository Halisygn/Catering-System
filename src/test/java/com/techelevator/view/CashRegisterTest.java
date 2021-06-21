package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
public class CashRegisterTest {

    CashRegister cashRegister = new CashRegister();

//    I'm not sure how to make this test work!
    @Test
    public void makeChange() {
        Map<String, Integer> testMap = new HashMap<>();
        testMap.put("Nickels", 0);
        testMap.put("Dimes", 0);
        testMap.put("Quarters", 0);
        testMap.put("Dollars", 0);
        testMap.put("Fives", 0);
        testMap.put("Tens", 0);
        testMap.put("Twenties", 0);

        Assert.assertEquals(testMap, cashRegister.makeChange());
    }

    @Test
    public void feedMoney() {
        Assert.assertEquals(50, cashRegister.feedMoney(50), 0);
        Assert.assertEquals(200, cashRegister.feedMoney(150), 0);
        Assert.assertEquals(259.25, cashRegister.feedMoney(59.25), 0);
        Assert.assertEquals(288.75, cashRegister.feedMoney(29.50), 0);
    }

    @Test
    public void setZero() {
        Assert.assertEquals(0, cashRegister.setZero(), 0);
    }

    @Test
    public void removeFromBalance() {
        cashRegister.feedMoney(1000);
        Assert.assertEquals(925, cashRegister.removeFromBalance(75), 0);
        Assert.assertEquals(899.75, cashRegister.removeFromBalance(25.25), 0);
        Assert.assertEquals(399.25, cashRegister.removeFromBalance(500.50), 0);
    }
}