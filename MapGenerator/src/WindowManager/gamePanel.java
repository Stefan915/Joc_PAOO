package WindowManager;

import Input.InputManager;
import SceneManager.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import SceneManager.ScenesManager;

public class gamePanel extends JPanel implements Runnable {

    private BufferedImage bfr;
    InputManager inputManager = new InputManager();
    public boolean gameIsRunning = true;

    @Override
    public void run() {

        try {
            Start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while(gameIsRunning) {
            try {
                Update();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            repaint();
        }
    }

    public void Start() throws IOException {
        ScenesManager.instance.setCurrentActiveScene(allScenes.MENU);
    }

    public void Update() throws IOException {

        ScenesManager.instance.runCurrentScene();
        inputManager.Update();
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        ScenesManager.instance.renderCurrentScene(graphics2D);

        graphics2D.dispose();
    }
}
