import java.util.List;

public class MapInfo
{
    public roomTypes[][] _map;
    public int size;
    public int totalRoomsCount;
    public int totalChestsCount;

    public mapCoordinates keyCoordinates;
    public mapCoordinates entranceCoordinates;
    public mapCoordinates exitCoordinates;
    public List<mapCoordinates> chestsCoordinates;


    public void printMap()
    {
        int i;
        int j;

        for(i=0;i<size;i++)
        {
            for(j=0;j<size;j++)
            {
                switch(_map[i][j])
                {
                    case EMPTY:
                    {
                        System.out.print("#");
                        break;
                    }
                    case EXIT:
                    {
                        System.out.print("!");
                        break;
                    }
                    case ENTRANCE:
                    {
                        System.out.print("+");
                        break;
                    }
                    case KEY:
                    {
                        System.out.print("?");
                        break;
                    }
                    case CHEST:
                    {
                        System.out.print("C");
                        break;
                    }
                    default:
                    {
                        System.out.print(" ");
                        break;
                    }
                }
                System.out.print("  ");
            }
            System.out.print('\n');
        }
    }
}
