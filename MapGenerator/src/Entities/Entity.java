package Entities;

import DataStructures.Vector2;
import Interfaces.I_imageContainer;
import Interfaces.StandardBehaviour;
import Time.Time;
import WindowManager.Window;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class Entity implements StandardBehaviour, I_imageContainer {
    public Vector2 position=new Vector2(0,0);
    private entityAnimations currentAnimation=entityAnimations.DOWN;
    public float animationFPS;
    private float timerPerFrame=0.2f;
    private float animationTimer;



    final private double waitForFlipTime=1;
    private double WaitForFlipTimer;



    private boolean finalFlipped;
    protected boolean flipped;

    public List<BufferedImage> movingFrames=new ArrayList<BufferedImage>();
    public List<BufferedImage> idleFrames=new ArrayList<BufferedImage>();

    private BufferedImage currentSprite;
    int currentFrame=0;

    protected void setAnimation(entityAnimations animation)
    {
        currentAnimation=animation;
    }

    @Override
    public void Update()
    {
        WaitForFlipTimer-=Time.deltaTime;
        if(flipped)
        {
            WaitForFlipTimer=waitForFlipTime;
        }
        if(WaitForFlipTimer<=0 && flipped==false)
        {
            finalFlipped=false;
        }

        if(flipped)
        {
            finalFlipped=true;
        }


        animationTimer-= Time.deltaTime;
        if(animationTimer<=0)
        {
            animationTimer=timerPerFrame;
            currentFrame++;
        }
        switch (currentAnimation)
        {
            case MOVING:
            {
                currentFrame=currentFrame%movingFrames.size();
                currentSprite=movingFrames.get(currentFrame);
                break;
            }
            case IDLE:
            {
                currentFrame=currentFrame%idleFrames.size();
                currentSprite=idleFrames.get(currentFrame);
                break;
            }
        }
    }

    public void draw(Graphics2D graphics2D,float size)
    {
        if(finalFlipped) {
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-currentSprite.getHeight(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            currentSprite = op.filter(currentSprite, null);
        }

        graphics2D.drawImage(currentSprite, WindowManager.Window.screenSize.width/2- (int)(WindowManager.Window.getTileSizeInPixels()/2*size), WindowManager.Window.screenSize.height/2- (int)(WindowManager.Window.getTileSizeInPixels()/2*size), (int)(WindowManager.Window.getTileSizeInPixels()*size), (int)(Window.getTileSizeInPixels()*size),null);
    }


}
