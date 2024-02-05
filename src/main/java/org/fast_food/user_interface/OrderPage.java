package org.fast_food.user_interface;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import net.miginfocom.swing.MigLayout;
import org.fast_food.order.Order;
import org.fast_food.product.Product;
import org.fast_food.menu.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

import static org.fast_food.user_interface.UserInterface.*;

public class OrderPage {
    private JFrame frame;
    private DefaultTableModel defaultTableModel;
    private Order order;
    private List<JButton> addButtonsList;
    private List<JButton> removeButtonsList;
    private JLabel totalOrderPrice;

    public OrderPage() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.order = new Order();
        this.addButtonsList = new ArrayList<>();
        this.removeButtonsList = new ArrayList<>();

        frame.setLayout(new BorderLayout());
        frame.setSize(1150, 650);
        frame.setTitle(TITLE);
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel menuPanel = createMenuPanel(Menu.getClassicBurgerList(), Menu.getClassicBurgerImages());
        JPanel orderListPanel = createOrderListPanel();
        JScrollPane jScrollPane = new JScrollPane(menuPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.add(orderListPanel, BorderLayout.EAST);
        frame.setLocationByPlatform(true);
    }

    private JPanel createMenuPanel(List<Product> productList, List<File> productImages) {
        final int columns = 2;
        final int rows = productList.size();
        int index = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 89, 60));
        // Set border for item containers
        gridBagConstraints.insets = new Insets(10,10,10,10);

        for (int i = 0; i < rows / columns; i++) {
            for (int j = 0; j < columns; j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                panel.add(createItemContainer(productList.get(index), productImages.get(index)), gridBagConstraints);
                index++;

                // Adds last element if the number of rows is odd
                if (index == productList.size() - 1) {
                    if (rows % columns != 0) {
                        gridBagConstraints.gridx = 0;
                        gridBagConstraints.gridy = index;
                    }
                    panel.add(createItemContainer(productList.get(index), productImages.get(index)), gridBagConstraints);
                }
            }
        }
        return panel;
    }

    private JPanel createOrderListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] column = {"Name","Price","Quantity"};
        this.defaultTableModel = new DefaultTableModel(column, 0);
        this.totalOrderPrice = new JLabel("Total cost: $" + order.getTotalPrice());
        JTable table = new JTable(defaultTableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(220);
        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        panel.setPreferredSize(new Dimension(350, 350));
        panel.add(scrollPane, BorderLayout.NORTH);
        panel.add(totalOrderPrice);
        return panel;
    }

    private void addItemToTable(Product product, int quantity, int buttonIndex) {
        Vector<Object> vector = new Vector<>();
        vector.add(product.getName());
        vector.add(product.getPrice());
        vector.add(quantity);

        // Increase quantity value in the row without adding new one
        if (order.getContent().contains(product)) {
            // Enable remove button because order list contains at least one item of this type
            enableRemoveButton(removeButtonsList.get(buttonIndex));

            int productIndex = order.getContent().stream().toList().indexOf(product);
            Integer currentProductQuantity = (Integer) defaultTableModel.getValueAt(productIndex, 2);

            if (currentProductQuantity + quantity < order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE) {
                order.addProduct(product, quantity);
                totalOrderPrice.setText(String.valueOf(order.getTotalPrice()));
                defaultTableModel.setValueAt(currentProductQuantity + quantity, productIndex, 2);
            } else {
                // Disable button when product reach max quantity allowed
                disableButton(addButtonsList.get(buttonIndex));
                defaultTableModel.setValueAt(order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE, productIndex, 2);
            }
        } else {
            defaultTableModel.addRow(vector);
            order.addProduct(product, quantity);
            totalOrderPrice.setText(String.valueOf(order.getTotalPrice()));
            // Enable remove button because order list contains at least one item of this type
            enableRemoveButton(removeButtonsList.get(buttonIndex));
        }
    }

    private void enableRemoveButton(JButton button) {
        button.setEnabled(true);
        button.setBackground(new Color(250, 64, 64));
    }

    private void enableAddButton(JButton button) {
        button.setEnabled(true);
        button.setBackground(new Color(54, 208, 54));
    }

    private void disableButton(JButton button) {
        button.setEnabled(false);
        button.setBackground(Color.LIGHT_GRAY);
    }

    private void removeItemFromTable(Product product, int quantity, int buttonIndex) {
        if (order.getContent().contains(product)) {
            int productIndex = order.getContent().stream().toList().indexOf(product);
            Integer currentProductQuantity = (Integer) defaultTableModel.getValueAt(productIndex, 2);

            if (currentProductQuantity > 1 && currentProductQuantity - quantity > 0) {
                order.removeProduct(product, quantity);
                totalOrderPrice.setText(String.valueOf(order.getTotalPrice()));
                enableAddButton(addButtonsList.get(buttonIndex));
                defaultTableModel.setValueAt(currentProductQuantity - quantity, productIndex, 2);
            } else {
                defaultTableModel.removeRow(productIndex);
                order.removeProduct(product);
                totalOrderPrice.setText(String.valueOf(order.getTotalPrice()));
                disableButton(removeButtonsList.get(buttonIndex));
                enableAddButton(addButtonsList.get(buttonIndex));
            }
        }
    }

    private JPanel createItemContainer(Product product, File image) {
        JPanel panel = new JPanel(new MigLayout());
        JLabel burgerName = createLabel(product.getName(), "Verdana", Font.PLAIN, 18);
        JLabel burgerCost = createLabel("$" + product.getPrice(), "Verdana", Font.PLAIN, 20);
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor();
        JFormattedTextField textField = editor.getTextField();

        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setBackground(new Color(121, 186, 253));

        spinner.setFont(new Font("Verdana", Font.PLAIN, 22));

        IconFontSwing.register(FontAwesome.getIconFont());

        JButton addProductButton = new JButton(IconFontSwing.buildIcon(FontAwesome.PLUS, 22));
        addProductButton.setBackground(new Color(54, 208, 54));
        addProductButton.setFocusable(false);

        addButtonsList.add(addProductButton);

        addProductButton.addActionListener(e -> {
            int buttonIndex = addButtonsList.indexOf(addProductButton);
            addItemToTable(product, (Integer) spinner.getValue(), buttonIndex);
        });

        JButton removeProductButton = new JButton(IconFontSwing.buildIcon(FontAwesome.MINUS, 22));
        disableButton(removeProductButton);
        removeProductButton.setFocusable(false);

        removeButtonsList.add(removeProductButton);

        removeProductButton.addActionListener(e -> {
            int buttonIndex = removeButtonsList.indexOf(removeProductButton);
            removeItemFromTable(product, (Integer) spinner.getValue(), buttonIndex);
        });

        burgerName.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(burgerName, "span, wrap, growx");
        panel.add(createImageLabel(image.getPath(), 250, 200), "wrap");
        panel.add(spinner, "split4");
        panel.add(addProductButton);
        panel.add(removeProductButton);
        panel.add(burgerCost);
        panel.setSize(200, 200);
        panel.setBackground(new Color(255, 194, 150));
        return panel;
    }

    public void show() {
        frame.setVisible(true);
    }
}
