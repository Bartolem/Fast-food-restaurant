package org.fast_food.user_interface.order_page;

import org.fast_food.menu.Menu;
import org.fast_food.order.Order;

import javax.swing.*;
import java.awt.*;

public class MenuPanel extends JPanel {
    private final JPanel panel;
    private final OrderListPanel orderListPanel;
    private final Order order;

    public MenuPanel(CardLayout cardLayout, OrderListPanel orderListPanel, Order order) {
         this.panel = new JPanel(cardLayout);
         this.orderListPanel = orderListPanel;
         this.order = order;
         setUp();
    }

    private void setUp() {
        JScrollPane classicBurgerPanel = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getClassicBurgerList(), Menu.getClassicBurgerImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane gourmetBurgerPanel = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getGourmetBurgerList(), Menu.getGourmetBurgerImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane spicyBurgerPanel = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getSpicyBurgerList(), Menu.getSpicyBurgerImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane uniqueBurgerPanel = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getUniqueFlavorBurgerList(), Menu.getUniqueFlavorBurgerImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane frenchFries = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getFrenchFriesList(), Menu.getFrenchFriesImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane coldDrinks = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getColdDrinkList(), Menu.getColdDrinksImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane hotDrinks = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getHotDrinkList(), Menu.getHotDrinksImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane comboMeals = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getComboMealsList(), Menu.getComboMealsImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane sideDishes = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getSideDishList(), Menu.getSideDishesImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane desserts = new JScrollPane(new ProductPanel(orderListPanel, order, Menu.getDessertList(), Menu.getDessertsImages()).getPanel(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

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
    }

    public JPanel getPanel() {
        return panel;
    }
}
