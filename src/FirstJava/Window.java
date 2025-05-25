///  File writen by Sunmyoung Yun

import javax.swing.*;

import java.util.ArrayList;

public class Window 
{
    private boolean visibleState;

    private JFrame frame;

    private ArrayList<JComponent> entities;
    private Dynamic paddle;
    private Static floor;
    private Static rightWall;
    private Dynamic ball1;

    public Window()
    {

        visibleState = true;

        this.entities = new ArrayList<>(); 

        frame = new JFrame();
        frame.setSize(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

    public void addToWindow(ArrayList<JComponent> entities)
    {
        for(JComponent entity : entities)
        {
            this.entities.add(entity);
        }
        paddle = (Dynamic)entities.get(0); // the first element should be rect
        floor = (Static)entities.get(1);
        rightWall = (Static)entities.get(2);
        ball1 = (Dynamic)entities.get(3);
    }

    public void showWindow()
    {
        frame.setLayout(null);
        drawWindow();
        frame.revalidate();
        frame.repaint();
        frame.setVisible(visibleState);
    }

    private void drawWindow()
    {
        for (JComponent entity : this.entities)
        {
            frame.add(entity);
            System.out.println(entity.toString()); 
        }
    }

    public void startAnimation()
    {
        Timer timer = new Timer(30, e -> {
            updateWindow();
        });
        timer.start();
    }

    public void updateWindow()
    {
        ball1.moveDirection();
        boolean dPressed = true;
        boolean aPressed = false;
        if(dPressed && paddle.getBounds().x + paddle.getBounds().width < Game.WINDOW_WIDTH){
            paddle.moveRight();
        }
        if(aPressed && paddle.getBounds().x < 0){
            paddle.moveLeft();
        }
    }

}
