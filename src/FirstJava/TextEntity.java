import javax.swing.*;
import java.awt.*;

public class TextEntity extends JComponent
{
    private String message;
    private int size;
    private Color color;
    private Point startingPoint;
    private Font text;

    public TextEntity()
    {
        message = "Text message not initialized";
        size = 50;
        color = Color.BLACK;
        text = new Font(message, Font.BOLD, size);
        this.setSize(message.length() * size, size * 2);
    }
    
    public TextEntity(Point startingPoint, String message, int size, Color color)
    {
        this.startingPoint = startingPoint;
        this.message = message;
        this.size = size;
        this.color = color;
        text = new Font(message, Font.BOLD, size);
        this.setSize(message.length() * size, size * 2);
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setFont(text);
        g.setColor(color);

        g.drawString(message, startingPoint.x, startingPoint.y);
    }
}
