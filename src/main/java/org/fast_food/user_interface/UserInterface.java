package org.fast_food.user_interface;

import javax.swing.*;
import java.awt.*;

public class UserInterface {
    public static String TITLE = "Bartolo's Burger";
    public static ImageIcon ICON = new ImageIcon("src/main/resources/icon.png");
    public static Color BUTTON_COLOR = new Color(121, 186, 253);
    private final StartPage startPage;

    public UserInterface() {
        this.startPage = new StartPage();
        startPage.show();
    }

    protected static JButton createButton(String text, int size) {
        JButton button = new JButton(text);
        button.setFont(new Font("Verdana",Font.PLAIN, size));
        button.setForeground(Color.BLACK);
        button.setBackground(BUTTON_COLOR);
        button.setFocusable(false);
        return button;
    }

    protected static JTextField createTextField() {
        return new JTextField(20);
    }

    protected static JLabel createLabel(String text, String fontName, int fontStyle, int fontSize) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        return label;
    }

    protected static JLabel createLabel(String text, String fontName, int fontStyle, int fontSize, Color color) {
        JLabel label = createLabel(text, fontName, fontStyle, fontSize);
        label.setForeground(color);
        return label;
    }

    protected static JLabel createImageLabel(String path, int width, int height) {
        return new JLabel(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
}
