package Player;
import Interfaces.I_imageContainer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import Entities.Entity;
import Interfaces.StandardBehaviour;

import javax.imageio.ImageIO;

public class PlayerManager extends Entity implements I_imageContainer, StandardBehaviour
{
    public PlayerManager()
    {
        loadImages();
    }

    @Override
    public void Start() {

    }

    @Override
    public void Update() {

    }




    public void loadImages()
    {
        try
        {
            downFrames.add(ImageIO.read(getClass().getResourceAsStream("/Player/frame.png")));
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D)
    {
        BufferedImage currentFrame;
        currentFrame=downFrames.get(0);

        graphics2D.drawImage(currentFrame,100,100,100,100,null);
    }


}
