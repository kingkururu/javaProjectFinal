import javax.swing.*;
import java.awt.*;

public class Rect extends JComponent
{
    private int width;
    private int height;

    public Rect(int width, int height){
        this.width = width;
        this.height = height;
        setSize(width, height);
    }

    public String toString(){
        return "rect1 has widt: " + width + ", and height: " + height;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawRect( 0,0,width,height );
    }
}
