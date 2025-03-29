package Interfaces;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public interface I_imageContainer
{
    default public void loadImages() throws IOException {

    }
    default public void draw(Graphics2D graphics2D)
    {

    }

    default public void setImage(BufferedImage image)
    {

    }
}
