import javax.swing.*;
import java.awt.*;

public class Rect extends JComponent
{
    private int width;
    private int height;
    private Point startingPoint;
    private Color color; 

    public Rect(int width, int height)
    {
        this.width = width;
        this.height = height;
        setSize(width, height);
    }

    public Rect(Point startingPoint, int width, int height, Color color)
    {
        this.startingPoint = startingPoint;
        this.color = color;
        this.width = width;
        this.height = height;
        setBounds(startingPoint.x, startingPoint.y, width, height);
    }

    public String toString()
    {
        return "rect1 has widt: " + width + ", and height: " + height;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect( 0, 0, width, height );
    }
}
