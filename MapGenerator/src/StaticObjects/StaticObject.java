package StaticObjects;

import Camera.CameraManager;
import Interfaces.I_imageContainer;
import WindowManager.Window;

import java.awt.*;
import java.awt.image.BufferedImage;

public class StaticObject implements I_imageContainer {
    public BufferedImage sprite;
    StaticObjectPosition position;

    public StaticObject(StaticObjectPosition newPos)
    {
        position=newPos;
    }
    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(sprite,position.x* Window.getTileSizeInPixels()- (int)CameraManager.position.x,position.y*Window.getTileSizeInPixels()-(int)CameraManager.position.y,Window.getTileSizeInPixels(),Window.getTileSizeInPixels(),null);
    }

    @Override
    public void setImage(BufferedImage image)
    {
        this.sprite=image;
    }


}
