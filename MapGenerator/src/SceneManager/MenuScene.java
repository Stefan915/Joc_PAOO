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
                b.setBounds(0,0,200,100);
                final JTextField tf=new JTextField();
                tf.setBounds(50,50, 150,20);
                System.out.println("am pus butonu");
                b.setBackground(Color.BLACK);
                b.setContentAreaFilled(true);
                b.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        tf.setText("Welcome to Javatpoint.");
                    }
                });
                instance.window.add(b);
                instance.window.add(tf);
                instance.window.setLayout(null);
                instance.window.pack();
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
