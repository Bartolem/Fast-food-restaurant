package org.fast_food;

import org.fast_food.user_interface.UserInterface;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Run this program on the Event Dispatch Thread (EDT)
        EventQueue.invokeLater(UserInterface::new);
    }
}