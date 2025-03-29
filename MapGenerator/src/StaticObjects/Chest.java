package StaticObjects;

import Interfaces.I_imageContainer;
import WindowManager.Window;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Chest extends StaticObject implements I_imageContainer {
    public Chest(StaticObjectPosition pos) {
        super(pos);
    }

}
