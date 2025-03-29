import MapGeneration.MapGenerator;
import MapGeneration.MapInfo;
import MapGeneration.layout;
import WindowManager.Window;
import Time.Time;
public class Main
{
    public static void main(String[] args){

        boolean gameIsRunning=true;

        MapInfo mapInfo;
        MapGenerator generator;

        Window window;
        window=new Window();


        window.initWindow("Joc PAOO");


        for(int i=0;i<1;i++) {
            generator = new MapGenerator(5, 5, 2);
            generator.generateMap();
            mapInfo = generator.getMap();
            mapInfo.printMap();
            layout map = new layout(14, mapInfo._map,2,5);
            map.print();
        }


        System.out.println("THE GAME LOOP IS RUNNING...");
        //main game loop
        window.startThread();
    }
}