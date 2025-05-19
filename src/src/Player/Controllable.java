package Player;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controllable implements KeyListener {
    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean isSprinting;

    public Integer leftButton = KeyEvent.VK_A;
    public Integer rightButton = KeyEvent.VK_D;
    public Integer upButton = KeyEvent.VK_W;
    public Integer downButton = KeyEvent.VK_S;
    public Integer sprintButton = KeyEvent.VK_SHIFT;

    public void changeBinds(Integer left, Integer right, Integer up, Integer down, Integer sprint){
        leftButton = (left != null) ? left : KeyEvent.VK_LEFT;
        rightButton = (right != null) ? right : KeyEvent.VK_RIGHT;
        upButton = (up != null) ? up : KeyEvent.VK_UP;
        downButton = (down != null) ? down : KeyEvent.VK_DOWN;
        sprintButton = (sprint != null) ? sprint : KeyEvent.VK_SHIFT;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == leftButton) leftPressed = true;
        if (key == rightButton) rightPressed = true;
        if (key == upButton) upPressed = true;
        if (key == downButton) downPressed = true;
        if (key == sprintButton) isSprinting = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == leftButton) leftPressed = false;
        if (key == rightButton) rightPressed = false;
        if (key == upButton) upPressed = false;
        if (key == downButton) downPressed = false;
        if (key == sprintButton) isSprinting = false;
    }
}
