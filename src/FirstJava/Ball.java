import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball extends Shape {
    public Ball(int width, int height) {
        super(width, height);
        initializeComponent(width, height);
    }

    public Ball(int width, int height, Point position, Color color, boolean moveState, int speed) {
        super(width, height, position, color, moveState, speed);
        initializeComponent(width, height);
    }

    private void initializeComponent(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setOpaque(false); // Prevent background from being painted
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getColor());
        int size = Math.min(getWidth(), getHeight());
        g2d.fillOval(0, 0, size, size);
    }
}