package flappybird.game;

import flappybird.GameUtility.GameConstant;
import flappybird.GameWindow.EndGamePanel;
import flappybird.GameWindow.GameFrame;
import flappybird.GameWindow.GamePanel;
import flappybird.GameWindow.StartGamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class Launcher {

    private GameFrame frame;
    private GamePanel gamePanel;
    private EndGamePanel endPanel;
    private StartGamePanel startPanel;
    private JPanel mainPanel;
    private CardLayout cl;

    public Launcher(){
        this.frame = new GameFrame(); //create game frame
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initUIComponents(){
        this.mainPanel = new JPanel();
        this.startPanel = new StartGamePanel(this);
        this.gamePanel = new GamePanel(this); //crate game panel
        this.gamePanel.gameInitialize();
        this.endPanel = new EndGamePanel(this);
        this.cl = new CardLayout(); // creating a new CardLayout Panel
        this.mainPanel.setLayout(cl); // set the layout of the main panel to our card layout
        this.mainPanel.add(startPanel, "start"); //add the start panel to the main panel
        this.mainPanel.add(gamePanel, "game");   //add the game panel to the main panel
        this.mainPanel.add(endPanel, "end");    // add the end game panel to the main panel
        this.frame.add(mainPanel);
        this.setFrame("start");
    }

    public void setFrame(String type){
        this.frame.setVisible(false); // hide the JFrame
        switch(type){
            case "start":
            case "end":
                this.frame.setSize(GameConstant.MENU_SCREEN_WIDTH,GameConstant.MENU_SCREEN_HEIGHT);
                break;
            case "game":
                this.frame.setSize(GameConstant.GAME_SCREEN_WIDTH,GameConstant.GAME_SCREEN_HEIGHT);
                (new Thread(this.gamePanel)).start();
                break;
        }
        this.cl.show(mainPanel, type); // change current panel shown on main panel tp the panel denoted by type.
        this.frame.setVisible(true); // show the JFrame
    }

    public JFrame getJf() {
        return frame;
    }

    public void closeGame(){
        this.frame.dispatchEvent(new WindowEvent(this.frame, WindowEvent.WINDOW_CLOSING));
    }

    public static void main(String[] args){
        Launcher launch = new Launcher();
        launch.initUIComponents();
    }
}
