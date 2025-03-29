package StaticObjects;

import Interfaces.I_imageContainer;
import Interfaces.StandardBehaviour;
import WindowManager.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class Wall extends StaticObject implements I_imageContainer
{

    public Wall(StaticObjectPosition pos)
    {
        super(pos);
    }


    @Override
    public void draw(Graphics2D graphics2D) {
        graphics2D.drawImage(sprite,position.x* Window.tileSizeInPixels,position.y*Window.tileSizeInPixels,Window.tileSizeInPixels,Window.tileSizeInPixels,null);
    }

    @Override
    public void setImage(BufferedImage image)
    {
        this.sprite=image;
    }

}
