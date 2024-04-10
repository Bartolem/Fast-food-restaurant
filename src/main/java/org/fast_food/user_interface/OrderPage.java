package org.fast_food.user_interface;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import net.miginfocom.swing.MigLayout;
import org.fast_food.customer.Customer;
import org.fast_food.database_connection.CustomerDAOImpl;
import org.fast_food.database_connection.OrderDAOImpl;
import org.fast_food.order.Order;
import org.fast_food.order.OrderManagement;
import org.fast_food.points_manager.PointsManager;
import org.fast_food.product.Product;
import org.fast_food.menu.Menu;
import org.fast_food.product.Type;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.font.TextAttribute;
import java.io.File;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.fast_food.user_interface.UserInterface.*;

public class OrderPage {
    public static Color PRIMARY_BACKGROUND_COLOR = new Color(255, 89, 60);
    public static Color SECONDARY_BACKGROUND_COLOR = new Color(255, 194, 150);
    private JFrame frame;
    private DefaultTableModel defaultTableModel;
    private Order order;
    private final Customer customer;
    private final LoginPage loginPage;
    private List<JButton> addButtonsList;
    private List<JButton> removeButtonsList;
    private JLabel totalOrderPrice;
    private CardLayout cardLayout;
    private JPanel menuPanel;
    private JButton cancelOrderButton;
    private JButton makeOrderButton;

    public OrderPage(Customer customer) {
        this.customer = customer;
        loginPage = new LoginPage();
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.order = new Order(customer);
        this.addButtonsList = new ArrayList<>();
        this.removeButtonsList = new ArrayList<>();
        this.cardLayout = new CardLayout();
        this.menuPanel = createMenuPanel();

        OrderManagement.addOrder(order);

        frame.setLayout(new BorderLayout());
        frame.setSize(1250, 650);
        frame.setTitle(TITLE);
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(createCategoryPanel(), BorderLayout.WEST);
        frame.add(menuPanel, BorderLayout.CENTER);
        frame.add(createOrderListPanel(), BorderLayout.EAST);
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
        panel.setBackground(PRIMARY_BACKGROUND_COLOR);
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
        panel.setBackground(PRIMARY_BACKGROUND_COLOR);
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
        JLabel totalCost = createLabel("Total cost: ", "Verdana", Font.PLAIN, 20);
        this.cancelOrderButton = createButton("Cancel", 16);
        this.makeOrderButton = createButton("Pay", 16);
        this.defaultTableModel = new DefaultTableModel(column, 0) {
            //This causes all cells to be not editable
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        this.totalOrderPrice = createLabel(order.getFormattedTotalPrice(), "Verdana", Font.PLAIN, 20);
        JLabel totalOrderPriceAfterDiscount = createLabel(order.getFormattedTotalPrice(), "Verdana", Font.PLAIN, 20);
        totalOrderPriceAfterDiscount.setVisible(false);
        AtomicBoolean isDiscounted = new AtomicBoolean(false);
        Font font = totalOrderPriceAfterDiscount.getFont();
        JTable table = new JTable(defaultTableModel);
        table.setFont(new Font("Verdana", Font.PLAIN, 14));
        table.setRowHeight(25);
        table.getColumnModel().getColumn(0).setPreferredWidth(225);
        table.setFocusable(false);
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new Dimension(400, 300));
        panel.setPreferredSize(new Dimension(400, 350));
        panel.setBackground(Color.LIGHT_GRAY);
        panel.add(scrollPane, "wrap, growx, pushx");
        panel.add(totalCost, "split3");
        panel.add(totalOrderPrice);
        panel.add(totalOrderPriceAfterDiscount, "wrap");
        panel.add(makeOrderButton, "split2, pushx, growx");
        panel.add(cancelOrderButton, "pushx, growx, wrap");

        disableButton(cancelOrderButton);
        disableButton(makeOrderButton);

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

            try {
                new OrderDAOImpl().insert(order);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            processOrder();
            frame.dispose();
        });

        if (customer != null) {
            JButton manageButton = createButton("Manage Account", 16);
            JButton discountButton = createButton("Check for discount", 16);
            JButton logoutButton = createButton("Logout", 16);

            manageButton.addActionListener(e -> new CustomerPanel(customer).show());

            discountButton.addActionListener(e -> {
                if (order.getContent().isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "There is nothing to calculate! You need at least one product in cart to apply discount.", "Empty cart", JOptionPane.WARNING_MESSAGE);
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
                int confirmed = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to logout from your account?",
                        "Logout Message Box",
                        JOptionPane.YES_NO_OPTION);

                if (confirmed == JOptionPane.YES_OPTION) {
                    close();
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
                close();
                loginPage.show();
                new RegistrationForm().show();
            });

            panel.add(textArea, "pushx, growx, wrap");
            panel.add(createAccountButton, "pushx, growx");
        }

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
        defaultTableModel.setRowCount(0);

        disableButton(makeOrderButton);
        disableButton(cancelOrderButton);

        for (JButton button : addButtonsList) {
            if (!button.isEnabled()) {
                enableAddButton(button);
            }
        }

