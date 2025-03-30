package SceneManager;

import ButtonManager.ButtonManager;
import DataStructures.Vector2;
import WindowManager.Window;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuScene extends Scene{

    ButtonManager playButton =new ButtonManager("PLAY ",new Vector2((float)Window.screenSize.width/2,(float)Window.screenSize.height/2),new Vector2(100,100),100,120);
    @Override
    public void Start() throws IOException {

    }

    @Override
    public void Update() {
        playButton.Update();
    }

    @Override
    public void loadImages() throws IOException {
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        playButton.draw(graphics2D);
    }

}
