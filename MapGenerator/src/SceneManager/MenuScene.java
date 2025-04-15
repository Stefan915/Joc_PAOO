package SceneManager;
import WindowManager.Window;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static WindowManager.Window.instance;

public class MenuScene extends Scene implements ActionListener {

    JButton playButton;

    @Override
    public void Start() throws IOException {
                JButton b=new JButton("Click Here");
                b.setBounds(Window.screenSize.width/2,Window.screenSize.height/2,1000,1000);
                System.out.println("am pus butonu");
                instance.window.add(b);
                instance.window.setLayout(null);
                instance.window.setVisible(true);
    }

    @Override
    public void Update() {
    }

    @Override
    public void loadImages() throws IOException {
    }

    @Override
    public void draw(Graphics2D graphics2D) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
