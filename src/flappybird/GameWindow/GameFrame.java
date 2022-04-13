package flappybird.GameWindow;

import flappybird.GameUtility.GameConstant;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;

public class GameFrame extends JFrame {
    public GameFrame(){
        frameInitialize();
    }

    private void frameInitialize(){
        setSize(GameConstant.GAME_SCREEN_WIDTH, GameConstant.GAME_SCREEN_HEIGHT); //set size of game screen
        setTitle(GameConstant.GAME_TITLE); //set title of game screen
        setLocationRelativeTo(null); //set position of game screen
        setResizable(false); //not allow users to change size of game screen

        //set Game Icon
        try {
            setIconImage(ImageIO.read(new FileInputStream("resources/bird_normal.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
