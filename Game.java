import java.util.ArrayList;
import javax.swing.*;

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
        drawWindow();
    }

    private void drawWindow()
    {
        window.showWindow();
    }

    private void createEntities()
    {
        Rect rectangle1 = new Rect( 50, 50 );

        this.entities = new ArrayList<>();
        entities.add(rectangle1);
    }

    private void createMetaComponents()
    {
        this.window = new Window( WINDOW_WIDTH, WINDOW_HEIGHT );
    }
}
