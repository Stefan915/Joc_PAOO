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



}
