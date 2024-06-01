package org.fast_food.user_interface;

import org.fast_food.bill_receipt.BillReceiptWriter;
import org.fast_food.customer.Customer;
import org.fast_food.database_connection.OrderDAOImpl;
import org.fast_food.order.Order;
import org.fast_food.product.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;
import java.util.List;

import static org.fast_food.user_interface.UserInterface.BUTTON_COLOR;

public class OrderHistoryPage {
    private JFrame frame;
    private final Customer customer;
    private Order order;
    private DefaultTableModel bottomTableModel;
    private List<JButton> buttons;

    public OrderHistoryPage(Customer customer) throws SQLException {
        this.customer = customer;
        initialize();
    }

    private void initialize() throws SQLException {
        this.frame = new JFrame();
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        String[] column = {"Id", "Order date", "Total price", "Discount", "Total price after discount"};
        DefaultTableModel defaultTableModel = new DefaultTableModel(column, 0) {
            //This causes all cells to be not editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(defaultTableModel);
        table.setRowSorter(new TableRowSorter<>(defaultTableModel));
        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        table.setRowHeight(25);

        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1000, 400));


        JPanel bottomPanel = createBottomPanel();

        List<Order> orders = new OrderDAOImpl().getAll(customer.getId());

        // Add orders to table
        orders.forEach(order -> {
            Vector<Object> vector = new Vector<>();
            vector.add(order.getId());
            vector.add(order.getDate().format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)));
            vector.add(order.getFormattedTotalPrice());
            vector.add(order.getFormattedDiscount());
            vector.add(order.getFormattedTotalPriceAfterDiscount());

            defaultTableModel.addRow(vector);
        });

        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getSelectionModel().addListSelectionListener(event -> {
            if (table.getSelectedRow() > -1) {
                this.order = orders.get(table.getSelectedRow());
                addOrderToTable(order);
                enableButtons();
            }
        });

        frame.setBackground(Color.LIGHT_GRAY);
        frame.add(scrollPane);
        frame.add(bottomPanel);
        frame.add(createButtonsPanel());
        frame.pack();
        frame.setResizable(false);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                disableButtons();
            }
        });
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        String[] column = {"Name","Price","Quantity"};

        this.bottomTableModel = new DefaultTableModel(column, 0) {
            //This causes all cells to be not editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JTable table = new JTable(bottomTableModel);
        table.setRowSorter(new TableRowSorter<>(bottomTableModel));
        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getColumnModel().getColumn(0).setPreferredWidth(350);
        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1000, 400));
        panel.add(scrollPane);

        return panel;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 0));
        JButton txtButton = UserInterface.createButton("TXT", 14);
        JButton pdfButton = UserInterface.createButton("PDF", 14);
        JButton csvButton = UserInterface.createButton("CSV", 14);
        JButton jsonButton = UserInterface.createButton("JSON", 14);
        this.buttons = List.of(txtButton, csvButton, jsonButton, pdfButton);

        disableButtons();

        panel.add(txtButton);
        panel.add(pdfButton);
        panel.add(csvButton);
        panel.add(jsonButton);

        txtButton.addActionListener(e -> createFileChooser(BillReceiptWriter.TXT));
        pdfButton.addActionListener(e -> createFileChooser(BillReceiptWriter.PDF));
        csvButton.addActionListener(e -> createFileChooser(BillReceiptWriter.CSV));
        jsonButton.addActionListener(e -> createFileChooser(BillReceiptWriter.JSON));
        return panel;
    }

    private void disableButtons() {
        buttons.forEach(button -> {
            button.setEnabled(false);
            button.setBackground(Color.LIGHT_GRAY);
        });
    }

    private void enableButtons() {
        buttons.forEach(button -> {
            button.setEnabled(true);
            button.setBackground(BUTTON_COLOR);
        });;
    }

    private void createFileChooser(String extension) {
        BillReceiptWriter billReceiptWriter = new BillReceiptWriter(order);
        JFileChooser fileChooser= new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

        if (fileChooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getPath();

            switch (extension) {
                case BillReceiptWriter.TXT -> billReceiptWriter.writeBillReceiptToTextFile(filePath);
                case BillReceiptWriter.CSV -> billReceiptWriter.writeBillReceiptToCSVFile(filePath);
                case BillReceiptWriter.PDF -> billReceiptWriter.writeBillReceiptToPDFFile(filePath);
                case BillReceiptWriter.JSON -> billReceiptWriter.writeBillRecipeToJSONFile(filePath);

            }
        }
    }

    private void addOrderToTable(Order order) {
        Map<Product, Integer> products = order.getContent();

        if (bottomTableModel.getRowCount() > 0) {
            bottomTableModel.setRowCount(0);
        }

        products.forEach((key, value) -> {
            Vector<Object> vector = new Vector<>();
            vector.add(key.getName());
            vector.add(NumberFormat.getCurrencyInstance(Locale.US).format(key.getPrice()));
            vector.add(value);

            bottomTableModel.addRow(vector);
        });
    }

    public void show() {
        frame.setVisible(true);
    }
}
