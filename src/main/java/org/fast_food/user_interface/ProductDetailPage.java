package org.fast_food.user_interface;

import org.fast_food.product.Product;
import org.fast_food.product.Type;
import org.fast_food.product.burger.Burger;
import org.fast_food.product.burger.ingredient.IngredientI;
import org.fast_food.user_interface.order_page.OrderPage;

import javax.swing.*;
import java.awt.*;
import java.util.stream.Collectors;

import static org.fast_food.user_interface.UserInterface.*;

public class ProductDetailPage {
    private JFrame frame;
    private final String image;
    private final Product product;

    public ProductDetailPage(Product product, String image) {
        this.product = product;
        this.image = image;
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setTitle(product.getName());
        frame.getContentPane().setBackground(OrderPage.PRIMARY_BACKGROUND_COLOR);
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLocationByPlatform(true);
        frame.add(createImageLabel(image, 400, 350), BorderLayout.CENTER);
        frame.add(createProductDetailsPane(), BorderLayout.EAST);
        frame.pack();
    }

    public void show() {
        frame.setVisible(true);
    }

    private JScrollPane createProductDetailsPane() {
        JTextPane textPane = new JTextPane();
        textPane.setText("%s\n\nCalories: %s\n".formatted(product.getDescription(), product.getCalories()));
        textPane.setEditable(false);
        textPane.setFocusable(false);
        textPane.setBackground(OrderPage.SECONDARY_BACKGROUND_COLOR);
        textPane.setFont(new Font("Verdana", Font.PLAIN, 16));
        JScrollPane pane = new JScrollPane(textPane, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        if (product.getType().equals(Type.BURGER)) {
            Burger<IngredientI> burger = (Burger) product;
            String ingredients = burger.getIngredients().stream()
                    .map(e -> "- " + e.getName() + "\n").collect(Collectors.joining());
            textPane.setText("%s\n\nIngredients:\n%s\n\nCalories:\t %s\n\nSpiciness level:\t %s\n\nPopularity rating:\t %s".formatted(
                    product.getDescription(),
                    ingredients,
                    burger.getCalories(),
                    burger.getSpicinessLevel(),
                    burger.getPopularityRating()));
        }

        pane.setFont(new Font("Verdana", Font.PLAIN, 16));
        pane.setPreferredSize(new Dimension(300, 300));
        return pane;
    }
}
