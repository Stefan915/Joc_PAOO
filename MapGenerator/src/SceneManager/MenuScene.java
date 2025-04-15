package SceneManager;
import ButtonManager.ButtonManager;
import DataStructures.Vector2;
import WindowManager.Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import SceneManager.ScenesManager;
import static WindowManager.Window.instance;

public class MenuScene extends Scene implements ActionListener {

    JButton playButton;
    private ButtonManager but;
    @Override
    public void Start() throws IOException {
        but = new ButtonManager("Play",new Vector2(Window.screenSize.width/2,Window.screenSize.height/2),new Vector2(0,0),100,102);
    }

    @Override
    public void Update() {
        but.Update();
    }

    @Override
    public void loadImages() throws IOException {
    }

    @Override
    public void draw(Graphics2D graphics2D) {
        but.draw(graphics2D);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==but){
            try {
                ScenesManager.instance.setCurrentActiveScene(allScenes.GAME);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
