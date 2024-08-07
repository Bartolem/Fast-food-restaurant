package org.fast_food.user_interface;

import org.fast_food.user_interface.order_page.OrderPage;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class LaunchProgress {
    private JFrame frame;

    public LaunchProgress() throws SQLException {
        initialize();
    }

    private void initialize() throws SQLException {
        this.frame = new JFrame();
        JProgressBar progressBar = createProgressBar();
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setTitle(UserInterface.TITLE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(OrderPage.PRIMARY_BACKGROUND_COLOR);
        frame.add(new LoginPage().createUpperPanel(), BorderLayout.CENTER);
        frame.add(progressBar, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationByPlatform(true);
    }

    public void show() {
        frame.setVisible(true);
    }

    public void close() {
        frame.setVisible(false);
    }

    private JProgressBar createProgressBar() {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setString("Loading...");
        progressBar.setPreferredSize(new Dimension(500, 30));
        progressBar.setFont(new Font("Verdana", Font.ITALIC, 20));
        progressBar.setIndeterminate(true);
        progressBar.setBackground(OrderPage.SECONDARY_BACKGROUND_COLOR);
        progressBar.setForeground(OrderPage.PRIMARY_BACKGROUND_COLOR);
        return progressBar;
    }
}
