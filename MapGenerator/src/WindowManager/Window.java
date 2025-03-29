package WindowManager;

import Interfaces.StandardBehaviour;

import javax.swing.*;
import java.awt.*;

public class Window
{
    JFrame window;
    Dimension screenSize;
    Thread gameThread;
    public boolean gameIsRunning=true;
    gamePanel panel;

    public void initWindow(String nume)
    {
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

        window.add(panel);

        //aplicare setari
        window.pack();

        //activare fereastra
        window.setVisible(true);
    }


    public void startThread()
    {
        gameThread=new Thread(panel);
        gameThread.start();
    }
}
