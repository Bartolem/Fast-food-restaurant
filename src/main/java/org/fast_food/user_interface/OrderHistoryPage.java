package org.fast_food.user_interface;

import org.fast_food.customer.Customer;
import org.fast_food.database_connection.OrderDAOImpl;
import org.fast_food.order.Order;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        table.setRowHeight(25);

        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1000, 800));

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

        frame.setBackground(Color.LIGHT_GRAY);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
    }

    public void show() {
        frame.setVisible(true);
    }
}
