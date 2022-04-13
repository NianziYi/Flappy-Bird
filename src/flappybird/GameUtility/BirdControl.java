package flappybird.GameUtility;

import flappybird.GameObject.Bird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class BirdControl implements KeyListener {
    private Bird bird;
    private final int fly;
    private MusicPlayer music = new MusicPlayer();

    public BirdControl(Bird bird, int fly){
        this.bird = bird;
        this.fly = fly;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int keyPressed = e.getKeyCode();
        if(keyPressed == fly){
            this.bird.toggleFlyPressed();
            music.playMusic("fly.wav");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyReleased = e.getKeyCode();
        if(keyReleased == fly){
            this.bird.unToggleFlyPressed();
        }

    }
}
