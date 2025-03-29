package WindowManager;

import Camera.CameraManager;
import DataStructures.Vector2;
import Input.InputManager;
import MapGeneration.*;
import Player.PlayerManager;
import Time.Time;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gamePanel extends JPanel implements Runnable {

    CameraManager camera=new CameraManager();
    public boolean gameIsRunning = true;
    PlayerManager player = new PlayerManager();
    MapRenderer mapRenderer=new MapRenderer();
    InputManager inputManager = new InputManager();
    @Override
    public void run() {

        try {
            Start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        while (gameIsRunning) {
            Time.setStartTime();

            Update();
            repaint();
            Time.setEndTime();
            Time.calculateDelta();
        }
    }

    public void Start() throws IOException {
        MapInfo mapInfo;
        MapGenerator generator;
        layout map;
        LayoutInfo layoutInfo;

        generator = new MapGenerator(6, 10, 2);
        generator.generateMap();
        mapInfo = generator.getMap();
        mapInfo.printMap();
        map = new layout(17, mapInfo._map, 2, 5);
        map.print();

        layoutInfo=map.getLayoutInfo();
        mapRenderer.initRenderer(layoutInfo);

        player.position=new Vector2(layoutInfo.entrancePosition.x*Window.tileSizeInPixels-Window.screenSize.width/2,layoutInfo.entrancePosition.y*Window.tileSizeInPixels-Window.screenSize.height/2);

    }

    public void Update() {
        player.Update();
        camera.Update();
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        mapRenderer.draw(graphics2D);
        player.draw(graphics2D);

        graphics2D.dispose();
    }
}
