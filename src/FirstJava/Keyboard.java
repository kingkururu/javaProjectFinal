import java.awt.event.*;
import javax.swing.JFrame;
// Written by Jaeho
public class Keyboard extends JFrame implements KeyListener {
    private boolean leftClick = false;
    private boolean rightClick = false;
    private boolean spaceClick = false;
    public boolean isLeftClicked(){
        return leftClick;
    }
    public boolean isRightClicked(){
        return rightClick;
    }
    public boolean isSpaceClicked(){
        return spaceClick;
    }
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            leftClick = true;
            //System.out.println("Left Pressed");
        }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rightClick = true;
            //System.out.println("Right Pressed");
        }

        if (key == KeyEvent.VK_SPACE) {
            spaceClick = true;
        }
    }//written by GPT(best friend)
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            leftClick = false;
            //System.out.println("Left released");
        }

        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rightClick = false;
            //System.out.println("Right released");
        }

        if (key == KeyEvent.VK_SPACE) {
            spaceClick = false;
        }
    }
    public void keyTyped(KeyEvent e) {
        //written by GPT
    }
}
