package StaticObjects;

import Interfaces.I_imageContainer;
import WindowManager.Window;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Door extends StaticObject implements I_imageContainer {

    public Door(StaticObjectPosition pos)
    {
        super(pos);
    }


}
