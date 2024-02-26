package org.fast_food.bill_receipt;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.apache.commons.io.FilenameUtils;
import org.fast_food.order.Order;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class BillReceiptWriter {
    public static final String TXT = ".txt";
    public static final String CSV = ".csv";
    public static final String PDF = ".pdf";
    private final BillReceiptGenerator billReceiptGenerator;

    public BillReceiptWriter(Order order) {
        this.billReceiptGenerator = new BillReceiptGenerator(order);
    }

    public void writeToFile(String content, String filePath) {
        // Write the content to the specified file
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
            writer.close();
            System.out.println("Bill receipt saved to: " + filePath);
        } catch (IOException e) {
            System.err.println("Failed to write bill receipt to file: " + e.getMessage());
        }
    }

    public void writeBillReceiptToTextFile(String filePath) {
        // Write the bill receipt content to a text file
        if (FilenameUtils.getExtension(filePath).isEmpty()) {
            filePath = filePath + TXT;
        }
        writeToFile(billReceiptGenerator.generateBillReceiptContent(), filePath);
    }

    public void writeBillReceiptToCSVFile(String filePath) {
        // Write the CSV content to a file
        if (FilenameUtils.getExtension(filePath).isEmpty()) {
            filePath = filePath + CSV;
        }
        writeToFile(billReceiptGenerator.generateBillReceiptComaSeparatedContent(), filePath);
    }

    public void writeBillReceiptToPDFFile(String filePath) {
        // Write the bill receipt content to a pdf file
        if (FilenameUtils.getExtension(filePath).isEmpty()) {
            filePath = filePath + PDF;
        }
        try (PdfDocument pdf = new PdfDocument(new PdfWriter(filePath))) {
            Document document = new Document(pdf);
            document.add(new Paragraph(billReceiptGenerator.generateBillReceiptContent()));
            document.close();
            System.out.println("PDF file saved to: " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to write PDF file: " + e.getMessage());
        }
    }
}
