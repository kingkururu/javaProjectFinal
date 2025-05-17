///  File writen by Sunmyoung Yun

import java.awt.*;

public class Rect extends Shape
{
    public Rect(int width, int height)
    {
        super(width, height);
    }

    public Rect(int width, int height, Point position, Color color, boolean moveState, int speed)
    {
        super(width, height, position, color, moveState, speed);
    }

    public String toString()
    {
        return "rect1 has widt: " + super.getWidth() + ", and height: " + super.getHeight();
    }
}
