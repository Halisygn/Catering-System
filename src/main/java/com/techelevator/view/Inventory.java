package com.techelevator.view;

import java.util.*;

public class Inventory {
    private Map<String, Item> mapOfItems;
    FileReader fileReader = new FileReader();
    List<Item> itemNameList = new ArrayList<>();

    public Inventory() {
        mapOfItems = fileReader.itemMap();
    }

    public Map<String, Item> getMapOfItems() {
        return mapOfItems;
    }

    public List<Item> createItemList() {
        Set<String> keys = mapOfItems.keySet();
        for (String key : keys) {
            itemNameList.add(mapOfItems.get(key));
        }
        return itemNameList;
    }

    public List<Item> getItemNameList() {
        return itemNameList;
    }

}
