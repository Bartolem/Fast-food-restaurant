package org.fast_food.bill_receipt;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.HorizontalAlignment;
import com.itextpdf.layout.properties.TextAlignment;
import org.apache.commons.io.FilenameUtils;
import org.fast_food.customer.Customer;
import org.fast_food.order.Order;
import org.fast_food.product.Product;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Arrays;

public class BillReceiptWriter {
    public static final String TXT = ".txt";
    public static final String CSV = ".csv";
    public static final String PDF = ".pdf";
    private final Order order;
    private final Customer customer;
    private final BillReceiptGenerator billReceiptGenerator;

    public BillReceiptWriter(Order order) {
        this.order = order;
        this.customer = order.getCustomer();
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

            Image image = new Image(ImageDataFactory.create("src/main/resources/logo.png"));
            image.scaleToFit(175, 62.5f);
            image.setMarginBottom(25f);
            image.setHorizontalAlignment(HorizontalAlignment.CENTER);

            float[] columnWidth = {250f, 75f, 75f};
            Table contentTable = new Table(columnWidth);
            contentTable.setMarginBottom(25f);
            contentTable.setHorizontalAlignment(HorizontalAlignment.CENTER);

            Cell[] tableHeaders = {
                    new Cell().add(new Paragraph("Product name")),
                    new Cell().add(new Paragraph("Price")),
                    new Cell().add(new Paragraph("Quantity"))
            };

            Arrays.stream(tableHeaders).forEach(cell -> {
                cell.setBackgroundColor(new DeviceRgb(91, 192, 255));
                cell.setTextAlignment(TextAlignment.CENTER);
            });

            contentTable.addCell(tableHeaders[0]);
            contentTable.addCell(tableHeaders[1]);
            contentTable.addCell(tableHeaders[2]);

            int index = 0;

            for (Product product : order.getContent().keySet()) {
                DeviceRgb backgroundColor = new DeviceRgb(168, 221, 255);

                if (index % 2 != 0) {
                    backgroundColor = new DeviceRgb(214, 239, 255);
                }

                contentTable.addCell(new Cell().add(new Paragraph(product.getName())).setBackgroundColor(backgroundColor));
                contentTable.addCell(new Cell().add(new Paragraph(String.valueOf(product.getPrice()))).setBackgroundColor(backgroundColor).setTextAlignment(TextAlignment.RIGHT));
                contentTable.addCell(new Cell().add(new Paragraph(String.valueOf(order.getContent().get(product)))).setBackgroundColor(backgroundColor).setTextAlignment(TextAlignment.CENTER));
                index++;
            }

            columnWidth = new float[]{150f, 250f};
            Table infoTable = new Table(columnWidth);

            infoTable.setHorizontalAlignment(HorizontalAlignment.CENTER);
            infoTable.addCell(new Cell().add(new Paragraph("Customer")).setBorder(Border.NO_BORDER));

            if (customer == null) {
                infoTable.addCell(new Cell().add(new Paragraph("Guest (no account)")).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
            } else {
                infoTable.addCell(new Cell().add(new Paragraph(customer.getFirstName() + " " + customer.getLastName())).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
            }

            infoTable.addCell(new Cell().add(new Paragraph("Order Id")).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph(order.getId().toString())).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph("Order date")).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph(order
                    .getDate()
                    .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM))).setTextAlignment(TextAlignment.RIGHT)).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph("Total price")).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph(order.getFormattedTotalPrice()).setTextAlignment(TextAlignment.RIGHT)).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph("Discount")).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph(order.getFormattedDiscount()).setTextAlignment(TextAlignment.RIGHT)).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph("Total price after discount")).setBorder(Border.NO_BORDER));
            infoTable.addCell(new Cell().add(new Paragraph(order.getFormattedTotalPriceAfterDiscount()).setTextAlignment(TextAlignment.RIGHT)).setBorder(Border.NO_BORDER));

            document.add(image);
            document.add(contentTable);
            document.add(infoTable);
            document.add(new Paragraph("Thank you for using my application. Bartolem.").setTextAlignment(TextAlignment.CENTER).setMargin(50f));
            document.close();
            JOptionPane.showMessageDialog(null, "PDF file saved to: " + filePath);
            System.out.println("PDF file saved to: " + filePath);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to write PDF file: " + e.getMessage());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
