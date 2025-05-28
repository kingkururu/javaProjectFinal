import java.awt.*;
import java.util.ArrayList;

public class Dynamic extends Shape {
    private int direction;
    private ArrayList<Shape> collisions;
    public Dynamic(int width, int height) {
        super(width, height);
        initializeComponent(width, height);
    }

    public Dynamic(int width, int height, Point position, Color color, boolean moveState, int speed, int direction, ArrayList<Shape> collisions) {
        super(width, height, position, color, moveState, speed);
        initializeComponent(width, height);
        this.direction = direction;
        this.collisions = collisions;
    }

    private void initializeComponent(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setOpaque(false); // Prevent background from being painted
    }

    public void moveDirection() {
        if (getMoveState()) {
            int dx = (int) (getSpeed() * Math.cos(Math.toRadians(direction)));
            int dy = (int) (getSpeed() * Math.sin(Math.toRadians(direction)));
            setLocation(getX() + dx, getY() + dy);
        }
        collisionDetection();
    }

    public void collisionDetection() {
        int x = getX();
        int y = getY();
        // for (Shape shape : collisions) {
        //     if (shape != this){
        //         if((shape.getBounds().y >= y && shape.getBounds().y <= shape.getHeight() + y) || (shape.getBounds().y + shape.getBounds().height >= y && shape.getBounds().y + shape.getBounds().height <= shape.getHeight() + y)){
        //             System.out.println(shape);
        //             if((shape.getBounds().x + shape.getBounds().width <= x) || (shape.getBounds().x >= x + getWidth())){
        //                 System.out.println("fuck");
        //                 direction = (180 - direction) % 360;
        //                 //Side collision
        //             }
        //         }
        //     }
        // }
        if(x < 0){
            direction = (180 - direction) % 360;
            System.out.println("left");
        }
        else if(x+getWidth() > Game.WINDOW_WIDTH){
            System.out.println("right");
            direction = (180 - direction) % 360;
        }
        else if(y < 0){
            System.out.println("down");
            direction = (360 - direction) % 360;
            //condition for touch ground
            //put game over here
        }
        else if(y+getHeight() > Game.WINDOW_HEIGHT){
            System.out.println("up");
            direction = (360 - direction) % 360;
        }
    }
}