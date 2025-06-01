///  File writen by Sunmyoung

import java.awt.*;

public class Ball extends Dynamic {
    public Ball(int width, int height, Point position, Color color, boolean moveState, int speed, int direction, Static paddle, TextEntity gameOver)
    {
        super(width, height, position, color, moveState, speed, direction, paddle,gameOver);
    }

    // writen by AI
    @Override
    protected void paintComponent(Graphics g) 
    {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());
        g2d.fillOval(0, 0, getWidth(), getHeight());
    }
}
