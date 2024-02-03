package org.fast_food.user_interface;

import jiconfont.icons.font_awesome.FontAwesome;
import jiconfont.swing.IconFontSwing;
import net.miginfocom.swing.MigLayout;
import org.fast_food.order.Order;
import org.fast_food.product.Product;
import org.fast_food.product.burger.Burger;
import org.fast_food.menu.Menu;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.List;

import static org.fast_food.user_interface.UserInterface.*;

public class OrderPage {
    private JFrame frame;
    private DefaultTableModel defaultTableModel;
    private Order order;
    private List<JButton> buttonList;

    public OrderPage() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.order = new Order();
        this.buttonList = new ArrayList<>();

        frame.setLayout(new BorderLayout());
        frame.setSize(1150, 650);
        frame.setTitle(TITLE);
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        JPanel menuPanel = createMenuPanel();
        JPanel orderListPanel = createOrderListPanel();
        JScrollPane jScrollPane = new JScrollPane(menuPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.add(orderListPanel, BorderLayout.EAST);
        frame.setLocationByPlatform(true);
    }

    private JPanel createMenuPanel() {
        int rows = Menu.getClassicBurgerList().size();
        int columns = 3;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(255, 89, 60));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                // Set border for item containers
                gridBagConstraints.insets = new Insets(10,10,10,10);
                panel.add(createItemContainer(), gridBagConstraints);
            }
        }
        return panel;
    }

    private JPanel createOrderListPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        String[] column = {"Name","Price","Quantity"};
        this.defaultTableModel = new DefaultTableModel(column, 0);
        JTable table = new JTable(defaultTableModel);
        
        JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        panel.add(scrollPane, BorderLayout.NORTH);
        return panel;
    }

    private void addItemToTable(Product product, int quantity) {
        Vector<Object> vector = new Vector<>();
        vector.add(product.getName());
        vector.add(product.getPrice());
        vector.add(quantity);

        if (order.getContent().contains(product)) {
            defaultTableModel.setValueAt(((Integer) defaultTableModel.getValueAt(order.getContent().indexOf(product), 2) + quantity), order.getContent().indexOf(product), 2);
        } else {
            defaultTableModel.addRow(vector);
            order.addProduct(product);
        }
    }

    private JPanel createItemContainer() {
        JPanel panel = new JPanel(new MigLayout("debug"));
        JLabel burgerName = createLabel("Burger bla bla mniam", "Verdana", Font.PLAIN, 22);
        JLabel burgerCost = createLabel("$ 4.59", "Verdana", Font.PLAIN, 22);
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

        buttonList.add(addProductButton);

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Burger burger = Menu.getClassicBurgerList().get(buttonList.indexOf(addProductButton));
                addItemToTable(burger, (Integer) spinner.getValue());
            }
        });

        JButton removeProductButton = new JButton(IconFontSwing.buildIcon(FontAwesome.MINUS, 22));
        removeProductButton.setBackground(new Color(250, 64, 64));
        removeProductButton.setFocusable(false);

        burgerName.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(burgerName, "span, wrap, growx");
        panel.add(createImageLabel("src/main/resources/images/classic/bacon.png", 250, 200), "wrap");
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
