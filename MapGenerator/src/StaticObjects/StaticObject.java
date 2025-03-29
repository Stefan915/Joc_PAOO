package StaticObjects;

import java.awt.image.BufferedImage;

public class StaticObject {
    public BufferedImage sprite;
    StaticObjectPosition position;

    public StaticObject(StaticObjectPosition newPos)
    {
        position=newPos;
    }
}
