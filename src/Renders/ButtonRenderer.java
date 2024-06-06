package Renders;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.JButton;

public class ButtonRenderer extends JButton {

    private Color dBC;
    private Color hBC;
    private Color pBC;
    private Color dTC;
    private Color hTC;
    private Random r;
    private boolean isHovered;
    private Thread t;

    public ButtonRenderer(String text) {
        super(text);
        setOpaque(false);
        setFocusPainted(false);
        setForeground(new Color(197, 218, 250));
        setBackground(new Color(51, 51, 51));
        setFont(new Font("Arial", Font.BOLD, 14));

        dBC = getBackground();
        hBC = new Color(71, 71, 71);
        pBC = new Color(31, 31, 31);
        dTC = getForeground();
        hTC = new Color(197, 218, 250);
        r = new Random();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                isHovered = true;
                startColorChangeThread();
                setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                isHovered = false;
                stopColorChangeThread();
                setBackground(dBC);
                setForeground(dTC);
                setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(pBC);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(dBC);
                setForeground(dTC);
            }
        });
    }

    private void startColorChangeThread() {
    t = new Thread(() -> {
        try {
            while (isHovered) {
                setBackground(generateRandomColor());
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
        }
    });
    t.start();
}


    private void stopColorChangeThread() {
        if (t != null) {
            t.interrupt();
            t = null;
        }
    }

    private Color generateRandomColor() {
        int red = Math.min(255, dBC.getRed() + r.nextInt(50));
        int green = Math.min(255, dBC.getGreen() + r.nextInt(50));
        int blue = Math.min(255, dBC.getBlue() + r.nextInt(50));
        return new Color(red, green, blue);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, width, height, 30, 30);
        g2.setColor(getForeground());
        g2.setFont(getFont());
        String text = getText();
        if (text != null) {
            FontMetrics fm = g2.getFontMetrics();
            int x = (width - fm.stringWidth(text)) / 2;
            int y = (height + fm.getAscent()) / 2;
            g2.drawString(text, x, y);
        }

        g2.setColor(new Color(197, 218, 250));
        g2.setStroke(new BasicStroke(1));
        g2.drawRoundRect(0, 0, width - 1, height - 1, 30, 30);

        g2.dispose();
    }
}
