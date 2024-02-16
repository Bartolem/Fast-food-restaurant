package org.fast_food.user_interface;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import net.miginfocom.swing.MigLayout;
import org.fast_food.order.Order;
import org.fast_food.order.OrderManagement;
import org.fast_food.product.Product;
import org.fast_food.menu.Menu;
import org.fast_food.product.Type;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
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
    private CardLayout cardLayout;
    private JPanel menuPanel;
    private JButton cancelOrderButton;
    private JButton makeOrderButton;

    public OrderPage() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.order = new Order();
        this.addButtonsList = new ArrayList<>();
        this.removeButtonsList = new ArrayList<>();
        this.cardLayout = new CardLayout();
        this.menuPanel = createMenuPanel();

        OrderManagement.addOrder(order);

        frame.setLayout(new BorderLayout());
        frame.setSize(1200, 650);
        frame.setTitle(TITLE);
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(createCategoryPanel(), BorderLayout.WEST);
        frame.add(menuPanel, BorderLayout.CENTER);
        frame.add(createOrderListPanel(), BorderLayout.EAST);
        frame.setLocationByPlatform(true);
    }

    private JPanel createMenuPanel() {
        JPanel panel = new JPanel(cardLayout);
        JScrollPane classicBurgerPanel = new JScrollPane(createItemsPanel(Menu.getClassicBurgerList(), Menu.getClassicBurgerImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane gourmetBurgerPanel = new JScrollPane(createItemsPanel(Menu.getGourmetBurgerList(), Menu.getGourmetBurgerImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane spicyBurgerPanel = new JScrollPane(createItemsPanel(Menu.getSpicyBurgerList(), Menu.getSpicyBurgerImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane uniqueBurgerPanel = new JScrollPane(createItemsPanel(Menu.getUniqueFlavorBurgerList(), Menu.getUniqueFlavorBurgerImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane frenchFries = new JScrollPane(createItemsPanel(Menu.getFrenchFriesList(), Menu.getFrenchFriesImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane coldDrinks = new JScrollPane(createItemsPanel(Menu.getColdDrinkList(), Menu.getColdDrinksImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane hotDrinks = new JScrollPane(createItemsPanel(Menu.getHotDrinkList(), Menu.getHotDrinksImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane comboMeals = new JScrollPane(createItemsPanel(Menu.getComboMealsList(), Menu.getComboMealsImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane sideDishes = new JScrollPane(createItemsPanel(Menu.getSideDishList(), Menu.getSideDishesImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane desserts = new JScrollPane(createItemsPanel(Menu.getDessertList(), Menu.getDessertsImages()), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(classicBurgerPanel, "classicBurgerPanel");
        panel.add(gourmetBurgerPanel, "gourmetBurgerPanel");
        panel.add(spicyBurgerPanel, "spicyBurgerPanel");
        panel.add(uniqueBurgerPanel, "uniqueBurgerPanel");
        panel.add(frenchFries, "frenchFries");
        panel.add(coldDrinks, "coldDrinks");
        panel.add(hotDrinks, "hotDrinks");
        panel.add(comboMeals, "comboMeals");
        panel.add(sideDishes, "sideDishes");
        panel.add(desserts, "desserts");
        return panel;
    }

    private JPanel createCategoryPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.setBackground(new Color(255, 89, 60));
        JButton classicBurgerButton = createButton("Classic Burgers", 12);
        JButton gourmetBurgerButton = createButton("Gourmet Burgers",12);
        JButton spicyBurgersButton = createButton("Spicy Burgers",12);
        JButton uniqueBurgerButton = createButton("Unique Flavour Burgers",12);
        JButton frenchFriesButton = createButton("French Fries",12);
        JButton coldDrinksButton = createButton("Cold Drinks",12);
        JButton hotDrinksButton = createButton("Hot drinks",12);
        JButton comboMealsButton = createButton("Combo Meals", 12);
        JButton sideDishesButton = createButton("Side Dishes",12);
        JButton dessertsButton = createButton("Desserts",12);

        panel.add(classicBurgerButton);
        panel.add(gourmetBurgerButton);
        panel.add(spicyBurgersButton);
        panel.add(uniqueBurgerButton);
        panel.add(frenchFriesButton);
        panel.add(coldDrinksButton);
        panel.add(hotDrinksButton);
        panel.add(comboMealsButton);
        panel.add(sideDishesButton);
        panel.add(dessertsButton);

        classicBurgerButton.addActionListener(e -> cardLayout.show(menuPanel, "classicBurgerPanel"));

        gourmetBurgerButton.addActionListener(e -> cardLayout.show(menuPanel, "gourmetBurgerPanel"));

        spicyBurgersButton.addActionListener(e -> cardLayout.show(menuPanel, "spicyBurgerPanel"));

        uniqueBurgerButton.addActionListener(e -> cardLayout.show(menuPanel, "uniqueBurgerPanel"));

        frenchFriesButton.addActionListener(e -> cardLayout.show(menuPanel, "frenchFries"));

        coldDrinksButton.addActionListener(e -> cardLayout.show(menuPanel, "coldDrinks"));

        hotDrinksButton.addActionListener(e -> cardLayout.show(menuPanel, "hotDrinks"));

        comboMealsButton.addActionListener(e -> cardLayout.show(menuPanel, "comboMeals"));

        sideDishesButton.addActionListener(e -> cardLayout.show(menuPanel, "sideDishes"));

        dessertsButton.addActionListener(e -> cardLayout.show(menuPanel, "desserts"));

        return panel;
    }

    private JPanel createItemsPanel(List<Product> productList, List<File> productImages) {
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
        JPanel panel = new JPanel(new MigLayout());
        String[] column = {"Name","Price","Quantity"};
        JLabel totalCost = createLabel("Total cost: $", "Verdana", Font.PLAIN, 20);
        this.cancelOrderButton = createButton("Cancel", 16);
        this.makeOrderButton = createButton("Pay", 16);
        this.defaultTableModel = new DefaultTableModel(column, 0) {
            //This causes all cells to be not editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.totalOrderPrice = createLabel(String.valueOf(order.getTotalPrice()), "Verdana", Font.PLAIN, 20);
        JTable table = new JTable(defaultTableModel);
        table.getColumnModel().getColumn(0).setPreferredWidth(220);
        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(350, 300));
        panel.setPreferredSize(new Dimension(350, 350));
        panel.add(scrollPane, "wrap, growx, pushx");
        panel.add(totalCost, "split2");
        panel.add(totalOrderPrice, "wrap");
        panel.add(makeOrderButton, "split2, pushx, growx");
        panel.add(cancelOrderButton, "pushx, growx");

        disableButton(cancelOrderButton);
        disableButton(makeOrderButton);

        cancelOrderButton.addActionListener(e -> cancelOrder());
        makeOrderButton.addActionListener(e -> processOrder());

        return panel;
    }

    private void cancelOrder() {
        OrderManagement.cancelOrder(order);
        OrderManagement.removeOrder(order);

        totalOrderPrice.setText(String.valueOf(order.getTotalPrice()));
        defaultTableModel.setRowCount(0);

        disableButton(makeOrderButton);
        disableButton(cancelOrderButton);

        for (JButton button : removeButtonsList) {
            if (button.isEnabled()) {
                disableButton(button);
            }
        }
    }

    private void processOrder() {
        if (!order.getContent().isEmpty()) {
            OrderManagement.processOrder(order);
            JOptionPane.showMessageDialog(frame,"Your order are processing. Please wait.");
        }
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
                order.addProduct(product, order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE - currentProductQuantity);
                totalOrderPrice.setText(String.valueOf(order.getTotalPrice()));
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
            enableButton(makeOrderButton);
            enableButton(cancelOrderButton);
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

    private void enableButton(JButton button) {
        button.setEnabled(true);
        button.setBackground(new Color(121, 186, 253));
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
                order.removeProduct(product, quantity);
                defaultTableModel.removeRow(productIndex);
                totalOrderPrice.setText(String.valueOf(order.getTotalPrice()));
                disableButton(removeButtonsList.get(buttonIndex));
                enableAddButton(addButtonsList.get(buttonIndex));
                // If order list is empty it's not possible to make or cancel the order
                if (order.getContent().isEmpty()) {
                    disableButton(cancelOrderButton);
                    disableButton(makeOrderButton);
                }
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
        panel.setPreferredSize(new Dimension(280, 300));
        panel.setBackground(new Color(255, 194, 150));
        panel.add(burgerName, "span, pushx, wrap, growx");

        int imageWidth = 200;
        int imageHeight = 200;
        if (product.getType().equals(Type.BURGER)) {
            imageWidth = 250;
        }

        panel.add(createImageLabel(image.getPath(), imageWidth, imageHeight), "wrap, pushx, growx");
        panel.add(spinner, "split4, pushx");
        panel.add(addProductButton);
        panel.add(removeProductButton);
        panel.add(burgerCost);
        return panel;
    }

    public void show() {
        frame.setVisible(true);
    }
}
