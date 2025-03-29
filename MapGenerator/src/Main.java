import MapGeneration.MapGenerator;
import MapGeneration.MapInfo;
import MapGeneration.layout;
import WindowManager.Window;
import Time.Time;
public class Main
{
    public static void main(String[] args){
        Window window;
        window=new Window();

        window.initWindow("Joc PAOO");


        System.out.println("THE GAME LOOP IS RUNNING...");
        window.startThread();
    }
}