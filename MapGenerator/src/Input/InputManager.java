package Input;

import DataStructures.Vector2;
import Interfaces.StandardBehaviour;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Vector;

public class    InputManager implements KeyListener, StandardBehaviour, MouseListener, MouseMotionListener, MouseWheelListener
{
    static public boolean upPressed;
    static public boolean downPressed;
    static public boolean leftPressed;
    static public boolean rightPressed;
    static public boolean mouseClicked;
    static public boolean mouseReleased;
    static public boolean mouseHold;
    static public InputManager instance=new InputManager();
    static public Vector2 mousePosition=new Vector2(0,0);


    @Override
    public void keyTyped(KeyEvent event) {

    }

    @Override
    public void keyPressed(KeyEvent event) {
        int keyCode;

        keyCode=event.getKeyCode();

        switch(keyCode)
        {
            case KeyEvent.VK_W:
            {
                upPressed=true;
                break;
            }
            case KeyEvent.VK_A:
            {
                leftPressed=true;
                break;
            }
            case KeyEvent.VK_S:
            {
                downPressed=true;
                break;
            }
            case KeyEvent.VK_D:
            {
                rightPressed=true;
                break;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent event) {
        int keyCode;

        keyCode=event.getKeyCode();

        switch(keyCode)
        {
            case KeyEvent.VK_W:
            {
                upPressed=false;
                break;
            }
            case KeyEvent.VK_A:
            {
                leftPressed=false;
                break;
            }
            case KeyEvent.VK_S:
            {
                downPressed=false;
                break;
            }
            case KeyEvent.VK_D:
            {
                rightPressed=false;
                break;
            }
        }
    }
    public void Update()
    {
        PointerInfo mouseInfo;
        mouseInfo=MouseInfo.getPointerInfo();
        mousePosition.x=mouseInfo.getLocation().getX();
        mousePosition.y=mouseInfo.getLocation().getY();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!mouseClicked) { // Prevent double setting
            mouseClicked = true;
            System.out.println("Mouse clicked");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mouseHold=true;
        mouseReleased=false;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseHold=false;
        mouseClicked=false;
        mouseReleased=true;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

    }
}
