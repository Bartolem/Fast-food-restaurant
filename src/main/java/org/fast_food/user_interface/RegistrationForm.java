package org.fast_food.user_interface;

import org.fast_food.customer.Customer;
import org.fast_food.database_connection.CustomerDAOImpl;
import org.fast_food.user_interface.validation.NameFilter;
import org.fast_food.user_interface.validation.TextFieldFilter;
import org.fast_food.user_interface.validation.Validator;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.sql.SQLException;

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
        gridBagConstraints.insets = new Insets(15,30,15,30);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        JTextField firstName = createTextField();
        JTextField lastName = createTextField();
        JTextField email = createTextField();
        JPasswordField password = new JPasswordField();
        JPasswordField repeatedPassword = new JPasswordField();
        JTextField phoneNumber = createTextField();

        ((AbstractDocument) firstName.getDocument()).setDocumentFilter(new NameFilter(30));
        ((AbstractDocument) lastName.getDocument()).setDocumentFilter(new NameFilter(30));
        ((AbstractDocument) phoneNumber.getDocument()).setDocumentFilter(new TextFieldFilter(10, true));

        JButton submitButton = createButton("Submit", 14);

        submitButton.addActionListener(e -> {
            try {
                if (Validator.validateField(firstName, "First name") &&
                        Validator.validateField(lastName, "Last name") &&
                        Validator.validateEmail(email) &&
                        Validator.validatePassword(password, repeatedPassword) &&
                        Validator.validatePhoneNumber(phoneNumber)) {
                    try {
                        firstName.setText(firstName.getText().substring(0, 1).toUpperCase() + firstName.getText().substring(1));
                        lastName.setText(lastName.getText().substring(0, 1).toUpperCase() + lastName.getText().substring(1));

                        Customer customer = new Customer(firstName.getText(), lastName.getText(), email.getText(), new String(repeatedPassword.getPassword()), phoneNumber.getText());
                        new CustomerDAOImpl()
                                .insert(customer);
                        JOptionPane.showMessageDialog(frame, "Your account was successfully created! Now you can log in.");
                        close();
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex.getMessage());
                    }
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

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
        frame.add(UserInterface.createLabel("Phone number", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(phoneNumber, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 50;
        frame.add(UserInterface.createLabel("Password", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(password, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 60;
        frame.add(UserInterface.createLabel("Repeat password", "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 5;
        frame.add(repeatedPassword, gridBagConstraints);

        gridBagConstraints.gridy = 80;
        frame.add(submitButton, gridBagConstraints);

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }
}
