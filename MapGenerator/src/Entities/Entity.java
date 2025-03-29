package Entities;

import DataStructures.Vector2;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Entity {
    public Vector2 position=new Vector2(0,0);

    public float animationFPS;
    public List<BufferedImage> downFrames=new ArrayList<BufferedImage>();
}
