package org.fast_food.user_interface.order_page;

import org.fast_food.menu.NaturalOrderComparator;
import org.fast_food.order.Order;
import org.fast_food.product.Product;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Map;

public class ProductPanel extends JPanel {
    private final OrderListPanel orderListPanel;
    private final Order order;
    private final JPanel panel;
    private final List<Product> productList;
    private final List<String> productImagesList;

    public ProductPanel(OrderListPanel orderListPanel, Order order, List<Product> productList, Map<String, ImageIcon> productImages) {
        this.orderListPanel = orderListPanel;
        this.order = order;
        this.panel =  new JPanel(new GridBagLayout());
        this.productList = productList;
        this.productImagesList = productImages.keySet().stream().sorted(new NaturalOrderComparator()).toList();
        setUp();
    }

    private void setUp() {
        final int COLUMNS = 2;
        final int ROWS = productList.size();
        int index = 0;
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        panel.setBackground(OrderPage.PRIMARY_BACKGROUND_COLOR);
        // Set border for item containers
        gridBagConstraints.insets = new Insets(10,10,10,10);

        for (int i = 0; i < ROWS / COLUMNS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                gridBagConstraints.gridx = j;
                gridBagConstraints.gridy = i;
                panel.add(new ItemContainer(order, productList.get(index), productImagesList.stream().toList().get(index), OrderPage.getTableModel(), orderListPanel).getPanel(), gridBagConstraints);
                index++;

                // Adds last element if the number of rows is odd
                if (index == productList.size() - 1) {
                    if (ROWS % COLUMNS != 0) {
                        gridBagConstraints.gridx = 0;
                        gridBagConstraints.gridy = index;
                    }
                    panel.add(new ItemContainer(order, productList.get(index), productImagesList.stream().toList().get(index), OrderPage.getTableModel(), orderListPanel).getPanel(), gridBagConstraints);
                }
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
