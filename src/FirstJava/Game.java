///  File writen by Sunmyoung Yun

import javax.swing.*;

import java.awt.Point;
import java.awt.Color;

import java.util.ArrayList;

public class Game 
{
    // constants 
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_HEIGHT = 500;

    // meta objects in game
    private Window window;

    // objects in game 
    private ArrayList<JComponent> entities;

    public Game()
    {
        createMetaComponents();
        createEntities();

        window.addToWindow(entities);
    }

    public void runGame()
    {
        window.showWindow();
        window.startAnimation();
    }

    // make assets 
    private void createEntities()
    {
        this.entities = new ArrayList<>();

      //  Rect rectangle2 = new Rect( 70, 20, new Point(70, 60), Color.RED, true, 3);
        Rect rectangle1 = new Rect( 50, 20, new Point(70, 60), Color.RED, true, 3);
        Ball ball1 = new Ball( 10, 10, new Point(70, 60), Color.BLUE, true, 2);
        TextEntity text1 = new TextEntity( new Point (200, 300), "Arial", 80, Color.YELLOW);

        entities.add(rectangle1);
      //  entities.add(rectangle2);
        entities.add(ball1);
        entities.add(text1);
    }

    private void createMetaComponents()
    {
        this.window = new Window( WINDOW_WIDTH, WINDOW_HEIGHT );
    }
}
