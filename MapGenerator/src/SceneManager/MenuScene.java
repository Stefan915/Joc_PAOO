package SceneManager;

import ButtonManager.ButtonManager;
import DataStructures.Vector2;
import WindowManager.Window;

import javax.swing.*;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class MenuScene extends Scene implements ActionListener {

    JButton playButton;

    @Override
    public void Start() throws IOException {
        playButton=new JButton();
        playButton.setBounds(200,100,100,50);
        playButton.addActionListener(this);
        //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.setLayout(null);
        //this.setSize(500,500);
        //.setVisible(true);
        //this.add(playButton);
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
