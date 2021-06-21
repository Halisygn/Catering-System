package com.techelevator.view;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class InventoryTest {

    @Test
    public void createItemList() {
        Inventory inventory=new Inventory();

        Item item = new Item("A1","Tropical Fruit Bowl",3.50,"A");
        Assert.assertEquals(item.getItemCode(),inventory.createItemList().get(0).getItemCode());

        item = new Item("A2","Meatballs",2.95,"A");
        Assert.assertEquals(item.getItemCode(),inventory.createItemList().get(1).getItemCode());

        item = new Item("A3","Bacon Wrapped Shrimp",4.15,"A");
        Assert.assertEquals(item.getItemCode(),inventory.createItemList().get(2).getItemCode());

    }

}


