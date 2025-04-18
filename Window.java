import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Window 
{
    private int width; 
    private int height;
    private boolean visibleState;

    private JFrame frame;

    private ArrayList<Graphics> objectList;

    public Window(int width, int height)
    {
        this.width = width;
        this.height = height;
        visibleState = true;

        objectList = new ArrayList<>(); 

        frame = new JFrame();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.frame.setVisible(visibleState);
    }

    public void setVisibleState(boolean visibleState)
    {
        this.visibleState = visibleState;
        this.frame.setVisible(visibleState);
    }

    public boolean getVisibleState()
    {
        return visibleState;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
    }

    public void addToWindow(ArrayList<JComponent> entities)
    {
        for ( JComponent entity : entities){
            frame.add(entity);
        }
    }

    public void showWindow()
    {
        frame.setLayout(null);
        frame.repaint();
    }
}
