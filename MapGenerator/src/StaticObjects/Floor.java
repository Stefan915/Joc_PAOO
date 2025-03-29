package StaticObjects;

import Interfaces.I_imageContainer;
import Interfaces.StandardBehaviour;
import WindowManager.Window;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Floor extends StaticObject implements I_imageContainer {

    public Floor(StaticObjectPosition pos)
    {
        super(pos);
    }


    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(sprite,position.x* WindowManager.Window.tileSizeInPixels,position.y* WindowManager.Window.tileSizeInPixels, WindowManager.Window.tileSizeInPixels, Window.tileSizeInPixels,null);
    }

    @Override
    public void setImage(BufferedImage image)
    {
        this.sprite=image;
    }

}
