package Time;

import java.security.PublicKey;

public class Time
{
    static public double deltaTime;
    static private double startTimeDelta;
    static private double endTimeDelta;

    static public double frameTime;
    static private long startTimeFrame;
    static private long endTimeFrame;

    static public double FPS;




    static public void setStartTime()
    {
        startTimeFrame=System.nanoTime();
    }

    static public void setEndTime()
    {
        endTimeFrame=System.nanoTime();
    }

    static public void calculateFrameTime()
    {
        frameTime=(endTimeFrame-startTimeFrame)/1000000000f;
    }


    static public void setStartTimeDelta()
    {
        startTimeDelta=System.nanoTime();
    }

    static public void setEndTimeDelta()
    {
        endTimeDelta=System.nanoTime();
    }

    static public void calculateDelta()
    {
        deltaTime=(endTimeDelta-startTimeDelta)/1000000000;
        FPS=1/deltaTime;
    }

}
