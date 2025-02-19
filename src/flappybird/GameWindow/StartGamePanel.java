package flappybird.GameWindow;

import flappybird.game.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class StartGamePanel extends JPanel {
    private BufferedImage menuBackground;
    private JButton start;
    private JButton exit;
    private Launcher lf;

    public StartGamePanel(Launcher lf) {
        this.lf = lf;
        try {
            menuBackground = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("title.jpeg")));
        } catch (IOException e) {
            System.out.println("Error cant read menu background");
            e.printStackTrace();
            System.exit(-3);
        }
        this.setBackground(Color.BLACK);
        this.setLayout(null);

        start = new JButton("Start");
        start.setFont(new Font("Courier New", Font.BOLD ,24));
        start.setBounds(150,300,150,50);
        start.setLocation(400,350);
        start.addActionListener((actionEvent -> {
            this.lf.setFrame("game");
        }));


        exit = new JButton("Exit");
        exit.setSize(new Dimension(200,100));
        exit.setFont(new Font("Courier New", Font.BOLD ,24));
        exit.setBounds(150,400,150,50);
        exit.setLocation(50,350);
        exit.addActionListener((actionEvent -> {
            this.lf.closeGame();
        }));

        this.add(start);
        this.add(exit);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }

}
