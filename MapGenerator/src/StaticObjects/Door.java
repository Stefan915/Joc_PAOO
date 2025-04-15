package StaticObjects;

import Camera.CameraManager;
import DataStructures.Vector2;
import Interfaces.I_imageContainer;
import WindowManager.Window;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends StaticObject implements I_imageContainer {

    boolean isOpened=true;
    public Door(StaticObjectPosition pos)
    {
        super(pos);
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        if (position.x * Window.getTileSizeInPixels()>= CameraManager.position.x-200 && position.x* Window.getTileSizeInPixels()<=CameraManager.position.x +Window.screenSize.width+100 &&
                position.y * Window.getTileSizeInPixels()>= CameraManager.position.y-200 && position.y * Window.getTileSizeInPixels()<=CameraManager.position.y +Window.screenSize.height+100
        ) {
            if(isOpened==false)
                graphics2D.drawImage(sprite, position.x * Window.getTileSizeInPixels() - (int) CameraManager.position.x, position.y * Window.getTileSizeInPixels() - (int) CameraManager.position.y, Window.getTileSizeInPixels(), Window.getTileSizeInPixels(), null);
        }
    }


}
