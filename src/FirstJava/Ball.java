import javax.swing.*;
import java.awt.*;

public class Ball extends Shape
{
    public Ball(int width, int height)
    {
        super(width, height);
    }

    public Ball(int width, int height, Point position, Color color, boolean moveState, int speed)
    {
        super(width, height, position, color, moveState, speed);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor( super.getColor() );
        g.fillOval( 0, 0, super.getWidth(), super.getHeight() );
    }
}