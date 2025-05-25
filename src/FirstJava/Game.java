///  File writen by Sunmyoung Yun

import javax.swing.*;

import java.awt.Point;
import java.lang.reflect.Array;
import java.awt.Color;

import java.util.ArrayList;

public class Game 
{
    // constants 
    public static final int WINDOW_WIDTH = 500;
    public static final int WINDOW_HEIGHT = 700;

    // meta objects in game
    private Window window;

    // objects in game 
    private ArrayList<JComponent> entities;
    private ArrayList<Shape> collisions;
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
        this.collisions = new ArrayList<>();
        System.out.println("Creating entities...");
      //  Rect rectangle2 = new Rect( 70, 20, new Point(70, 60), Color.RED, true, 3);
        Dynamic paddle = new Dynamic( 50, 20, new Point(70, WINDOW_HEIGHT - 100), Color.RED, true, 3, 0, collisions);
        Dynamic ball1 = new Dynamic( 50, 50, new Point(200, 60), Color.BLUE, true, 5, 45, collisions);
        TextEntity text1 = new TextEntity( new Point (200, 300), "Arial", 80, Color.YELLOW);
        Static floor = new Static( WINDOW_WIDTH, 100, new Point(0, WINDOW_HEIGHT), Color.BLACK, false, 0);
        Static rightWall = new Static( 100, WINDOW_HEIGHT, new Point(WINDOW_WIDTH,0), Color.BLACK, false, 0);
        
        entities.add(paddle);
        entities.add(floor);
        entities.add(rightWall);
        entities.add(ball1);
        entities.add(text1);    
        collisions.add(paddle);
        collisions.add(floor);
        collisions.add(rightWall);
        collisions.add(ball1);
    }

    private void createMetaComponents()
    {
        this.window = new Window();
    }
}
