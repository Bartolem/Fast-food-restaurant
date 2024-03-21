package org.fast_food.user_interface;

import javax.swing.*;
import java.awt.*;

import static org.fast_food.user_interface.UserInterface.*;

public class RegistrationForm {
    private JFrame frame;
    public RegistrationForm() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();

        frame.setTitle("Registration");
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // Set border for item containers
        gridBagConstraints.insets = new Insets(20,30,20,30);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JTextField firstName = createTextField();
        JTextField lastName = createTextField();
        JTextField email = createTextField();
        JPasswordField password = new JPasswordField();
        JPasswordField repeatedPassword = new JPasswordField();
        JTextField phoneNumber = createTextField();
        JButton submitButton = createButton("Submit", 14);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        frame.add(UserInterface.createLabel("First name", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(firstName, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        frame.add(UserInterface.createLabel("Last name", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(lastName, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 30;
        frame.add(UserInterface.createLabel("E-mail", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(email, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 40;
        frame.add(UserInterface.createLabel("Password", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(password, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 50;
        frame.add(UserInterface.createLabel("Repeat password", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(repeatedPassword, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 60;
        frame.add(UserInterface.createLabel("Phone number", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(phoneNumber, gridBagConstraints);

        gridBagConstraints.gridy = 80;
        frame.add(submitButton, gridBagConstraints);

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    public void show() {
        frame.setVisible(true);
    }
}
