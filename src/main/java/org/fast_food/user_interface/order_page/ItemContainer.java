package org.fast_food.user_interface.order_page;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import net.miginfocom.swing.MigLayout;
import org.fast_food.order.Order;
import org.fast_food.product.Product;
import org.fast_food.product.Type;
import org.fast_food.user_interface.ProductDetailPage;
import org.fast_food.user_interface.UserInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Vector;

public class ItemContainer extends JPanel {
    private final Order order;
    private final Product product;
    private final String imagePath;
    private final DefaultTableModel defaultTableModel;
    private final OrderListPanel orderListPanel;
    private final JPanel panel;
    private static final List<JButton> addButtonsList = new ArrayList<>();;
    private static final List<JButton> removeButtonsList = new ArrayList<>();;
    private final JLabel productName;
    private final JLabel productCost;
    private final JSpinner spinner;

    public ItemContainer(Order order, Product product, String imagePath, DefaultTableModel defaultTableModel, OrderListPanel orderListPanel) {
        this.order = order;
        this.product = product;
        this.imagePath = imagePath;
        this.defaultTableModel = defaultTableModel;
        this.orderListPanel = orderListPanel;
        this.panel = new JPanel(new MigLayout());
        this.productName = UserInterface.createLabel(product.getName(), "Verdana", Font.PLAIN, 18);
        this.productCost = UserInterface.createLabel(NumberFormat.getCurrencyInstance(Locale.US).format(product.getPrice()), "Verdana", Font.PLAIN, 20);
        this.spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        setUp();
    }

    private void setUp() {
        productCost.setHorizontalAlignment(SwingConstants.CENTER);
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor();
        JFormattedTextField textField = editor.getTextField();

        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setBackground(new Color(121, 186, 253));

        spinner.setFont(new Font("Verdana", Font.PLAIN, 16));

        IconFontSwing.register(FontAwesome.getIconFont());

        JButton infoButton = UserInterface.createButton("", 14);
        infoButton.setIcon(IconFontSwing.buildIcon(FontAwesome.INFO_CIRCLE, 16));

        infoButton.addActionListener(e -> {
            new ProductDetailPage(product, imagePath).show();
        });

        JButton addProductButton = new JButton(IconFontSwing.buildIcon(FontAwesome.PLUS, 16));
        addProductButton.setBackground(new Color(54, 208, 54));
        addProductButton.setFocusable(false);

        addButtonsList.add(addProductButton);

        addProductButton.addActionListener(e -> {
            int buttonIndex = addButtonsList.indexOf(addProductButton);
            addItemToTable(product, (Integer) spinner.getValue(), buttonIndex);
        });

        JButton removeProductButton = new JButton(IconFontSwing.buildIcon(FontAwesome.MINUS, 16));
        OrderPage.disableButton(removeProductButton);
        removeProductButton.setFocusable(false);

        removeButtonsList.add(removeProductButton);

        removeProductButton.addActionListener(e -> {
            int buttonIndex = removeButtonsList.indexOf(removeProductButton);
            removeItemFromTable(product, (Integer) spinner.getValue(), buttonIndex);
        });

        productName.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setPreferredSize(new Dimension(280, 320));
        panel.setBackground(OrderPage.SECONDARY_BACKGROUND_COLOR);
        panel.add(productName, "span, growx, wrap");
        panel.add(infoButton, "align right, wrap");

        int imageWidth = 200;
        int imageHeight = 200;
        if (product.getType().equals(Type.BURGER)) {
            imageWidth = 250;
        }

        panel.add(UserInterface.createImageLabel(imagePath, imageWidth, imageHeight), "wrap, pushx, growx");
        panel.add(spinner, "split4");
        panel.add(addProductButton);
        panel.add(removeProductButton);
        panel.add(productCost, "span, growx");
    }

    public JPanel getPanel() {
        return panel;
    }

    private void addItemToTable(Product product, int quantity, int buttonIndex) {
        Vector<Object> vector = new Vector<>();
        vector.add(product.getName());
        vector.add(product.getPrice());
        vector.add(quantity);

        // Increase quantity value in the row without adding new one
        if (order.getProducts().contains(product)) {
            // Enable remove button because order list contains at least one item of this type
            OrderPage.enableRemoveButton(removeButtonsList.get(buttonIndex));

            int productIndex = getIndexOfValueFromTable(product);
            Integer currentProductQuantity = (Integer) defaultTableModel.getValueAt(productIndex, 2);

            if (currentProductQuantity + quantity < order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE) {
                order.addProduct(product, quantity);
                orderListPanel.changeTotalOrderPrice(order.getFormattedTotalPrice());
                defaultTableModel.setValueAt(currentProductQuantity + quantity, productIndex, 2);
            } else {
                order.addProduct(product, order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE - currentProductQuantity);
                orderListPanel.changeTotalOrderPrice(order.getFormattedTotalPrice());
                // Disable button when product reach max quantity allowed
                OrderPage.disableButton(addButtonsList.get(buttonIndex));
                defaultTableModel.setValueAt(order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE, productIndex, 2);
            }
        } else {
            if (quantity == order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE) {
                OrderPage.disableButton(addButtonsList.get(buttonIndex));
            }
            defaultTableModel.addRow(vector);
            order.addProduct(product, quantity);
            orderListPanel.changeTotalOrderPrice(order.getFormattedTotalPrice());
            // Enable remove button because order list contains at least one item of this type
            OrderPage.enableRemoveButton(removeButtonsList.get(buttonIndex));
            orderListPanel.enableButtons();
        }
    }

    private void removeItemFromTable(Product product, int quantity, int buttonIndex) {
        if (order.getProducts().contains(product)) {
            int productIndex = getIndexOfValueFromTable(product);
            Integer currentProductQuantity = (Integer) defaultTableModel.getValueAt(productIndex, 2);

            if (currentProductQuantity > 1 && currentProductQuantity - quantity > 0) {
                order.removeProduct(product, quantity);
                orderListPanel.changeTotalOrderPrice(order.getFormattedTotalPrice());
                OrderPage.enableAddButton(addButtonsList.get(buttonIndex));
                defaultTableModel.setValueAt(currentProductQuantity - quantity, productIndex, 2);
            } else {
                order.removeProduct(product, quantity);
                defaultTableModel.removeRow(productIndex);
                orderListPanel.changeTotalOrderPrice(order.getFormattedTotalPrice());
                OrderPage.disableButton(removeButtonsList.get(buttonIndex));
                OrderPage.enableAddButton(addButtonsList.get(buttonIndex));
                // If order list is empty it's not possible to make or cancel the order
                if (order.getProducts().isEmpty()) {
                    orderListPanel.disableButtons();
                }
            }
        }
    }

    private int getIndexOfValueFromTable(Product product) {
        int column = 0;

        for (int row = 0; row < defaultTableModel.getRowCount(); row++) {
            if (defaultTableModel.getValueAt(row, column).equals(product.getName())) {
                return row;
            }
        }
        return -1;
    }

    public static void enableAddButtonsList() {
        for (JButton button : addButtonsList) {
            if (!button.isEnabled()) {
                OrderPage.enableAddButton(button);
            }
        }
    }

    public static void enableRemoveButtonsList() {
        for (JButton button : removeButtonsList) {
            if (button.isEnabled()) {
                OrderPage.disableButton(button);
            }
        }
    }
}