        for (JButton button : removeButtonsList) {
            if (button.isEnabled()) {
                disableButton(button);
            }
        }
    }

    private void processOrder() {
        if (!order.getProducts().isEmpty()) {
            OrderManagement.processOrder(order);
            new ProcessingOrderPage(order).show();
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

    private void addItemToTable(Product product, int quantity, int buttonIndex) {
        Vector<Object> vector = new Vector<>();
        vector.add(product.getName());
        vector.add(product.getPrice());
        vector.add(quantity);

        // Increase quantity value in the row without adding new one
        if (order.getProducts().contains(product)) {
            // Enable remove button because order list contains at least one item of this type
            enableRemoveButton(removeButtonsList.get(buttonIndex));

            int productIndex = getIndexOfValueFromTable(product);
            Integer currentProductQuantity = (Integer) defaultTableModel.getValueAt(productIndex, 2);

            if (currentProductQuantity + quantity < order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE) {
                order.addProduct(product, quantity);
                totalOrderPrice.setText(order.getFormattedTotalPrice());
                defaultTableModel.setValueAt(currentProductQuantity + quantity, productIndex, 2);
            } else {
                order.addProduct(product, order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE - currentProductQuantity);
                totalOrderPrice.setText(order.getFormattedTotalPrice());
                // Disable button when product reach max quantity allowed
                disableButton(addButtonsList.get(buttonIndex));
                defaultTableModel.setValueAt(order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE, productIndex, 2);
            }
        } else {
            if (quantity == order.MAX_QUANTITY_OF_PRODUCT_SAME_TYPE) {
                disableButton(addButtonsList.get(buttonIndex));
            }
            defaultTableModel.addRow(vector);
            order.addProduct(product, quantity);
            totalOrderPrice.setText(order.getFormattedTotalPrice());
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
        button.setBackground(BUTTON_COLOR);
    }

    private void disableButton(JButton button) {
        button.setEnabled(false);
        button.setBackground(Color.LIGHT_GRAY);
    }

    private void removeItemFromTable(Product product, int quantity, int buttonIndex) {
        if (order.getProducts().contains(product)) {
            int productIndex = getIndexOfValueFromTable(product);
            Integer currentProductQuantity = (Integer) defaultTableModel.getValueAt(productIndex, 2);

            if (currentProductQuantity > 1 && currentProductQuantity - quantity > 0) {
                order.removeProduct(product, quantity);
                totalOrderPrice.setText(order.getFormattedTotalPrice());
                enableAddButton(addButtonsList.get(buttonIndex));
                defaultTableModel.setValueAt(currentProductQuantity - quantity, productIndex, 2);
            } else {
                order.removeProduct(product, quantity);
                defaultTableModel.removeRow(productIndex);
                totalOrderPrice.setText(order.getFormattedTotalPrice());
                disableButton(removeButtonsList.get(buttonIndex));
                enableAddButton(addButtonsList.get(buttonIndex));
                // If order list is empty it's not possible to make or cancel the order
                if (order.getProducts().isEmpty()) {
                    disableButton(cancelOrderButton);
                    disableButton(makeOrderButton);
                }
            }
        }
    }

    private JPanel createItemContainer(Product product, File image) {
        JPanel panel = new JPanel(new MigLayout());
        JLabel productName = createLabel(product.getName(), "Verdana", Font.PLAIN, 18);
        JLabel productCost = createLabel(NumberFormat.getCurrencyInstance(Locale.US).format(product.getPrice()), "Verdana", Font.PLAIN, 20);
        productCost.setHorizontalAlignment(SwingConstants.CENTER);
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        JSpinner.DefaultEditor editor = (JSpinner.DefaultEditor) spinner.getEditor();
        JFormattedTextField textField = editor.getTextField();

        textField.setEditable(false);
        textField.setFocusable(false);
        textField.setBackground(new Color(121, 186, 253));

        spinner.setFont(new Font("Verdana", Font.PLAIN, 16));

        IconFontSwing.register(FontAwesome.getIconFont());

        JButton infoButton = createButton("", 14);
        infoButton.setIcon(IconFontSwing.buildIcon(FontAwesome.INFO_CIRCLE, 16));

        infoButton.addActionListener(e -> {
            new ProductDetailPage(product, image).show();
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
        disableButton(removeProductButton);
        removeProductButton.setFocusable(false);

        removeButtonsList.add(removeProductButton);

        removeProductButton.addActionListener(e -> {
            int buttonIndex = removeButtonsList.indexOf(removeProductButton);
            removeItemFromTable(product, (Integer) spinner.getValue(), buttonIndex);
        });

        productName.setHorizontalAlignment(SwingConstants.CENTER);
        panel.setPreferredSize(new Dimension(280, 320));
        panel.setBackground(SECONDARY_BACKGROUND_COLOR);
        panel.add(productName, "span, growx, wrap");
        panel.add(infoButton, "align right, wrap");

        int imageWidth = 200;
        int imageHeight = 200;
        if (product.getType().equals(Type.BURGER)) {
            imageWidth = 250;
        }

        panel.add(createImageLabel(image.getPath(), imageWidth, imageHeight), "wrap, pushx, growx");
        panel.add(spinner, "split4");
        panel.add(addProductButton);
        panel.add(removeProductButton);
        panel.add(productCost, "span, growx");
        return panel;
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }
}
