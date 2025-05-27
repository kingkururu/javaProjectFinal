///  File writen by Sunmyoung Yun

import java.awt.*;
import javax.swing.*;

public class TextEntity extends JComponent {
    private String message;
    private int size;
    private Color color;
    private Font text;

    public TextEntity() {
        this(new Point(0, 0), "Text message not initialized", 50, Color.BLACK);
    }

    public TextEntity(Point startingPoint, String message, int size, Color color) {
        this.message = message;
        this.size = size;
        this.color = color;
        this.text = new Font("Arial", Font.BOLD, size);
        this.setFont(text);

        // Use FontMetrics to size the component properly
        FontMetrics metrics = getFontMetrics(text);
        int width = metrics.stringWidth(message);
        int height = metrics.getHeight();
        this.setBounds(startingPoint.x, startingPoint.y, width, height);

        setOpaque(false); // Optional: make background transparent
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(text);
        g.setColor(color);

        // Draw string inside the component
        g.drawString(message, 0, g.getFontMetrics().getAscent());
    }
}
