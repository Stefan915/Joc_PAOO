
public class Main
{
    public static void main(String[] args) {
        MapInfo mapInfo;
        MapGenerator generator;
        generator = new MapGenerator(10, 25, 2);
        generator.generateMap();
        mapInfo = generator.getMap();
        mapInfo.printMap();
        layout map = new layout(6, mapInfo._map);
        map.print();
        System.out.print("tralalelo");
        System.out.print("tralalelo");
    }
}