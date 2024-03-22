package org.fast_food.user_interface.validation;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NameFilter extends DocumentFilter {
    private final int maxLength;

    public NameFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
                             AttributeSet attr) throws BadLocationException {
        if ((fb.getDocument().getLength() + text.length()) <= maxLength &&
                text.matches("[a-zA-Z]+")) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        int newLength = fb.getDocument().getLength() - length + text.length();
        if (newLength <= maxLength && text.matches("[a-zA-Z]+")) {
            super.replace(fb, offset, length, text, attrs);
        }
    }
}
