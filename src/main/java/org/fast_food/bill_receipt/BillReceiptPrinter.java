package org.fast_food.bill_receipt;

import org.fast_food.order.Order;
import org.fast_food.product.Product;
import org.fast_food.user_interface.UserInterface;

import java.awt.*;
import java.awt.print.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

public class BillReceiptPrinter implements Printable {
    private final Order order;
    private final Map<Product, Integer> products;
    public BillReceiptPrinter(Order order) {
        this.order = order;
        this.products = order.getContent();
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        // Create a graphics2D object
        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Bill receipt content drawing logic goes here
        drawReceiptContent(g2d);
        return PAGE_EXISTS;
    }

    private void drawReceiptContent(Graphics2D g2d) {
        g2d.setFont(new Font("Verdana", Font.PLAIN, 12));
        // x and y coordinates where each string will be drawn on the page
        int x = 0;
        int y = 25;
        int index = 1;
        // Draw header
        g2d.drawString(UserInterface.TITLE, x+200, y);
        y += 50;
        g2d.drawString("Product name", x, y);
        g2d.drawString("Price", x+300, y);
        g2d.drawString("Quantity", x+375, y);
        y += 25;
        // Draw order content
        for (Product product : products.keySet()) {
            g2d.drawString("%d. %s".formatted(index, product.getName()), x, y);
            g2d.drawString(String.valueOf(product.getPrice()), x+300, y);
            g2d.drawString(String.valueOf(products.get(product)), x+375, y);
            y += 25;
            index++;
        }
        g2d.drawString("Order date: " + order.getDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)), x, y+50);
        g2d.drawString("Discount: 0", x, y+75);
        g2d.drawString("Total price: " + order.getTotalPrice(), x, y+100);
    }

    public void printReceipt() {
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        PageFormat pageFormat = printerJob.defaultPage();
        pageFormat.setOrientation(PageFormat.PORTRAIT);

        printerJob.setPrintable(this, pageFormat);

        if (printerJob.printDialog()) {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
                ex.printStackTrace();
            }
        }
    }
}
