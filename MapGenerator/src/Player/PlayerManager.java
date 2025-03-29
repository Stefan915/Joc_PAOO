package Player;
import Camera.CameraManager;
import Input.InputManager;
import Interfaces.I_imageContainer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import Entities.Entity;
import Interfaces.StandardBehaviour;
import Time.Time;
import WindowManager.Window;

import javax.imageio.ImageIO;

public class PlayerManager extends Entity implements I_imageContainer, StandardBehaviour
{
    private float movementSpeed=6;



    public PlayerManager()
    {
        loadImages();
    }

    @Override
    public void Start() {

    }

    @Override
    public void Update() {

        if(InputManager.upPressed)
        {
            position.y-=Window.tileSizeInPixels*movementSpeed* Time.deltaTime;
        }
        if(InputManager.downPressed)
        {
            position.y+=Window.tileSizeInPixels*movementSpeed* Time.deltaTime;
        }
        if(InputManager.leftPressed)
        {
            position.x-=Window.tileSizeInPixels*movementSpeed* Time.deltaTime;
        }
        if(InputManager.rightPressed)
        {
            position.x+=Window.tileSizeInPixels*movementSpeed* Time.deltaTime;
        }

        CameraManager.position=position;
    }

    public void loadImages()
    {
        try
        {
            downFrames.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/player.png"))));
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public void draw(Graphics2D graphics2D)
    {
        BufferedImage currentFrame;
        graphics2D.drawImage(downFrames.getFirst(), Window.screenSize.width/2-Window.tileSizeInPixels/2,Window.screenSize.height/2-Window.tileSizeInPixels/2,Window.tileSizeInPixels,Window.tileSizeInPixels,null);
    }
}
