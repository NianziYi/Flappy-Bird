package flappybird.GameWindow;

import flappybird.game.Launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class EndGamePanel extends JPanel{
    private BufferedImage menuBackground;
    private JButton restart;
    private JButton exit;
    private Launcher lf;

    public EndGamePanel(Launcher lf) {
        this.lf = lf;
        try {
            menuBackground = ImageIO.read(Objects.requireNonNull(this.getClass().getClassLoader().getResource("title.jpeg")));
        } catch (IOException e) {
            System.out.println("Error cant read menu background");
            e.printStackTrace();
            System.exit(-3);
        }
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        restart = new JButton("Restart Game");
        restart.setFont(new Font("Courier New", Font.BOLD ,24));
        restart.setBounds(150,300,175,50);
        restart.setLocation(400,350);
        restart.addActionListener((actionEvent -> {
            this.lf.setFrame("game");
        }));


        exit = new JButton("Exit");
        exit.setFont(new Font("Courier New", Font.BOLD ,24));
        exit.setBounds(150,400,175,50);
        exit.setLocation(50,350);
        exit.addActionListener((actionEvent -> {
            this.lf.closeGame();
        }));


        this.add(restart);
        this.add(exit);

    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(this.menuBackground,0,0,null);
    }
}
