///  File writen by Sunmyoung and Chaeyun

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import javax.swing.*;

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
        TextEntity gameOver = new TextEntity( new Point (1000, 90), "Game Over :(", 50, Color.BLACK);

        Static paddle = new Static( 70, 10, new Point(70, WINDOW_HEIGHT - 100), Color.RED, true, 10);
        Dynamic ball1 = new Ball( 20, 20, new Point(200, 60), Color.BLUE, true, 7, 45, paddle, gameOver);
        TextEntity text1 = new TextEntity( new Point (70, 50), "Pong Game!!!", 50, Color.BLACK);
        Static floor = new Static( WINDOW_WIDTH, 100, new Point(0, WINDOW_HEIGHT), Color.BLACK, false, 0);
        Static rightWall = new Static( 100, WINDOW_HEIGHT, new Point(WINDOW_WIDTH,0), Color.BLACK, false, 0);


        entities.add(paddle);
        entities.add(floor);
        entities.add(rightWall);
        entities.add(ball1);
        entities.add(text1);
        entities.add(gameOver);
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
