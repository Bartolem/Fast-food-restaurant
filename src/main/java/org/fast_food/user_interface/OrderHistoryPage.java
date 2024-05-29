package org.fast_food.user_interface;

import org.fast_food.customer.Customer;
import org.fast_food.database_connection.OrderDAOImpl;
import org.fast_food.order.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Vector;
import java.util.List;

public class OrderHistoryPage {
    private JFrame frame;
    private final Customer customer;

    public OrderHistoryPage(Customer customer) throws SQLException {
        this.customer = customer;
        initialize();
    }

    private void initialize() throws SQLException {
        this.frame = new JFrame();
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new BorderLayout());
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

        table.getSelectionModel().addListSelectionListener(event -> System.out.println(orders.get(table.getSelectedRow())));

        JButton showContentButton = UserInterface.createButton("Show content", 14);

        frame.setBackground(Color.LIGHT_GRAY);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setResizable(false);
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel();
        String[] column = {"Name","Price","Quantity"};

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
        table.getColumnModel().getColumn(0).setPreferredWidth(350);
        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1000, 400));
        panel.add(scrollPane);

        return panel;
    }

    public void show() {
        frame.setVisible(true);
    }
}
