package SceneManager;

import Camera.CameraManager;
import DataStructures.Vector2;
import Input.InputManager;
import Interfaces.I_imageContainer;
import Interfaces.StandardBehaviour;
import MapGeneration.*;
import Player.PlayerManager;
import Time.Time;
import WindowManager.Window;

import java.awt.*;
import java.io.IOException;

import static java.lang.Thread.sleep;

public class GameScene extends Scene
{
    PlayerManager player = new PlayerManager();
    MapRenderer mapRenderer=new MapRenderer();

    private long valueToSleepAfterFrame;
    Double valueToSleepAfterFrame_double;
    private double FPSlimit=60;


    @Override
    public void Start() throws IOException {
        MapInfo mapInfo;
        MapGenerator generator;
        layout map;
        LayoutInfo layoutInfo;

        generator = new MapGenerator(6, 10, 2);
        generator.generateMap();
        mapInfo = generator.getMap();
        mapInfo.printMap();
        map = new layout(19, mapInfo._map, 2, 5);
        map.print();

        layoutInfo=map.getLayoutInfo();
        mapRenderer.initRenderer(layoutInfo);

        player.position=new Vector2(layoutInfo.entrancePosition.x* Window.getTileSizeInPixels()-Window.screenSize.width/2 ,layoutInfo.entrancePosition.y*Window.getTileSizeInPixels()-Window.screenSize.height/2);


    }



    @Override
    public void Update() {




            Time.setStartTime();
            Time.setStartTimeDelta();


            player.Update();

            //System.out.println(Time.FPS);

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
        player.draw(graphics2D);
    }


}
