package org.fast_food.user_interface;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static org.fast_food.user_interface.UserInterface.*;

public class StartPage {
    private JFrame frame;
    private OrderPage orderPage;
    private LaunchProgress launchProgress;

    public StartPage() {
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
        JPasswordField passwordField = new JPasswordField(20);
        JButton continueButton = createButton("Continue without account", 14);

        continueButton.addActionListener(e -> {
            if (e.getSource() == continueButton) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        // Perform time-consuming task here
                        launchProgress = new LaunchProgress();
                        launchProgress.show();
                        frame.dispose();
                        orderPage = new OrderPage();
                        return null;
                    }

                    @Override
                    protected void done() {
                        // Open the OrderPage after the task is complete
                        launchProgress.close();
                        orderPage.show();
                        JOptionPane.showMessageDialog(frame,"Welcome to Bartolo's Burger!");
                    }
                };
                worker.execute();
            }
        });

        panel.setBackground(OrderPage.SECONDARY_BACKGROUND_COLOR);
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginLabel.setForeground(new Color(0, 0, 0));
        passwordField.setForeground(new Color(0, 0, 0));

        panel.add(loginLabel, "span, wrap, growx");
        panel.add(createLabel("E-mail", "Verdana",Font.PLAIN, 14), "pushx");
        panel.add(createTextField(), "wrap, pushx, growx");
        panel.add(createLabel("Password", "Verdana",Font.PLAIN, 14), "pushx");
        panel.add(passwordField, "wrap, pushx, growx");
        panel.add(createButton("Login", 14), "skip, split2, growx");
        panel.add(createButton("Register", 14), "wrap, growx");
        panel.add(continueButton, "skip, growx");
        return panel;
    }
}
