package Mathf;

import java.util.Random;

public class Rand
{
    static Random rand=new Random();
    public static int Range(int min,int max)
    {
        int randomNumber;

        randomNumber=rand.nextInt(min,max);

        return randomNumber;
    }
}
