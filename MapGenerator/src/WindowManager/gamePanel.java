package WindowManager;

import Player.PlayerManager;

import javax.swing.*;
import java.awt.*;

public class gamePanel extends JPanel implements Runnable {

    public boolean gameIsRunning=true;

    PlayerManager player=new PlayerManager();

    @Override
    public void run() {
        while(gameIsRunning)
        {
            Update();
            repaint();
        }
    }

    public void Update()
    {
        player.Update();
    }



    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);
        Graphics2D graphics2D =(Graphics2D) graphics;

        player.draw(graphics2D);

        graphics2D.dispose();
    }




}
