package WindowManager;

import Input.InputManager;
import Interfaces.StandardBehaviour;

import javax.swing.*;
import java.awt.*;

public class Window
{
    public static Window instance;
    public JFrame window;
    static public Dimension screenSize;
    Thread gameThread;
    public boolean gameIsRunning=true;
    gamePanel panel;
    static private int tileSizeInPixels=70;

    Color backgroundColor=new Color(255,255,255);

    public void initWindow(String nume)
    {
        instance = this;
        panel=new gamePanel();

        window=new JFrame(nume);

        window.setTitle(nume);
        window.setResizable(false);

        //ca sa fie full screen
        window.setExtendedState(Frame.MAXIMIZED_BOTH);
        window.setUndecorated(true);

        //setare rezolutie fereastra la rezolutia ecranului
        screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        window.setPreferredSize(screenSize);

        //adauagare listener de key press
        window.addKeyListener(InputManager.instance);
        window.setFocusable(true);



        window.add(panel);

        panel.setBackground(backgroundColor);

        //aplicare setari
        //window.pack();

        //activare fereastra
        //window.setVisible(true);
    }


    public void startThread()
    {
        gameThread=new Thread(panel);
        gameThread.start();
    }

    static public int getTileSizeInPixels()
    {
        Double doubleValue;
        doubleValue=tileSizeInPixels*(screenSize.height/1080.0);
        return doubleValue.intValue();
    }
}
