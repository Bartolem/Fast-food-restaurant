package org.fast_food.user_interface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderHistoryPage {
    private JFrame frame;

    public OrderHistoryPage() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new BorderLayout());
        String[] column = {"Order date", "Total price", "Discount", "Total price after discount", "List of products"};
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
        table.getColumnModel().getColumn(0).setPreferredWidth(225);

        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(1000, 800));
//        frame.setPreferredSize(new Dimension(400, 350));
        frame.setBackground(Color.LIGHT_GRAY);

        frame.add(scrollPane, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}
