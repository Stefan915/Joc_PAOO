package MapGeneration;

import Interfaces.I_imageContainer;
import Mathf.Rand;
import StaticObjects.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MapRenderer implements I_imageContainer
{
    LayoutInfo layoutInfo;
    BufferedImage wall_up_left_right;
    BufferedImage floorSprite;
    BufferedImage doorSprite;
    BufferedImage chestSprite;
    BufferedImage keySprite;
    BufferedImage exitSprite;

    BufferedImage wallRightSprite;
    BufferedImage wallLeftSprite;
    BufferedImage wallUpSprite;
    BufferedImage wallDownSprite;
    BufferedImage wallCornerOuterDownLeft;
    BufferedImage wallCornerOuterDownRight;
    BufferedImage wallCornerInnerDownLeft;
    BufferedImage wallCornerInnerDownRight;
    List<BufferedImage> floorsSprites=new ArrayList<BufferedImage>();
    BufferedImage doorUpSprite;
    BufferedImage doorLeftSprite;


    private final List<Wall> walls=new ArrayList<Wall>();
    private final List<Floor> floors=new ArrayList<Floor>();
    private final List<Door> doors=new ArrayList<Door>();
    private final List<Chest> chests=new ArrayList<Chest>();
    private Key key=new Key(new StaticObjectPosition(0,0));
    private Exit exit=new Exit(new StaticObjectPosition(0,0));




    public void initRenderer(LayoutInfo newLayoutInfo) throws IOException {
        layoutInfo=newLayoutInfo;
        loadImages();
        for(int i=0;i<layoutInfo.layOut.length;i++)
        {
            for(int j=0;j<layoutInfo.layOut.length;j++)
            {
                extendedRoomTypes current;

                current=layoutInfo.layOut[i][j];

                if(current==extendedRoomTypes.WALLR)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallRightSprite);
                    walls.add(newWall);
                }

                if(current==extendedRoomTypes.WALLL)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallLeftSprite);
                    walls.add(newWall);
                }
                if(current==extendedRoomTypes.WALLU)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallUpSprite);
                    walls.add(newWall);
                }
                if(current==extendedRoomTypes.WALLD)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallDownSprite);
                    walls.add(newWall);
                }
                if(current==extendedRoomTypes.WALLCODL)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallCornerOuterDownLeft);
                    walls.add(newWall);
                }

                if(current==extendedRoomTypes.WALLCOUL)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallUpSprite);
                    walls.add(newWall);
                }

                if(current==extendedRoomTypes.WALLCODR)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallCornerOuterDownRight);
                    walls.add(newWall);
                }

                if(current==extendedRoomTypes.WALLCOUR)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallUpSprite);
                    walls.add(newWall);
                }

                if(current==extendedRoomTypes.WALLCIDL)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallCornerInnerDownLeft);
                    walls.add(newWall);
                }

                if(current==extendedRoomTypes.WALLCIDR)
                {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wallCornerInnerDownRight);
                    walls.add(newWall);
                }


                if(current==extendedRoomTypes.DOORORIZONTAL)
                {
                    Door newDoor;
                    newDoor=new Door(new StaticObjectPosition(j, i));
                    newDoor.setImage(doorUpSprite);
                    doors.add(newDoor);
                }

                if(current==extendedRoomTypes.DOORVERTICAL)
                {
                    Door newDoor;
                    newDoor=new Door(new StaticObjectPosition(j, i));
                    newDoor.setImage(doorLeftSprite);
                    doors.add(newDoor);
                }



                if(current==extendedRoomTypes.CHEST)
                {
                    Chest newChest;
                    newChest=new Chest(new StaticObjectPosition(j, i));
                    newChest.setImage(chestSprite);
                    chests.add(newChest);
                }

                if(current==extendedRoomTypes.KEY)
                {
                    System.out.println("got the key");
                    key=new Key(new StaticObjectPosition(j, i));
                    key.setImage(keySprite);
                }

                if(current==extendedRoomTypes.EXIT)
                {
                    exit=new Exit(new StaticObjectPosition(j, i));
                    exit.setImage(exitSprite);
                }

                current=layoutInfo.floorLayout[i][j];

                if(current==extendedRoomTypes.FLOOR)
                {
                    Floor newFloor;
                    newFloor=new Floor(new StaticObjectPosition(j, i));
                    newFloor.setImage(floorsSprites.get(Rand.Range(0,floorsSprites.size())));
                    floors.add(newFloor);
                }

            }
        }
    }


    @Override
    public void loadImages() throws IOException {
        doorSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/door.png")));
        chestSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/chest.png")));
        keySprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/key.png")));
        exitSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Player/exit.png")));

        wallUpSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallUp.png")));
        wallDownSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallDown.png")));
        wallRightSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallLeft.png")));
        wallLeftSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallRight.png")));
        wallCornerOuterDownLeft=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallCornerOuterDownLeft.png")));
        wallCornerOuterDownRight=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallCornerOuterDownRight.png")));
        wallCornerInnerDownLeft=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallCornerInnerDownLeft.png")));
        wallCornerInnerDownRight=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Walls/wallCornerInnerDownRight.png")));

        doorUpSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Doors/doorUp.png")));
        doorLeftSprite=ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Doors/doorLeft.png")));

        for(int i = 1; i<=6; i++)
        {
            System.out.println("/Walls/floor"+ Integer.toString(i) +".png");
            floorsSprites.add(ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/Floors/floor" + Integer.toString(i) + ".png"))));
        }
    }

    @Override
    public void draw(Graphics2D graphics2D) {

        for(Floor floor:floors)
        {
            floor.draw(graphics2D);
        }

        for(Wall wall:walls)
        {
            wall.draw(graphics2D);
        }

        for(Door door:doors)
        {
            door.draw(graphics2D);
        }

        for(Chest chest:chests)
        {
            chest.draw(graphics2D);
        }

        key.draw(graphics2D);
        exit.draw(graphics2D);
    }

    private StaticObject getStaticObject(int y, int x) {
        BufferedImage tileImage = switch (layoutInfo.layOut[y][x]) {
            case WALL -> wall_up_left_right;
            case FLOOR -> floorSprite;
            case DOOR -> doorSprite;
            case CHEST -> chestSprite;
            case KEY -> keySprite;
            case EXIT -> exitSprite;
            default -> null;
        };
        StaticObject obj = new StaticObject(new StaticObjectPosition(x, y));
        obj.setImage(tileImage);
        return obj;
    }
}
