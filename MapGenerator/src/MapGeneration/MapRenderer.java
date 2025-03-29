package MapGeneration;

import Camera.CameraManager;
import Interfaces.I_imageContainer;
import StaticObjects.*;
import WindowManager.Window;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MapRenderer implements I_imageContainer
{
    LayoutInfo layoutInfo;
    BufferedImage wall_up_left_right;
    BufferedImage floorSprite;
    BufferedImage doorSprite;
    BufferedImage chestSprite;
    BufferedImage keySprite;
    BufferedImage exitSprite;


    private List<Wall> walls=new ArrayList<Wall>();
    private List<Floor> floors=new ArrayList<Floor>();
    private List<Door> doors=new ArrayList<Door>();
    private List<Chest> chests=new ArrayList<Chest>();
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
                extendedRoomTypes left;
                extendedRoomTypes up;
                extendedRoomTypes right;
                extendedRoomTypes down;

                current=layoutInfo.layOut[i][j];

                if(current==extendedRoomTypes.WALL) {
                    Wall newWall;
                    newWall = new Wall(new StaticObjectPosition(j, i));
                    newWall.setImage(wall_up_left_right);
                    walls.add(newWall);
                }

                if(current==extendedRoomTypes.DOOR)
                {
                    Door newDoor;
                    newDoor=new Door(new StaticObjectPosition(j, i));
                    newDoor.setImage(doorSprite);
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
                    newFloor.setImage(floorSprite);
                    floors.add(newFloor);
                }

            }
        }
    }


    @Override
    public void loadImages() throws IOException {
        wall_up_left_right = ImageIO.read(getClass().getResourceAsStream("/Player/wall.png"));
        floorSprite=ImageIO.read(getClass().getResourceAsStream("/Player/floor.png"));
        doorSprite=ImageIO.read(getClass().getResourceAsStream("/Player/door.png"));
        chestSprite=ImageIO.read(getClass().getResourceAsStream("/Player/chest.png"));
        keySprite=ImageIO.read(getClass().getResourceAsStream("/Player/key.png"));
        exitSprite=ImageIO.read(getClass().getResourceAsStream("/Player/exit.png"));
    }

    @Override
    public void draw(Graphics2D graphics2D) {

//        for(Floor floor:floors)
//        {
//            floor.draw(graphics2D);
//        }
//
//        for(Wall wall:walls)
//        {
//            wall.draw(graphics2D);
//        }
//
//        for(Door door:doors)
//        {
//            door.draw(graphics2D);
//        }
//
//        for(Chest chest:chests)
//        {
//            chest.draw(graphics2D);
//        }
        for (int y = layoutInfo.layOut.length - 1; y >= 0; y--) {
            for (int x = layoutInfo.layOut.length - 1; x >= 0; x--) {
                BufferedImage tileImage = floorSprite;
                if(layoutInfo.floorLayout[y][x] == extendedRoomTypes.FLOOR){
                    StaticObject obj = new StaticObject(new StaticObjectPosition(x,y));
                    obj.setImage(tileImage);
                    obj.draw(graphics2D);
                }
            }
        }
        for (int y = layoutInfo.layOut.length - 1; y >= 0; y--) {
            for (int x = layoutInfo.layOut.length - 1; x >= 0; x--) {
                StaticObject obj = getStaticObject(y, x);
                obj.draw(graphics2D);
            }
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
