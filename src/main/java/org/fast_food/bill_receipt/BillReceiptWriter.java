package org.fast_food.bill_receipt;

import org.fast_food.order.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class BillReceiptWriter {
    public static final String TXT = ".txt";
    public static final String CSV = ".csv";
    private final Order order;
    private final BillReceiptGenerator billReceiptGenerator;

    public BillReceiptWriter(Order order) {
        this.order = order;
        this.billReceiptGenerator = new BillReceiptGenerator(order);
    }

    public void writeToFile(String content, String filePath) {
        // Write the content to the specified file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            System.out.println("Bill receipt saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to write bill receipt to file: " + e.getMessage());
        }
    }

    public void writeBillReceiptToTextFile(String filePath) {
        // Write the bill receipt content to a text file
        writeToFile(billReceiptGenerator.generateBillReceiptContent(), filePath + BillReceiptWriter.TXT);
    }

    public void writeBillReceiptToCSVFile(String filePath) {
        // Write the CSV content to a file
        writeToFile(billReceiptGenerator.generateBillReceiptComaSeparatedContent(), filePath + BillReceiptWriter.CSV);
    }
}
