package org.fast_food.user_interface.validation;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class TextFieldFilter extends DocumentFilter {
    private final int maxLength;
    private final boolean digitsOnly;

    public TextFieldFilter(int maxLength, boolean digitsOnly) {
        this.maxLength = maxLength;
        this.digitsOnly = digitsOnly;
    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text,
                             AttributeSet attr) throws BadLocationException {
        if (digitsOnly && !text.matches("\\d+")) {
            return; // Only digits allowed
        }
        if ((fb.getDocument().getLength() + text.length()) <= maxLength) {
            super.insertString(fb, offset, text, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
                        AttributeSet attrs) throws BadLocationException {
        if (digitsOnly && !text.matches("\\d+")) {
            return; // Only digits allowed
        }
        int currentLength = fb.getDocument().getLength();
        int overLimit = (currentLength + text.length()) - maxLength;
        if (overLimit > 0) {
            text = text.substring(0, text.length() - overLimit);
        }
        super.replace(fb, offset, length, text, attrs);
    }
}
