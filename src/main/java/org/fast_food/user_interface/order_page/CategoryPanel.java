package org.fast_food.user_interface.order_page;

import javax.swing.*;
import java.awt.*;

import static org.fast_food.user_interface.UserInterface.createButton;

public class CategoryPanel extends JPanel {
    private final JPanel panel;
    private final CardLayout cardLayout;
    private final MenuPanel menuPanel;

    public CategoryPanel(CardLayout cardLayout, MenuPanel menuPanel) {
         this.panel = new JPanel(new GridLayout(0, 1));
         this.cardLayout = cardLayout;
         this.menuPanel = menuPanel;
         setUp();
    }

    private void setUp() {
        panel.setBackground(OrderPage.PRIMARY_BACKGROUND_COLOR);
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

        classicBurgerButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "classicBurgerPanel"));
        gourmetBurgerButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "gourmetBurgerPanel"));
        spicyBurgersButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "spicyBurgerPanel"));
        uniqueBurgerButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "uniqueBurgerPanel"));
        frenchFriesButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "frenchFries"));
        coldDrinksButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "coldDrinks"));
        hotDrinksButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "hotDrinks"));
        comboMealsButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "comboMeals"));
        sideDishesButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "sideDishes"));
        dessertsButton.addActionListener(e -> cardLayout.show(menuPanel.getPanel(), "desserts"));
    }

    public JPanel getPanel() {
        return panel;
    }
}
