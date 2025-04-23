import javax.swing.*;
import java.awt.*;

public class Rect extends JComponent
{
    private int width;
    private int height;
    private Point position;
    private Color color; 
    private boolean moveState;

    public Rect(int width, int height)
    {
        this.width = width;
        this.height = height;
        setSize(width, height);
        moveState = true;
    }

    public Rect(Point position, int width, int height, Color color)
    {
        this.position = position;
        this.color = color;
        this.width = width;
        this.height = height;
        setBounds(position.x, position.y, width, height);
        moveState = true;
    }

    public boolean getMoveState()
    {
        return moveState;
    }
    
    public String toString()
    {
        return "rect1 has widt: " + width + ", and height: " + height;
    }

    public void moveRight()
    {
        position.x += 2;
        setBounds(position.x, position.y, width, height); // This moves the component
        repaint(); // Make sure it repaints after moving
    }
    public void moveLeft()
    {
        position.x -= 2;
        setBounds(position.x, position.y, width, height); 
        repaint(); 
    }
    public void moveDown()
    {
        position.y += 2;
        setBounds(position.x, position.y, width, height); 
        repaint(); 
    }
    public void moveUp()
    {
        position.y -= 2;
        setBounds(position.x, position.y, width, height); 
        repaint(); 
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(color);        
        g.fillRect( 0, 0, width, height ); // internal coordinate
    }
}
