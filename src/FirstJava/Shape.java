/// File written by Sunmyoung Yun

import javax.swing.*;
import java.awt.*;

public class Shape extends JComponent
{
    private int width;
    private int height;
    private Point position;
    private Color color; 
    private boolean moveState;

    private int speed; // num of pixels moving per frame

    public Shape(int width, int height, Point position, Color color, boolean moveState, int speed)
    {
        this.width = width;
        this.height = height;
        this.position = position;
        this.color = color;
        this.moveState = moveState;
        this.speed = speed;
    }

    public Shape(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.position = new Point(0, 0);  // Set default position
        this.color = Color.BLUE;         // Default color
        this.moveState = true;
        this.speed = 5;
        setBounds(position.x, position.y, width, height); // Important
    }

    public boolean getMoveState()
    {
        return moveState;
    }

    public Color getColor()
    {
        return color;
    }

    public void moveRight()
    {
        position.x += speed;
        setBounds(position.x, position.y, width, height); // This moves the component
        repaint(); // Make sure it repaints after moving
    }
    public void moveLeft()
    {
        position.x -= speed;
        setBounds(position.x, position.y, width, height); 
        repaint(); 
    }
    public void moveDown()
    {
        position.y += speed;
        setBounds(position.x, position.y, width, height); 
        repaint(); 
    }
    public void moveUp()
    {
        position.y -= speed;
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