package org.fast_food.user_interface.order_page;

import org.fast_food.customer.Customer;
import org.fast_food.order.Order;
import org.fast_food.order.OrderManagement;
import org.fast_food.user_interface.UserInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static org.fast_food.user_interface.UserInterface.ICON;
import static org.fast_food.user_interface.UserInterface.TITLE;

public class OrderPage {
    public static final Color PRIMARY_BACKGROUND_COLOR = new Color(255, 89, 60);
    public static final Color SECONDARY_BACKGROUND_COLOR = new Color(255, 194, 150);
    public static final DefaultTableModel DEFAULT_TABLE_MODEL = new DefaultTableModel(new String[]{"Name", "Price", "Quantity"}, 0) {
        //This causes all cells to be not editable
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    private JFrame frame;
    private final Customer customer;


    public OrderPage(Customer customer) {
        this.customer = customer;
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        Order order = new Order(customer);
        CardLayout cardLayout = new CardLayout();
        OrderListPanel orderListPanel = new OrderListPanel(order, customer, this);
        MenuPanel menuPanel = new MenuPanel(cardLayout, orderListPanel, order);
        CategoryPanel categoryPanel = new CategoryPanel(cardLayout, menuPanel);

        OrderManagement.addOrder(order);

        frame.setLayout(new BorderLayout());
        frame.setSize(1250, 650);
        frame.setTitle(TITLE);
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(categoryPanel.getPanel(), BorderLayout.WEST);
        frame.add(menuPanel.getPanel(), BorderLayout.CENTER);
        frame.add(orderListPanel.getPanel(), BorderLayout.EAST);
        frame.setLocationByPlatform(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int confirmed = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to exit the program?",
                        "Exit Program Message Box",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                } else {
                    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

     public static void enableRemoveButton(JButton button) {
        button.setEnabled(true);
        button.setBackground(new Color(250, 64, 64));
    }

    public static void enableAddButton(JButton button) {
        button.setEnabled(true);
        button.setBackground(new Color(54, 208, 54));
    }

    public static void enableButton(JButton button) {
        button.setEnabled(true);
        button.setBackground(UserInterface.BUTTON_COLOR);
    }

    public static void disableButton(JButton button) {
        button.setEnabled(false);
        button.setBackground(Color.LIGHT_GRAY);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }

    public void dispose() {
        frame.dispose();
    }
}
