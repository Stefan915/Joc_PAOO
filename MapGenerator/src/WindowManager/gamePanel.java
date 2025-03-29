package WindowManager;

import MapGeneration.*;
import Player.PlayerManager;
import Time.Time;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class gamePanel extends JPanel implements Runnable {

    public boolean gameIsRunning = true;
    PlayerManager player = new PlayerManager();
    MapRenderer mapRenderer=new MapRenderer();

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
            System.out.println(Time.FPS);
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
        map = new layout(14, mapInfo._map, 2, 5);
        map.print();

        layoutInfo=map.getLayoutInfo();
        mapRenderer.initRenderer(layoutInfo);
    }

    public void Update() {
        player.Update();
    }


    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;

        player.draw(graphics2D);
        mapRenderer.draw(graphics2D);

        graphics2D.dispose();
    }


}
