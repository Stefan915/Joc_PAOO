package ButtonManager;

import DataStructures.Vector2;
import Interfaces.I_imageContainer;

import java.awt.*;

public class ButtonManager implements I_imageContainer
{
    String buttonText;
    public Vector2 position;
    public Vector2 backgroundSize;
    private int currentFontSize;
    public int fontSize;
    public Color color=Color.white;
    public ButtonManager(String buttonText,Vector2 position,Vector2 backgroundSize,int fontSize)
    {
        this.buttonText=buttonText;
        this.position=position;
        this.backgroundSize=backgroundSize;
        this.fontSize=fontSize;
        currentFontSize=fontSize;

    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setFont(new Font("Arial",Font.BOLD,fontSize));
        graphics2D.setColor(Color.white);
        graphics2D.drawString(buttonText,(float)position.x,(float)position.y+currentFontSize/2);
    }

}
