///  File writen by Chaeyun

import java.awt.*;
import java.util.ArrayList;

public class Dynamic extends Shape {
    private int direction;
    private Static paddle;
    public Dynamic(int width, int height) {
        super(width, height);
        initializeComponent(width, height);
    }

    public Dynamic(int width, int height, Point position, Color color, boolean moveState, int speed, int direction, Static paddle) {
        super(width, height, position, color, moveState, speed);
        initializeComponent(width, height);
        this.direction = direction;
        this.paddle = paddle;
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

       if(paddle.getY() < y + getHeight()){
           if(!(paddle.getBounds().x + paddle.getBounds().width <= x) && !(paddle.getBounds().x >= x + getWidth())){
                   direction = (360 - direction) % 360;
                   setSpeed(getSpeed() + 10);
           }

       }
      
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