package ButtonManager;

import DataStructures.Vector2;
import Input.InputManager;
import Interfaces.I_imageContainer;
import Interfaces.StandardBehaviour;

import java.awt.*;

public class ButtonManager implements I_imageContainer, StandardBehaviour
{
    String buttonText;
    public Vector2 position;
    public Vector2 backgroundSize;
    private int currentFontSize;
    public int fontSize;
    public int hoverFontSize;
    public Color color=Color.white;
    private boolean isHovered;

    private Vector2 centeredPosition=new Vector2(0,0);
    private Vector2 centeredPositionSize=new Vector2(0,0);


    public ButtonManager(String buttonText,Vector2 position,Vector2 backgroundSize,int fontSize,int hoverFontSize)
    {
        this.buttonText=buttonText;
        this.position=position;
        this.backgroundSize=backgroundSize;
        this.fontSize=fontSize;
        this.hoverFontSize=hoverFontSize;
        currentFontSize=fontSize;

    }


    @Override
    public void Update()
    {



        if(InputManager.mousePosition.x>= centeredPosition.x && InputManager.mousePosition.x <= centeredPosition.x+ centeredPositionSize.x)
        {
            currentFontSize=hoverFontSize;
        }
        else
        {
            currentFontSize=fontSize;
        }


    }

    @Override
    public void draw(Graphics2D graphics2D)
    {
        graphics2D.setFont(new Font("Arial",Font.BOLD,currentFontSize));
        graphics2D.setColor(Color.white);
        FontMetrics metrics = graphics2D.getFontMetrics();
        centeredPosition.x=(float)position.x-metrics.stringWidth(buttonText)/2;
        centeredPosition.y=(float)position.y+currentFontSize/2;

        centeredPositionSize.x=metrics.stringWidth(buttonText);
        centeredPositionSize.y=currentFontSize;

        graphics2D.drawString(buttonText,(float)centeredPosition.x,(float)centeredPosition.y);
    }

}
