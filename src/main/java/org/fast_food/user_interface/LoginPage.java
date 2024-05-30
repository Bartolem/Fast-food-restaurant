package org.fast_food.user_interface;

import net.miginfocom.swing.MigLayout;
import org.fast_food.authentication.Authenticator;
import org.fast_food.customer.Customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

import static org.fast_food.user_interface.UserInterface.*;

public class LoginPage {
    private JFrame frame;
    private OrderPage orderPage;
    private LaunchProgress launchProgress;
    private RegistrationForm registrationForm;
    private Customer customer;

    public LoginPage() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        JPanel upperPanel = createUpperPanel();
        JPanel bottomPanel = createBottomPanel();

        frame.setTitle(TITLE);
        frame.setIconImage(ICON.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(upperPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationByPlatform(true);
    }

    public void show() {
        frame.setVisible(true);
    }

    protected JPanel createUpperPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel labelImage = createImageLabel("src/main/resources/logo.png", 350, 125);
        JLabel  label = new JLabel("Satisfy Your Hunger, Elevate Your Taste.");

        labelImage.setBorder(new EmptyBorder(20, 40, 10, 40));

        label.setBorder(new EmptyBorder(0, 20, 10, 20));
        label.setFont(new Font("Calibri", Font.ITALIC, 18));
        label.setForeground(new Color(0, 31, 63));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panel.add(labelImage, BorderLayout.CENTER);
        panel.setBackground(OrderPage.PRIMARY_BACKGROUND_COLOR);
        panel.add(label, BorderLayout.SOUTH);
        return panel;
    }

    private JPanel createBottomPanel() {
        JPanel panel = new JPanel(new MigLayout());
        JLabel loginLabel = createLabel("Login", "Verdana",Font.PLAIN, 28);
        JTextField email = createTextField();
        JPasswordField passwordField = new JPasswordField(20);
        JButton loginButton = createButton("Login", 14);
        JButton registerButton = createButton("Register", 14);
        JButton continueButton = createButton("Continue without account", 14);

        loginButton.addActionListener(e -> {
            if (email.getText().isEmpty() && passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(frame, "Email and Password fields cannot be empty!", "Required Fields", JOptionPane.ERROR_MESSAGE);
            } else if (email.getText().isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Email field cannot be empty!", "Missing Email", JOptionPane.ERROR_MESSAGE);
            } else if (passwordField.getPassword().length == 0) {
                JOptionPane.showMessageDialog(frame, "Password field cannot be empty!", "Missing Password", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    this.customer = Authenticator.login(email.getText(), passwordField.getPassword());
                    if (customer != null) {
                        JOptionPane.showMessageDialog(frame, "Successfully logged in!");
                        launchApplication(customer);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Incorrect Email or Password!", "Authentication Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex.getMessage());
                }
            }
        });

        registerButton.addActionListener(e -> {
            this.registrationForm = new RegistrationForm();
            registrationForm.show();
        });

        continueButton.addActionListener(e -> {
            launchApplication(customer);
        });

        panel.setBackground(OrderPage.SECONDARY_BACKGROUND_COLOR);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(new Color(0, 0, 0));
        passwordField.setForeground(new Color(0, 0, 0));

        panel.add(loginLabel, "span, wrap, growx");
        panel.add(createLabel("E-mail", "Verdana",Font.PLAIN, 14), "pushx");
        panel.add(email, "wrap, pushx, growx");
        panel.add(createLabel("Password", "Verdana",Font.PLAIN, 14), "pushx");
        panel.add(passwordField, "wrap, pushx, growx");
        panel.add(loginButton, "skip, split2, growx");
        panel.add(registerButton, "wrap, growx");
        panel.add(continueButton, "skip, growx");
        return panel;
    }

    private void launchApplication(Customer customer) {
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws SQLException {
                // Perform time-consuming task here
                launchProgress = new LaunchProgress();
                launchProgress.show();
                frame.dispose();
                orderPage = new OrderPage(customer);
                return null;
            }

            @Override
            protected void done() {
                // Open the OrderPage after the task is complete
                launchProgress.close();
                orderPage.show();
                if (customer == null) {
                    JOptionPane.showMessageDialog(frame,"Welcome to Bartolo's Burger!");
                } else {
                    JOptionPane.showMessageDialog(frame,"Welcome %s!".formatted(customer.getFirstName()), "Welcome to Bartolo's Burger", JOptionPane.PLAIN_MESSAGE);
                }
            }
        };
        worker.execute();
    }
}
