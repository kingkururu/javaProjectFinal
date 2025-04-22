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

        Rect rectangle1 = new Rect( new Point(70, 60), 50, 50 , Color.RED);
        TextEntity text1 = new TextEntity( new Point (200, 300), "Arial", 80, Color.YELLOW);

        entities.add(rectangle1);
        entities.add(text1);
    }

    private void createMetaComponents()
    {
        this.window = new Window( WINDOW_WIDTH, WINDOW_HEIGHT );
    }
}
