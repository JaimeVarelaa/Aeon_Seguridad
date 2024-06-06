package Filters;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.util.regex.Pattern;

public class IPFilter extends DocumentFilter {
    private static final String IP_PATTERN =
            "^(\\d{1,3}\\.){0,3}\\d{0,3}$"; 
    private Pattern pattern = Pattern.compile(IP_PATTERN);

    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        String newString = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
        if (pattern.matcher(newString).matches() && isValidIPAddress(newString)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        String newString = fb.getDocument().getText(0, fb.getDocument().getLength()).substring(0, offset)
                + text + fb.getDocument().getText(0, fb.getDocument().getLength()).substring(offset + length);
        if (pattern.matcher(newString).matches() && isValidIPAddress(newString)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws BadLocationException {
        String newString = fb.getDocument().getText(0, fb.getDocument().getLength()).substring(0, offset)
                + fb.getDocument().getText(0, fb.getDocument().getLength()).substring(offset + length);
        if (pattern.matcher(newString).matches()) {
            super.remove(fb, offset, length);
        }
    }

    private boolean isValidIPAddress(String text) {
        String[] parts = text.split("\\.");
        for (String part : parts) {
            if (!part.isEmpty()) {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255) {
                    return false;
                }
            }
        }
        return true;
    }
}
