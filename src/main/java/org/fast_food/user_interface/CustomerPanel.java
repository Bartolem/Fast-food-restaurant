package org.fast_food.user_interface;

import org.fast_food.customer.Customer;
import org.fast_food.database_connection.CustomerDAOImpl;
import org.fast_food.user_interface.validation.NameFilter;
import org.fast_food.user_interface.validation.Validator;

import javax.swing.*;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.sql.SQLException;

public class CustomerPanel {
    private JFrame frame;
    private Customer customer;

    public CustomerPanel(Customer customer) {
        this.customer = customer;
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // Set border for item containers
        gridBagConstraints.insets = new Insets(15,30,15,30);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(OrderPage.PRIMARY_BACKGROUND_COLOR);
        frame.setResizable(false);
        frame.add(UserInterface.createLabel("Creation date: %s".formatted(customer.getCreationDate()), "Verdana", Font.PLAIN, 14), gridBagConstraints);
        frame.add(UserInterface.createLabel("Points: %s".formatted(customer.getPoints()), "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridy = 10;
        JLabel ownerLabel = UserInterface.createLabel("Owner: %s %s".formatted(customer.getFirstName(), customer.getLastName()), "Verdana", Font.PLAIN, 14);
        frame.add(ownerLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton changeOwnerButton = UserInterface.createButton("Change owner", 14);
        frame.add(changeOwnerButton, gridBagConstraints);

        changeOwnerButton.addActionListener(e -> {
            createChangeOwnerDialog();
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        frame.add(UserInterface.createLabel("E-mail: %s".formatted(customer.getEmail()), "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton changeEmailButton = UserInterface.createButton("Change email", 14);
        frame.add(changeEmailButton, gridBagConstraints);

        changeEmailButton.addActionListener(e -> {
            try {
                createChangeEmailDialog();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        frame.add(UserInterface.createLabel("Phone number: %s".formatted(customer.getPhoneNumber()), "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton changePhoneNumberButton = UserInterface.createButton("Change phone number", 14);
        frame.add(changePhoneNumberButton, gridBagConstraints);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 25;
        JButton orderHistoryButton = UserInterface.createButton("View order history", 14);
        frame.add(orderHistoryButton, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton resetPasswordButton = UserInterface.createButton("Reset password", 14);
        frame.add(resetPasswordButton, gridBagConstraints);

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    private void createChangeEmailDialog() throws SQLException {
        JDialog dialog = new JDialog(frame, "Change email", true);
        JTextField textField = new JTextField(20);
        JButton submitButton = UserInterface.createButton("Submit", 14);

        submitButton.addActionListener(e -> {
            try {
                if (Validator.validateEmail(textField)) {
                    customer.setEmail(textField.getText());
                    new CustomerDAOImpl().update(customer);
                    JOptionPane.showMessageDialog(frame, "The email was successfully changed.");
                    dialog.setVisible(false);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        dialog.setLayout(new GridBagLayout());
        dialog.setIconImage(UserInterface.ICON.getImage());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // Set border for item containers
        gridBagConstraints.insets = new Insets(10,10,10,10);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        dialog.setResizable(false);
        dialog.add(UserInterface.createLabel("E-mail", "Verdana", Font.PLAIN, 14), gridBagConstraints);
        dialog.add(textField, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        dialog.add(submitButton, gridBagConstraints);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createChangeOwnerDialog() {
        JDialog dialog = new JDialog(frame, "Change owner", true);
        JTextField firstNameField = new JTextField(20);
        JTextField lastNameField = new JTextField(20);
        JButton submitButton = UserInterface.createButton("Submit", 14);

        ((AbstractDocument) firstNameField.getDocument()).setDocumentFilter(new NameFilter(30));
        ((AbstractDocument) lastNameField.getDocument()).setDocumentFilter(new NameFilter(30));

        submitButton.addActionListener(e -> {
            try {
                if (Validator.validateField(firstNameField, "First name") && Validator.validateField(lastNameField, "Last name")) {
                    customer.setFirstName(firstNameField.getText());
                    customer.setLastName(lastNameField.getText());
                    new CustomerDAOImpl().update(customer);
                    JOptionPane.showMessageDialog(frame, "The owner credentials was successfully changed.");
                    dialog.setVisible(false);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        dialog.setLayout(new GridBagLayout());
        dialog.setIconImage(UserInterface.ICON.getImage());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // Set border for item containers
        gridBagConstraints.insets = new Insets(10,10,10,10);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        dialog.setResizable(false);
        dialog.add(UserInterface.createLabel("First name", "Verdana", Font.PLAIN, 14), gridBagConstraints);
        dialog.add(firstNameField, gridBagConstraints);

        gridBagConstraints.gridy = 5;
        dialog.add(UserInterface.createLabel("Last name", "Verdana", Font.PLAIN, 14), gridBagConstraints);
        dialog.add(lastNameField, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        dialog.add(submitButton, gridBagConstraints);
        dialog.pack();
        dialog.setVisible(true);
    }

    public void show() {
        frame.setVisible(true);
    }
}
