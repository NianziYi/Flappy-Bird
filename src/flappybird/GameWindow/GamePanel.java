package flappybird.GameWindow;

import flappybird.GameObject.*;
import flappybird.GameUtility.*;
import flappybird.game.Launcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    private Background BG;
    private Bird bird;
    private Ground ground;
    private BirdControl birdControl;
    private Collision co;
    private Tube tube1;
    private Tube tube2;
    private Tube tube3;
    private Tube tube4;
    private int score;
    private ScoreBoard board;
    private ArrayList<Tube> tubeList;
    private ArrayList<GameObject> objectList;
    private Random ran = new Random();
    private Launcher lf;
    private MusicPlayer music = new MusicPlayer();

    public GamePanel(Launcher lf){
        this.lf = lf;
    }

    @Override
    public void run(){
        try {
            while(true){
                this.objectList.forEach(gameObject -> gameObject.update());
                checkCollision(); //check collision
                Score(); //add score

                repaint(); //execute paintComponent()
                Thread.sleep(GameConstant.GAME_INTERVAL);

                if(bird.getGameStatus()){
                    Thread.sleep(1000);
                    gameInitialize();
                    music.stopMusic();
                    this.lf.setFrame("end");
                    return;
                }

            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void gameInitialize(){
        //play music
        music.playMusic("music.wav");

        //initialize score
        score = 0;

        //initialize objectList
        objectList = new ArrayList<>();

        //initialize collision
        co = new Collision();

        //initialize background
        BG = new Background(0,0, Resource.getResource("background"));
        objectList.add(BG);

        //initialize tube list
        tubeList = new ArrayList<>();

        //initialize tube
        tube1 = new Tube(GameConstant.GAME_SCREEN_WIDTH, -ran.nextInt(300),Resource.getResource("tube"), 1);
        tubeList.add(tube1);
        objectList.add(tube1);
        tube2 = new Tube(GameConstant.GAME_SCREEN_WIDTH, -ran.nextInt(300),Resource.getResource("tube"),2);
        tubeList.add(tube2);
        objectList.add(tube2);
        tube3 = new Tube(GameConstant.GAME_SCREEN_WIDTH, -ran.nextInt(300),Resource.getResource("tube"),3);
        tubeList.add(tube3);
        objectList.add(tube3);
        tube4 = new Tube(GameConstant.GAME_SCREEN_WIDTH, -ran.nextInt(300),Resource.getResource("tube"),4);
        tubeList.add(tube4);
        objectList.add(tube4);

        //initialize bird
        bird = new Bird(GameConstant.GAME_SCREEN_WIDTH-800,GameConstant.GAME_SCREEN_HEIGHT-500,Resource.getResourceArray("bird"));
        birdControl = new BirdControl(bird, KeyEvent.VK_SPACE);
        this.lf.getJf().addKeyListener(birdControl);
        objectList.add(bird);

        //initialize ground
        ground  = new Ground(0,GameConstant.GAME_SCREEN_HEIGHT-110,Resource.getResource("ground"));
        objectList.add(ground);

        //initialize score board
        board = new ScoreBoard(300, 200, Resource.getResource("board"));
    }

    public void paintComponent(Graphics g){
        this.objectList.forEach(gameObject -> gameObject.draw(g));
        Font newFont = new Font("TimesRoman", Font.BOLD , 40);
        g.setFont(newFont);
        g.setColor(Color.WHITE);
        g.drawString("Score: " + score, 20, 40);

        if(bird.getGameStatus()){ //draw score board if game is end
            board.draw(g);
            Font scoreFont = new Font("TimesRoman", Font.BOLD , 200);
            g.setFont(scoreFont);
            g.setColor(Color.WHITE);
            g.drawString(""+ score, 430, 550);
        }
    }

    public void checkCollision(){
        co.handleCollision(bird,ground);
        tubeList.forEach(tube -> co.handleCollision(bird,tube));
    }

    public void Score(){
        for(int i = 0; i < tubeList.size(); i++){
            Tube tube = tubeList.get(i);
            if(bird.getX() == tube.getX()+tube.getWidth()){
                score++;
                music.playMusic("score.wav");
            }
        }
    }

}
