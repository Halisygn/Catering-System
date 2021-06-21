package com.techelevator.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileWriter {
    private String fileName = "Log.txt";
    private PrintWriter writer;
    private String logMessage;
    File newFile = new File(fileName);
    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss aa");
    Date date = new Date(System.currentTimeMillis());
    CashRegister cashRegister = new CashRegister();

    public FileWriter() {
        if (!newFile.exists()) {
            try {
                newFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            writer = new PrintWriter(newFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void writeToAFile(String message) {
        writer.println(message);
        writer.flush();
    }

    public void logItemChoice(Item item, int quantity, double balance) {
        logMessage = String.format("%s %s %s %s $%.2f $%.2f ", formatter.format(date), quantity, item.getName(),
                item.getItemCode(), item.getPrice() * quantity, balance);
        writeToAFile(logMessage);
    }

    public void chanceWriter(double balance) {
        logMessage = String.format("%s %s $%.2f $%.2f ", formatter.format(date),
                "Give Change", balance, cashRegister.setZero());
        writeToAFile(logMessage);
    }

    public void feedMoneyWriter(double amountToAdd, double balance) {
        logMessage = String.format("%s %s $%.2f $%.2f ", formatter.format(date),
                "Add Money", amountToAdd, balance);
        writeToAFile(logMessage);
    }

    public void closeFileWriter() {
        writer.close();
    }

}
