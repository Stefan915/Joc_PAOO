package StaticObjects;

import Interfaces.I_imageContainer;
import WindowManager.Window;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Key extends StaticObject implements I_imageContainer
{
    public Key(StaticObjectPosition pos)
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
