package WindowManager;

import Camera.CameraManager;
import Camera.VignetteGenerator;
import DataStructures.Vector2;
import Input.InputManager;
import Interfaces.StandardBehaviour;
import MapGeneration.*;
import Player.PlayerManager;
import SceneManager.*;
import Time.Time;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

import static java.lang.Thread.sleep;
import SceneManager.ScenesManager;








public class gamePanel extends JPanel implements Runnable {


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
        VignetteGenerator.createVignette("v.png",Window.screenSize.width,Window.screenSize.height, 30);
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
        VignetteGenerator vGen = new VignetteGenerator();
        graphics2D.dispose();
    }
}
