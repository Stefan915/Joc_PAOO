import java.util.ArrayList;
import java.util.List;
import java.util.Random;



enum roomTypes
{
    NOTHING,
    EMPTY,
    ENTRANCE,
    EXIT,
    KEY,
    CHEST
}


public class MapGenerator
{
    MapInfo mapInfo=new MapInfo();
    int roomsCount;
    int chestsCount;
    public MapGenerator(int size,int roomsCount,int chestsCount)
    {
        mapInfo.size=size;
        mapInfo.totalRoomsCount=roomsCount;
        mapInfo.totalChestsCount=chestsCount;

        this.roomsCount=roomsCount;
        this.chestsCount=chestsCount;
    }

    public void generateMap()
    {
        List<mapCoordinates> availableRooms;
        List<mapCoordinates> placedRooms;

        mapCoordinates newCoordinates;
        int maxDistance=0;
        int currentRoomIndex;
        int currentX;
        int currentY;
        boolean firstIteration=true;

        //initializare date
        mapInfo._map = new roomTypes[mapInfo.size][mapInfo.size];
        availableRooms=new ArrayList<mapCoordinates>();
        placedRooms=new ArrayList<mapCoordinates>();
        newCoordinates=new mapCoordinates(mapInfo.size/2,mapInfo.size/2);
        mapInfo.exitCoordinates=new mapCoordinates(mapInfo.size/2,mapInfo.size/2);
        mapInfo.entranceCoordinates=new mapCoordinates(mapInfo.size/2,mapInfo.size/2);
        mapInfo.keyCoordinates=new mapCoordinates(mapInfo.size/2,mapInfo.size/2);
        mapInfo.chestsCoordinates=new ArrayList<mapCoordinates>();
        availableRooms.add(newCoordinates);

        for(int i=0;i<mapInfo.size;i++)
        {
            for(int j=0;j<mapInfo.size;j++)
            {
                mapInfo._map[i][j]=roomTypes.NOTHING;
            }
        }

        //generarea camerelor
        while(roomsCount!=0)
        {
            currentRoomIndex=Rand.Range(0,availableRooms.size());
            currentX=availableRooms.get(currentRoomIndex).x;
            currentY=availableRooms.get(currentRoomIndex).y;
            placedRooms.add(availableRooms.get(currentRoomIndex));

            if(firstIteration)
            {
                firstIteration=false;
                mapInfo._map[currentX][currentY] = roomTypes.ENTRANCE;
                mapInfo.entranceCoordinates.x=currentX;
                mapInfo.entranceCoordinates.y=currentY;
            }
            else
            {
                int distance;
                distance=distanceBetweenPoints(mapInfo.entranceCoordinates,availableRooms.get(currentRoomIndex));
                if(distance>=maxDistance)
                {
                    maxDistance=distance;
                    mapInfo.exitCoordinates=availableRooms.get(currentRoomIndex);
                }
                mapInfo._map[currentX][currentY] = roomTypes.EMPTY;
            }


            //adauga vecinii punctului curent in lista
            addNeighbor(currentX-1,currentY,availableRooms);
            addNeighbor(currentX+1,currentY,availableRooms);
            addNeighbor(currentX,currentY-1,availableRooms);
            addNeighbor(currentX,currentY+1,availableRooms);

            availableRooms.remove(currentRoomIndex);

            roomsCount--;
        }

        mapInfo._map[mapInfo.exitCoordinates.x][mapInfo.exitCoordinates.y]=roomTypes.EXIT;



        //alegere pozitie cheie

        maxDistance=0;

        for(mapCoordinates coords:placedRooms)
        {
            int distance=distanceBetweenPoints(mapInfo.exitCoordinates,coords);
            if(distance>=maxDistance && !coords.compareTo(mapInfo.entranceCoordinates))
            {
                maxDistance=distance;
                mapInfo.keyCoordinates=coords;
            }
        }
        mapInfo._map[ mapInfo.keyCoordinates.x][ mapInfo.keyCoordinates.y]=roomTypes.KEY;

        //sterge camere care au deja ceva in ele

        removeFromList(placedRooms, mapInfo.keyCoordinates);
        removeFromList(placedRooms,mapInfo.entranceCoordinates);
        removeFromList(placedRooms,mapInfo.exitCoordinates);


        //adauga cufere
        while(chestsCount!=0)
        {
            currentRoomIndex=Rand.Range(0,placedRooms.size());
            currentX=placedRooms.get(currentRoomIndex).x;
            currentY=placedRooms.get(currentRoomIndex).y;
            mapInfo._map[currentX][currentY]=roomTypes.CHEST;
            mapInfo.chestsCoordinates.add(placedRooms.get(currentRoomIndex));
            removeFromList(placedRooms,placedRooms.get(currentRoomIndex));
            chestsCount--;
        }
    }



    void removeFromList(List<mapCoordinates> placedRooms,mapCoordinates coordinates)
    {
        for(int i=0;i<placedRooms.size();i++)
        {
            if(placedRooms.get(i).x==coordinates.x && placedRooms.get(i).y==coordinates.y)
            {
                placedRooms.remove(i);
                return;
            }
        }
    }




    void addNeighbor(int x,int y,List<mapCoordinates> availableRooms)
    {
        mapCoordinates newCoordinates;
        if(x>=0 && x<mapInfo.size && y>=0 && y<mapInfo.size && mapInfo._map[x][y]==roomTypes.NOTHING)
        {
            newCoordinates = new mapCoordinates(x , y);
            if(!listContains(newCoordinates,availableRooms))
            {
                availableRooms.add(newCoordinates);
            }
        }
    }

    private boolean listContains(mapCoordinates coordinates,List<mapCoordinates> coordinatesList)
    {
        for(mapCoordinates coords : coordinatesList)
        {
            if(coordinates.x==coords.x && coordinates.y==coords.y)
            {
                return true;
            }
        }
        return false;
    }

    private int distanceBetweenPoints(mapCoordinates point1,mapCoordinates point2)
    {
        int distance;
        mapCoordinates difference;

        difference=point1.minus(point2);

        distance=Math.abs(difference.x)+Math.abs(difference.y);

        return distance;
    }


    public MapInfo getMap()
    {
        return mapInfo;
    }
}
