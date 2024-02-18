package org.fast_food.user_interface;

import org.fast_food.order.Order;
import org.fast_food.order.OrderManagement;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;

public class ProcessingOrderPage {
    public static Color BACKGROUND_COLOR = new Color(54, 137, 191);
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
        JLabel label = createLabel();
        frame.setTitle(UserInterface.TITLE);
        frame.setIconImage(UserInterface.ICON.getImage());
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setBackground(BACKGROUND_COLOR);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        frame.add(label, BorderLayout.NORTH);
        frame.add(new JLabel(new ImageIcon("src/main/resources/burger_animation.gif")), BorderLayout.CENTER);
        frame.add(progressBar, BorderLayout.SOUTH);
        frame.setResizable(false);
        frame.pack();
        simulateProgress();
    }

    private void simulateProgress() {
        SwingWorker<Void, Void> swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Random random = new Random();
                int progress = 0;
                while (progress < 100) {
                    progressBar.setValue(progress);
                    //Sleep for up to one second.
                    try {
                        Thread.sleep(random.nextInt(100 * (order.getNumberOfProducts() / 2)));
                    } catch (InterruptedException ignore) {}
                    //Make random progress.
                    progress += random.nextInt(10);
                }
                return null;
            }

            @Override
            protected void done() {
                progressBar.setValue(100);
                OrderManagement.completeOrder(order);
//                OrderManagement.removeOrder(order);
                JOptionPane.showMessageDialog(frame, "Your order is successfully completed.");
                frame.setVisible(false);
                BillReceiptPrinter billReceiptPrinter = new BillReceiptPrinter(order);
                billReceiptPrinter.printReceipt();
            }
        };
        swingWorker.execute();
    }

    public void show() {
        frame.setVisible(true);
    }

    private JProgressBar createProgressBar() {
        JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        return progressBar;
    }

    private JLabel createLabel() {
        JLabel label = UserInterface.createLabel("Your order are processing. Please wait.", "Verdana", Font.PLAIN, 16);
        label.setBorder(new EmptyBorder(20, 20, 20, 20));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        return label;
    }
}
