package Time;

import java.security.PublicKey;

public class Time
{
    static public double deltaTime;
    static private long startTime;
    static private long endTime;
    public static double gameTime;
    static public double FPS;



    static public void setStartTime()
    {
        startTime=System.nanoTime();
    }

    static public void setEndTime()
    {
        endTime=System.nanoTime();
    }

    static public void calculateDelta()
    {
        deltaTime=(endTime-startTime)/1000000000f;
        gameTime+=deltaTime;
        FPS=1/deltaTime;
    }


}
