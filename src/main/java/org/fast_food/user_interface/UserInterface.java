package org.fast_food.user_interface;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.Objects;

public class UserInterface {
    public static String TITLE = "Bartolo's Burger";
    public static ImageIcon ICON = new ImageIcon(Objects.requireNonNull(UserInterface.class.getClassLoader().getResource("images/icon.png")));
    public static Color BUTTON_COLOR = new Color(121, 186, 253);

    public static JButton createButton(String text, int size) {
        JButton button = new JButton(text);
        button.setFont(new Font("Verdana",Font.PLAIN, size));
        button.setForeground(Color.BLACK);
        button.setBackground(BUTTON_COLOR);
        button.setFocusable(false);
        return button;
    }

    public static JTextField createTextField() {
        return new JTextField(20);
    }

    public static JLabel createLabel(String text, String fontName, int fontStyle, int fontSize) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        return label;
    }

    public static JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, Color color) {
        JLabel label = createLabel(text, fontName, fontStyle, fontSize);
        label.setForeground(color);
        return label;
    }

    public static JLabel createImageLabel(String path, int width, int height) {
        try {
            // Load the image using the class loader
            URL imgURL = UserInterface.class.getClassLoader().getResource(convertPath(path));
            if (imgURL != null) {
                ImageIcon icon = new ImageIcon(imgURL);
                Image img = icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                return new JLabel(new ImageIcon(img));
            } else {
                System.err.println("Couldn't find file: " + path);
                return new JLabel("Image not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private static String convertPath(String originalPath) {
        String prefix = "src\\main\\resources\\";

        // Ensure the path uses forward slashes
        String normalizedPath = originalPath.replace("\\", "/");

        // Remove the prefix if it exists
        if (normalizedPath.startsWith(prefix.replace("\\", "/"))) {
            return normalizedPath.substring(prefix.length());
        }

        return normalizedPath;
    }
}

