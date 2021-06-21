package com.techelevator.view;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import java.util.Map;

import static org.junit.Assert.*;

public class ShoppingCartTest {
    ShoppingCart shoppingCart=new ShoppingCart();
    CashRegister cashRegister=new CashRegister();
    Inventory inventory=new Inventory();
    Item item =new Item("A2","Bacon",2.5,"A");
    Item item2 =new Item("B3","Beer",2.55,"B");
    @Test
    public void testAddItemToCart() {

        Map<Item, Integer> myMap = shoppingCart.addItemToCart(item,4);
        Assert.assertThat(myMap,hasEntry(item,4));

        myMap = shoppingCart.addItemToCart(item2,5);
        Assert.assertThat(myMap,hasEntry(item2,5));

    }


}
