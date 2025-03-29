package Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener
{
    static public boolean upPressed;
    static public boolean downPressed;
    static public boolean leftPressed;
    static public boolean rightPressed;


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
}
