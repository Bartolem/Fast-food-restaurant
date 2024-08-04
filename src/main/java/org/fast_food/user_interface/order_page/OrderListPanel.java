package org.fast_food.user_interface.order_page;

import net.miginfocom.swing.MigLayout;
import org.fast_food.customer.Customer;
import org.fast_food.database_connection.CustomerDAOImpl;
import org.fast_food.order.Order;
import org.fast_food.order.OrderManagement;
import org.fast_food.points_manager.PointsManager;
import org.fast_food.user_interface.CustomerPanel;
import org.fast_food.user_interface.LoginPage;
import org.fast_food.user_interface.ProcessingOrderPage;
import org.fast_food.user_interface.RegistrationForm;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.fast_food.user_interface.UserInterface.createButton;
import static org.fast_food.user_interface.UserInterface.createLabel;

public class OrderListPanel extends JPanel {
    private final LoginPage loginPage;
    private final Order order;
    private final Customer customer;
    private final OrderPage orderPage;
    private final JPanel panel;
    private final JButton cancelOrderButton;
    private final JButton makeOrderButton;
    private final JLabel totalOrderPrice;
    private final JLabel totalCost;
    private final JLabel totalOrderPriceAfterDiscount;

    public OrderListPanel(Order order, Customer customer, OrderPage orderPage) {
        this.loginPage = new LoginPage();
        this.order = order;
        this.customer = customer;
        this.orderPage = orderPage;
        this.panel = new JPanel(new MigLayout());
        this.cancelOrderButton = createButton("Cancel", 16);
        this.makeOrderButton = createButton("Pay", 16);
        this.totalOrderPrice = createLabel(order.getFormattedTotalPrice(), "Verdana", Font.PLAIN, 20);
        this.totalCost = createLabel("Total cost: ", "Verdana", Font.PLAIN, 20);
        this.totalOrderPriceAfterDiscount = createLabel(order.getFormattedTotalPrice(), "Verdana", Font.PLAIN, 20);
        setUp();
    }

    private JTable createTable() {
        JTable table = new JTable(OrderPage.getTableModel());
        table.setRowSorter(new TableRowSorter<>(OrderPage.getTableModel()));
        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getColumnModel().getColumn(0).setPreferredWidth(225);
        table.setFocusable(false);
        return table;
    }

    private void setUp() {
        totalOrderPriceAfterDiscount.setVisible(false);
        AtomicBoolean isDiscounted = new AtomicBoolean(false);
        Font font = totalOrderPriceAfterDiscount.getFont();
        JScrollPane scrollPane = new JScrollPane(createTable(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 300));

        panel.setPreferredSize(new Dimension(400, 350));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(scrollPane, "wrap, growx, pushx");
        panel.add(totalCost, "split3");
        panel.add(totalOrderPrice);
        panel.add(totalOrderPriceAfterDiscount, "wrap");
        panel.add(makeOrderButton, "split2, pushx, growx");
        panel.add(cancelOrderButton, "pushx, growx, wrap");

        OrderPage.disableButton(cancelOrderButton);
        OrderPage.disableButton(makeOrderButton);

        cancelOrderButton.addActionListener(e -> {
            cancelOrder();
            totalOrderPriceAfterDiscount.setVisible(false);
            totalOrderPriceAfterDiscount.setText(order.getFormattedTotalPrice());
            totalOrderPrice.setFont(font);
        });

        makeOrderButton.addActionListener(e -> {
            if (customer != null) {
                try {
                    if (isDiscounted.get()) {
                        order.setDiscount(PointsManager.calculateDiscount(customer, order.getTotalPrice()));
                        order.setTotalPriceAfterDiscount(PointsManager.applyDiscount(customer, order.getTotalPrice(), order.getDiscount()));
                    } else {
                        order.setTotalPriceAfterDiscount(order.getTotalPrice());
                    }

                    PointsManager.awardPointsToCustomer(customer, order.getTotalPrice().subtract(order.getDiscount()));
                    new CustomerDAOImpl().update(customer);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            processOrder();
            orderPage.dispose();
        });

        if (customer != null) {
            JButton manageButton = createButton("Manage Account", 16);
            JButton discountButton = createButton("Check for discount", 16);
            JButton logoutButton = createButton("Logout", 16);

            manageButton.addActionListener(e -> {
                try {
                    new CustomerPanel(customer).show();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });

            discountButton.addActionListener(e -> {
                if (order.getContent().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "There is nothing to calculate! You need at least one product in cart to apply discount.", "Empty cart", JOptionPane.WARNING_MESSAGE);
                } else {
                    isDiscounted.set(true);
                    Map attributes = font.getAttributes();
                    attributes.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);
                    totalOrderPrice.setFont(new Font(attributes));

                    totalOrderPriceAfterDiscount.setText(NumberFormat.getCurrencyInstance(Locale.US).format(order.getTotalPrice().subtract(PointsManager.calculateDiscount(customer, order.getTotalPrice()))));
                    totalOrderPriceAfterDiscount.setForeground(new Color(0, 138, 0));
                    totalOrderPriceAfterDiscount.setVisible(true);
                }
            });

            logoutButton.addActionListener(e -> {
                int confirmed = JOptionPane.showConfirmDialog(this,
                        "Are you sure you want to logout from your account?",
                        "Logout Message Box",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    orderPage.close();
                    loginPage.show();
                }
            });

            panel.add(createLabel("Account: %s %s".formatted(customer.getFirstName(), customer.getLastName()), "Verdana", Font.PLAIN, 20), "wrap");
            panel.add(manageButton, "pushx, growx, wrap");
            panel.add(discountButton, "pushx, growx, wrap");
            panel.add(logoutButton, "pushx, growx");
        } else {
            JTextArea textArea = createTextArea();
            JButton createAccountButton = createButton("Create an account", 16);

            createAccountButton.addActionListener(e -> {
                orderPage.close();
                loginPage.show();
                new RegistrationForm().show();
            });

            panel.add(textArea, "pushx, growx, wrap");
            panel.add(createAccountButton, "pushx, growx");
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    private JTextArea createTextArea() {
        JTextArea textArea = new JTextArea(5, 25);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setFocusable(false);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 16));
        textArea.setForeground(Color.BLACK);
        textArea.setText("Up to $100 discount for all types of orders! Available only for customers with an active account. Create an account and start collecting points now!");
        return textArea;
    }

    private void cancelOrder() {
        OrderManagement.cancelOrder(order);
        OrderManagement.removeOrder(order);

        totalOrderPrice.setText(order.getFormattedTotalPrice());
        OrderPage.getTableModel().setRowCount(0);

        OrderPage.disableButton(makeOrderButton);
        OrderPage.disableButton(cancelOrderButton);

        ItemContainer.enableAddButtonsList();
        ItemContainer.enableRemoveButtonsList();
    }

    private void processOrder() {
        if (!order.getProducts().isEmpty()) {
            OrderManagement.processOrder(order);
            new ProcessingOrderPage(order).show();
        }
    }

    public void changeTotalOrderPrice(String price) {
        totalOrderPrice.setText(price);
    }

    public void enableButtons() {
        OrderPage.enableButton(makeOrderButton);
        OrderPage.enableButton(cancelOrderButton);
    }

    public void disableButtons() {
        OrderPage.disableButton(cancelOrderButton);
        OrderPage.disableButton(makeOrderButton);
    }
}
