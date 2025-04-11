package SceneManager;

import Camera.CameraManager;
import Camera.VignetteGenerator;
import DataStructures.Vector2;
import Input.InputManager;
import Interfaces.I_imageContainer;
import Interfaces.StandardBehaviour;
import MapGeneration.*;
import Player.PlayerManager;
import Time.Time;
import WindowManager.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static java.lang.Thread.sleep;

public class GameScene extends Scene
{
    PlayerManager player = new PlayerManager();
    MapRenderer mapRenderer=new MapRenderer();

    private long valueToSleepAfterFrame;
    Double valueToSleepAfterFrame_double;
    private double FPSlimit=60;

    BufferedImage bfr;
    @Override
    public void Start() throws IOException {
        MapInfo mapInfo;
        MapGenerator generator;
        layout map;
        LayoutInfo layoutInfo;

        generator = new MapGenerator(6, 16, 3);
        generator.generateMap();
        mapInfo = generator.getMap();
        mapInfo.printMap();
        map = new layout(19, mapInfo._map, 5, 10);
        map.print();

        layoutInfo=map.getLayoutInfo();
        mapRenderer.initRenderer(layoutInfo);

        VignetteGenerator.createVignette("res/efx/v.png",1920,1080,100);
        player.position=new Vector2(layoutInfo.entrancePosition.x* Window.getTileSizeInPixels()-Window.screenSize.width/2 ,layoutInfo.entrancePosition.y*Window.getTileSizeInPixels()-Window.screenSize.height/2);
        try {
            bfr = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/efx/v.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    @Override
    public void Update() {




            Time.setStartTime();
            Time.setStartTimeDelta();


            player.Update();

            System.out.println(Time.FPS);

            Time.setEndTime();
            Time.calculateFrameTime();

            valueToSleepAfterFrame_double=((double )1/FPSlimit-Time.frameTime)*1000;
            valueToSleepAfterFrame= valueToSleepAfterFrame_double.longValue();
            if(valueToSleepAfterFrame>=0) {
                try {
                    sleep(valueToSleepAfterFrame);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            Time.setEndTimeDelta();
            Time.calculateDelta();




    }

    @Override
    public void draw(Graphics2D graphics2D) {

        mapRenderer.draw(graphics2D);
        player.draw(graphics2D,3);
        AffineTransform at = AffineTransform.getScaleInstance(1, 1);
        graphics2D.drawImage(bfr, at, null);
    }


}
