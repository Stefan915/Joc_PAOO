public class mapCoordinates
{
    public int x;
    public int y;

    public mapCoordinates(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    public mapCoordinates minus(mapCoordinates other)
    {
        return new mapCoordinates(x-other.x,y-other.y);
    }

    public boolean compareTo(mapCoordinates other)
    {
        return x==other.x && y==other.y;
    }
}
