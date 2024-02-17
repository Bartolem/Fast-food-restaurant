package org.fast_food.user_interface;

import org.fast_food.order.Order;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class ProcessingOrderPage {
    private JFrame frame;
    private JProgressBar progressBar;
    private final Order order;

    public ProcessingOrderPage(Order order) {
        this.order = order;
        initialize();
    }

    private void initialize() {
        this.frame = new JFrame();
        this.progressBar = createProgressBar();
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(new Color(54, 137, 191));
        JLabel label = UserInterface.createLabel("Your order are processing. Please wait.", "Verdana", Font.PLAIN, 16);
        label.setBorder(new EmptyBorder(20, 20, 20, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label, BorderLayout.NORTH);
        frame.add(new JLabel(new ImageIcon("src/main/resources/burger_animation.gif")), BorderLayout.CENTER);
        frame.add(progressBar, BorderLayout.SOUTH);
        frame.setResizable(false);
        frame.pack();
        simulateProgress();
    }

    public void simulateProgress() {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Random random = new Random();
                int progress = 0;
                while (progress < 100) {
                    progressBar.setValue(progress);
                    //Sleep for up to one second.
                    try {
                        Thread.sleep(random.nextInt(100 * order.getNumberOfProducts()));
                    } catch (InterruptedException ignore) {}
                    //Make random progress.
                    progress += random.nextInt(10);
                }
                return null;
            }

            @Override
            protected void done() {
                progressBar.setValue(100);
                System.out.println(order.getNumberOfProducts());
                JOptionPane.showMessageDialog(frame, "Your order is successfully completed.");
                frame.setVisible(false);
            }
        };
        swingWorker.execute();
    }

    public void show() {
        frame.setVisible(true);
    }

    public JProgressBar createProgressBar() {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        return progressBar;
    }
}
