import javax.swing.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Window 
{
    private int width; 
    private int height;
    private boolean visibleState;

    private JFrame frame;

    private ArrayList<JComponent> entities;

    public Window(int width, int height)
    {
        this.width = width;
        this.height = height;
        visibleState = true;

        this.entities = new ArrayList<>(); 

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
            this.entities.add(entity);
        }
    }

    public void showWindow()
    {
        frame.setLayout(null);
        drawWindow();
        frame.revalidate();
        frame.repaint();
    }

    private void drawWindow()
    {
        for ( JComponent entity : this.entities){
            frame.add(entity);
            System.out.println(entity.toString()); 
        }
    }

}
