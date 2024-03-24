package org.fast_food.user_interface;

import org.fast_food.customer.Customer;
import org.fast_food.database_connection.CustomerDAOImpl;

import javax.swing.*;
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
            String newFirstName = JOptionPane.showInputDialog("First name: ");
            String newLastName = JOptionPane.showInputDialog("Last name: ");

            if (newFirstName.equals(customer.getFirstName()) && newLastName.equals(customer.getLastName())) {
                JOptionPane.showMessageDialog(frame, "No change has been made, because the provided values are the same as the current one.");
            } else if (newFirstName.isEmpty() || newLastName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "No change has been made, because the provided values cannot be empty.");
            } else {
                customer.setFirstName(newFirstName);
                customer.setLastName(newLastName);

                try {
                    new CustomerDAOImpl().update(customer);
                    JOptionPane.showMessageDialog(frame, "Owner credentials successfully changed.");
                    ownerLabel.setText("Owner: %s %s".formatted(customer.getFirstName(), customer.getLastName()));
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        frame.add(UserInterface.createLabel("E-mail: %s".formatted(customer.getEmail()), "Verdana", Font.PLAIN, 14), gridBagConstraints);

        gridBagConstraints.gridx = 1;
        JButton changeEmailButton = UserInterface.createButton("Change email", 14);
        frame.add(changeEmailButton, gridBagConstraints);

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

    public void show() {
        frame.setVisible(true);
    }
}
