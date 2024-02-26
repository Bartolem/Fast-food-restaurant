package org.fast_food.user_interface;

import org.fast_food.bill_receipt.BillReceiptGenerator;
import org.fast_food.bill_receipt.BillReceiptWriter;
import org.fast_food.order.Order;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;

public class CompletedOrderPage {
    private JFrame frame;
    private final Order order;

    public CompletedOrderPage(Order order) {
        this.order = order;
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(OrderPage.PRIMARY_BACKGROUND_COLOR);
        frame.add(createTextAreaPanel(), BorderLayout.CENTER);
        frame.add(createButtonsPanel(), BorderLayout.SOUTH);
//        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }

    private JPanel createTextAreaPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setText(new BillReceiptGenerator(order).generateBillReceiptContent());
        textArea.setEditable(false);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(textArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.setPreferredSize(new Dimension(450, 200));
        return panel;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 0));
        JButton txtButton = UserInterface.createButton("Text file", 14);
        JButton pdfButton = UserInterface.createButton("Pdf", 14);
        JButton csvButton = UserInterface.createButton("CSV", 14);
        JButton jsonButton = UserInterface.createButton("Json", 14);
        panel.add(txtButton);
        panel.add(pdfButton);
        panel.add(csvButton);
        panel.add(jsonButton);
        txtButton.addActionListener(e -> createFileChooser(BillReceiptWriter.TXT));
        pdfButton.addActionListener(e -> createFileChooser(BillReceiptWriter.PDF));
        csvButton.addActionListener(e -> createFileChooser(BillReceiptWriter.CSV));
        return panel;
    }

    private void createFileChooser(String extension) {
        BillReceiptWriter billReceiptWriter = new BillReceiptWriter(order);
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getPath();

            switch (extension) {
                case BillReceiptWriter.TXT ->  billReceiptWriter.writeBillReceiptToTextFile(filePath);
                case BillReceiptWriter.CSV -> {
                    fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("*.csv", "CSV"));
                    billReceiptWriter.writeBillReceiptToCSVFile(filePath);
                }
                case BillReceiptWriter.PDF -> billReceiptWriter.writeBillReceiptToPDFFile(filePath);
            }
        }
    }
}
