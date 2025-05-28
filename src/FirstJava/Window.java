///  File writen by Sunmyoung Yun

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

public class Window
{
    private boolean visibleState;

    private JFrame frame;
    private Keyboard key;
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
        key = new Keyboard();//made by chat GPT
        frame.addKeyListener(key);//made by chat GPT
        frame.setFocusable(true);//made by chat GPT
        frame.requestFocusInWindow();//made by chat GPT
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
        paddle = (Dynamic)entities.get(0); 
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
        
        boolean dPressed = key.isRightClicked();
        boolean aPressed = key.isLeftClicked();
        if(dPressed && paddle.getBounds().x + paddle.getBounds().width < Game.WINDOW_WIDTH){
            paddle.moveRight();
        }
        if(aPressed && paddle.getBounds().x > 0){
            paddle.moveLeft();
        }
    }

}
