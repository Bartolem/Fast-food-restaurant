package org.fast_food.user_interface;

import org.fast_food.product.Product;

import java.awt.*;
import java.awt.print.*;
import java.util.Map;

public class BillReceiptPrinter implements Printable {
    private final Map<Product, Integer> products;
    public BillReceiptPrinter(Map<Product, Integer> products) {
        this.products = products;
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
        // Example: Drawing bill receipt content
        g2d.setFont(new Font("Verdana", Font.PLAIN, 12));
        // x and y coordinates where each string will be drawn on the page
        int x = 0;
        int y = 50;
        int index = 1;
        // Draw header
        g2d.drawString("Product name", x, y-25);
        g2d.drawString("Price", x+350, y-25);
        g2d.drawString("Quantity", x+400, y-25);
        for (Product product : products.keySet()) {
            g2d.drawString("%d. %s".formatted(index, product.getName()), x, y);
            g2d.drawString(String.valueOf(product.getPrice() * products.get(product)), x+350, y);
            g2d.drawString(String.valueOf(products.get(product)), x+400, y);
            y += 25;
            index++;
        }
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
