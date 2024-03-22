package org.fast_food.user_interface.validation;

import javax.swing.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validateField(JTextField textField, String fieldName) {
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, fieldName + " cannot be empty!", "Empty text field", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public static boolean validatePassword(JPasswordField password, JPasswordField repeatedPassword) {
        if (password.getPassword().length == 0) {
            System.out.println("Password field cannot be empty!");
            return false;
        } else if (repeatedPassword.getPassword().length == 0) {
            System.out.println("Repeated password field cannot be empty!");
            return false;
        } else if (Arrays.compare(password.getPassword(), repeatedPassword.getPassword()) != 0) {
            System.out.println("Password and repeated password should be the same!");
            return false;
        }
        return true;
    }

    public static boolean validateEmail(JTextField emailField) {
        if (validateField(emailField, "E-mail")) {
            // Regular Expression by RFC 5322 for Email Validation
            Pattern pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
            Matcher matcher = pattern.matcher(emailField.getText());
            if (!matcher.matches()) {
                JOptionPane.showMessageDialog(null, "Email is in the wrong format!", "Invalid email format", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
        return false;
    }

    public static boolean validatePhoneNumber(JTextField phoneNumberField) {
        if (validateField(phoneNumberField, "Phone number")) {
            if (phoneNumberField.getText().length() < 9) {
                JOptionPane.showMessageDialog(null, "Phone number should include the minimum of 9 digits!", "Invalid phone number format", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            return true;
        }
        return false;
    }
}
