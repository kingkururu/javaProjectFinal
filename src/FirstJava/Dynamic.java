///  File writen by Chaeyun
/// 
import java.awt.*;

public class Dynamic extends Shape {
    private int direction;
    private Static paddle;
    private TextEntity gameOver;
    public Dynamic(int width, int height) {
        super(width, height);
        initializeComponent(width, height);
    }

    public Dynamic(int width, int height, Point position, Color color, boolean moveState, int speed, int direction, Static paddle, TextEntity gameOver) {
        super(width, height, position, color, moveState, speed);
        initializeComponent(width, height);
        this.direction = direction;
        this.paddle = paddle;
        this.gameOver = gameOver;
    }

    private void initializeComponent(int width, int height) {
        setPreferredSize(new Dimension(width, height));
        setOpaque(false); // Prevent background from being painted
    }

    public void moveDirection() {
        if (getMoveState()) {
            //Chat GPT: I have direction variable in degree in int type. I want to use the setLocation, getSpeed, and getX, getY methods to move the object in the direction of the angle with the speed. Everything is in int type except for angle. Write in 4 lines.
            //https://chatgpt.com/c/683d0a9c-3e30-800b-8cb9-5e7d3d4cec8c
            double rad = Math.toRadians(direction);
            int dx = (int)(Math.cos(rad) * getSpeed());
            int dy = (int)(Math.sin(rad) * getSpeed());
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
                    setSpeed(getSpeed() + 1);
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
            direction = (360 - direction) % 360;
            gameOver.setPosition(new Point (70, 100));
            setMoveState(false);
        }
    }
}