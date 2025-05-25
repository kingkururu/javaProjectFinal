///  File writen by Sunmyoung Yun

import java.awt.*;

public class Static extends Shape
{
    public Static(int width, int height)
    {
        super(width, height);
    }

    public Static(int width, int height, Point position, Color color, boolean moveState, int speed)
    {
        super(width, height, position, color, moveState, speed);
    }

    @Override
    public String toString()
    {
        return "rect1 has width: " + getShapeWidth() + ", and height: " + getShapeHeight();
    }
}
