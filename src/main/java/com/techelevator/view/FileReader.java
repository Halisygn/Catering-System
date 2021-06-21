package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReader {
    private String path = "cateringsystem.csv";
    private File file = new File(path);
    private Scanner scanner;

    public Map<String, Item> itemMap() {
        Map<String, Item> itemMap = new TreeMap<>();
        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String record = scanner.nextLine();
                String[] fields = record.split("\\|");
                Item item = new Item(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3]);

                itemMap.put(item.getItemCode(), item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return itemMap;
    }
}
