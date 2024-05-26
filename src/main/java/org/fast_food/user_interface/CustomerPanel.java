package org.fast_food.user_interface;

import org.fast_food.customer.Customer;
import org.fast_food.database_connection.CustomerDAOImpl;
import org.fast_food.user_interface.validation.NameFilter;
import org.fast_food.user_interface.validation.TextFieldFilter;
import org.fast_food.user_interface.validation.Validator;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument;
import java.awt.*;
import java.sql.SQLException;

public class CustomerPanel {
    private JFrame frame;
    private final Customer customer;
    private OrderHistoryPage orderHistoryPage;

    public CustomerPanel(Customer customer) throws SQLException {
        this.customer = customer;
        initialize();
    }

    private void initialize() throws SQLException {
        this.frame = new JFrame();
        this.orderHistoryPage = new OrderHistoryPage(customer);
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new GridBagLayout());
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        // Set border for item containers
        gridBagConstraints.insets = new Insets(15,30,15,30);
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(OrderPage.SECONDARY_BACKGROUND_COLOR);
        frame.setResizable(false);

        JLabel pointsLabel = UserInterface.createLabel("Creation date: %s".formatted(customer.getCreationDate()), "Verdana", Font.PLAIN, 14);
        frame.add(pointsLabel, gridBagConstraints);
        frame.add(UserInterface.createLabel("Points: %s".formatted(customer.getPoints()), "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridy = 10;
        JLabel ownerLabel = UserInterface.createLabel("Owner: %s %s".formatted(customer.getFirstName(), customer.getLastName()), "Verdana", Font.PLAIN, 14);
        frame.add(ownerLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton changeOwnerButton = UserInterface.createButton("Change owner", 14);
        frame.add(changeOwnerButton, gridBagConstraints);

        changeOwnerButton.addActionListener(e -> createChangeOwnerDialog(ownerLabel));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        JLabel emailLabel = UserInterface.createLabel("E-mail: %s".formatted(customer.getEmail()), "Verdana", Font.PLAIN, 14);
        frame.add(emailLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton changeEmailButton = UserInterface.createButton("Change email", 14);
        frame.add(changeEmailButton, gridBagConstraints);

        changeEmailButton.addActionListener(e -> {
            try {
                createChangeEmailDialog(emailLabel);
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 20;
        JLabel phoneLabel = UserInterface.createLabel("Phone number: %s".formatted(customer.getPhoneNumber()), "Verdana", Font.PLAIN, 14);
        frame.add(phoneLabel, gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton changePhoneNumberButton = UserInterface.createButton("Change phone number", 14);
        frame.add(changePhoneNumberButton, gridBagConstraints);

        changePhoneNumberButton.addActionListener(e -> createChangePhoneNumberDialog(phoneLabel));

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 25;
        JButton orderHistoryButton = UserInterface.createButton("View order history", 14);
        frame.add(orderHistoryButton, gridBagConstraints);

        orderHistoryButton.addActionListener(e -> {
           orderHistoryPage.show();
        });

        gridBagConstraints.gridx = 1;
        JButton resetPasswordButton = UserInterface.createButton("Reset password", 14);
        frame.add(resetPasswordButton, gridBagConstraints);

        resetPasswordButton.addActionListener(e -> createResetPasswordDialog());

        frame.pack();
        frame.setLocationByPlatform(true);
    }

    private void createResetPasswordDialog() {
        JDialog dialog = new JDialog(frame, "Reset password", true);
        JPasswordField passwordField = new JPasswordField(20);
        JPasswordField repeatedPasswordField = new JPasswordField(20);
        JButton submitButton = UserInterface.createButton("Submit", 14);

        submitButton.addActionListener(e -> {
            try {
                if (Validator.validatePassword(passwordField, repeatedPasswordField)) {
                    customer.setPassword(repeatedPasswordField.getPassword());
                    new CustomerDAOImpl().update(customer);
                    JOptionPane.showMessageDialog(frame, "The password was successfully changed.");
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
        dialog.add(UserInterface.createLabel("Password", "Verdana", Font.PLAIN, 14), gridBagConstraints);
        dialog.add(passwordField, gridBagConstraints);

        gridBagConstraints.gridy = 5;
        dialog.add(UserInterface.createLabel("Repeat password", "Verdana", Font.PLAIN, 14), gridBagConstraints);
        dialog.add(repeatedPasswordField, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 10;
        dialog.setLocationRelativeTo(frame);
        dialog.add(submitButton, gridBagConstraints);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createChangePhoneNumberDialog(JLabel label) {
        JDialog dialog = new JDialog(frame, "Change phone number", true);
        JTextField phoneNumber = new JTextField(20);
        JButton submitButton = UserInterface.createButton("Submit", 14);
        ((AbstractDocument) phoneNumber.getDocument()).setDocumentFilter(new TextFieldFilter(10, true));

        submitButton.addActionListener(e -> {
            try {
                if (Validator.validatePhoneNumber(phoneNumber)) {
                    if (phoneNumber.getText().equals(customer.getPhoneNumber())) {
                        JOptionPane.showMessageDialog(frame, "No changes have been made, because provided phone number is same as current one.");
                    } else {
                        customer.setPhoneNumber(phoneNumber.getText());
                        new CustomerDAOImpl().update(customer);
                        JOptionPane.showMessageDialog(frame, "The phone number was successfully changed.");
                        label.setText("Phone number: %s".formatted(customer.getPhoneNumber()));
                        dialog.setVisible(false);
                    }
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
        dialog.add(UserInterface.createLabel("Phone number", "Verdana", Font.PLAIN, 14), gridBagConstraints);
        dialog.add(phoneNumber, gridBagConstraints);

        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        dialog.setLocationRelativeTo(frame);
        dialog.add(submitButton, gridBagConstraints);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createChangeEmailDialog(JLabel label) throws SQLException {
        JDialog dialog = new JDialog(frame, "Change email", true);
        JTextField textField = new JTextField(20);
        JButton submitButton = UserInterface.createButton("Submit", 14);

        submitButton.addActionListener(e -> {
            try {
                if (Validator.validateEmail(textField)) {
                    if (textField.getText().equals(customer.getEmail())) {
                        JOptionPane.showMessageDialog(frame, "No changes have been made, because provided email is same as current one.");
                    } else {
                        customer.setEmail(textField.getText());
                        new CustomerDAOImpl().update(customer);
                        JOptionPane.showMessageDialog(frame, "The email was successfully changed.");
                        label.setText("E-mail: %s".formatted(customer.getEmail()));
                        dialog.setVisible(false);
                    }
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
        dialog.setLocationRelativeTo(frame);
        dialog.add(submitButton, gridBagConstraints);
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createChangeOwnerDialog(JLabel label) {
        JDialog dialog = new JDialog(frame, "Change owner", true);
        JTextField firstNameField = new JTextField(20);
        JTextField lastNameField = new JTextField(20);
        JButton submitButton = UserInterface.createButton("Submit", 14);

        ((AbstractDocument) firstNameField.getDocument()).setDocumentFilter(new NameFilter(30));
        ((AbstractDocument) lastNameField.getDocument()).setDocumentFilter(new NameFilter(30));

        submitButton.addActionListener(e -> {
            try {
                if (Validator.validateField(firstNameField, "First name") && Validator.validateField(lastNameField, "Last name")) {
                    firstNameField.setText(firstNameField.getText().substring(0, 1).toUpperCase() + firstNameField.getText().substring(1));
                    lastNameField.setText(lastNameField.getText().substring(0, 1).toUpperCase() + lastNameField.getText().substring(1));

                    if (customer.getFirstName().equals(firstNameField.getText()) && customer.getLastName().equals(lastNameField.getText())) {
                        JOptionPane.showMessageDialog(frame, "No changes have been made, because provided values are same as current ones.");
                    } else {
                        customer.setFirstName(firstNameField.getText());
                        customer.setLastName(lastNameField.getText());
                        new CustomerDAOImpl().update(customer);
                        JOptionPane.showMessageDialog(frame, "The owner credentials was successfully changed.");
                        label.setText("Owner: %s %s".formatted(customer.getFirstName(), customer.getLastName()));
                        dialog.setVisible(false);
                    }
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
        dialog.setLocationRelativeTo(frame);
        dialog.add(submitButton, gridBagConstraints);
        dialog.pack();
        dialog.setVisible(true);
    }

    public void show() {
        frame.setVisible(true);
    }
}
