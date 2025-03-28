import MapGeneration.MapGenerator;
import MapGeneration.MapInfo;
import MapGeneration.layout;

public class Main
{
    public static void main(String[] args) {
        MapInfo mapInfo;
        MapGenerator generator;
        for(int i=0;i<1;i++) {
            generator = new MapGenerator(5, 5, 2);
            generator.generateMap();
            mapInfo = generator.getMap();
            mapInfo.printMap();
            layout map = new layout(14, mapInfo._map,2,5);
            map.print();
        }
    }
}