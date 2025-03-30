package Player;
import Camera.CameraManager;
import Entities.entityAnimations;
import Input.InputManager;
import Interfaces.I_imageContainer;

import java.awt.*;
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
        super.Update();

        super.setAnimation(entityAnimations.IDLE);
        if(InputManager.upPressed)
        {
            position.y-=Window.getTileSizeInPixels()*movementSpeed* Time.deltaTime;
            super.setAnimation(entityAnimations.MOVING);
        }
        if(InputManager.downPressed)
        {
            position.y+=Window.getTileSizeInPixels()*movementSpeed* Time.deltaTime;
            super.setAnimation(entityAnimations.MOVING);
        }
        if(InputManager.leftPressed)
        {
            position.x-=Window.getTileSizeInPixels()*movementSpeed* Time.deltaTime;
            super.setAnimation(entityAnimations.MOVING);
            flipped=true;
        }
        if(InputManager.rightPressed)
        {
            position.x+=Window.getTileSizeInPixels()*movementSpeed* Time.deltaTime;
            super.setAnimation(entityAnimations.MOVING);
            flipped=false;
        }


        CameraManager.position=position;
    }

    public void loadImages()
    {
        try
        {

            //load run right
            for(int i=1;i<=5;i++)
            {
                movingFrames.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/RunRight/run"+i+".png"))));
            }


            //load run left
            for(int i=1;i<=5;i++)
            {
                idleFrames.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/Idle/idle"+i+".png"))));
            }


        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }

}
