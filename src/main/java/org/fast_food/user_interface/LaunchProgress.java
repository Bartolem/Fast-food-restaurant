package org.fast_food.user_interface;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LaunchProgress {
    private JFrame frame;

    public LaunchProgress() {
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        JProgressBar progressBar = createProgressBar();
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setTitle(UserInterface.TITLE);
        frame.setLayout(new BorderLayout());
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(255, 89, 60));
        frame.add(new StartPage().createUpperPanel(), BorderLayout.CENTER);
        frame.add(progressBar, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
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
        progressBar.setPreferredSize(new Dimension(500, 20));
        progressBar.setIndeterminate(true);
        progressBar.setBackground(new Color(255, 194, 150));
        progressBar.setForeground(new Color(255, 89, 60));
        return progressBar;
    }
}
