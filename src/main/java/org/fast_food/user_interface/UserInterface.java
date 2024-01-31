package org.fast_food.user_interface;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;

public class UserInterface {
    private StartPage startPage;

    public UserInterface() {
        this.startPage = new StartPage();
        startPage.show();
    }

    protected static JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Verdana",Font.PLAIN, 14));
        button.setFocusable(false);
        return button;
    }

    protected static JTextField createTextField() {
        JTextField textField = new JTextField(20);
        return textField;
    }

    protected static JLabel createLabel(String text, String fontName, int fontStyle, int fontSize) {
        JLabel label = new JLabel(text);
        label.setFont(new Font(fontName, fontStyle, fontSize));
        return label;
    }

    protected static JLabel createImageLabel(String path, int width, int height) {
        return new JLabel(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH)));
    }
}
