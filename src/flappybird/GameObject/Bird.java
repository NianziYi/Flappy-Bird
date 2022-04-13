package flappybird.GameObject;

import flappybird.GameUtility.GameConstant;
import flappybird.GameUtility.MusicPlayer;
import flappybird.GameUtility.Resource;

import java.awt.*;
import java.util.*;
import java.awt.image.BufferedImage;
import java.util.List;

public class Bird extends GameObject{
    private int speed;
    private int state;
    private boolean FlyPressed;
    private boolean isDead = false;
    private boolean endGame = false;
    private BufferedImage[] birdimg;

    public static final int MAX_UP_SPEED = 2;
    public static final int MAX_DOWN_SPEED = 1;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_UP = 1;
    public static final int STATE_DOWN = 2;

    public Bird(int x, int y, BufferedImage[] birdimg){
        super();
        this.x = x;
        this.y = y;
        this.birdimg = birdimg;
        this.w = birdimg[state].getWidth();
        this.h = birdimg[state].getHeight();
        this.hitbox = new Rectangle(x, y, w, h);
    }

    @Override
    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(birdimg[state],x,y,null);
    }

    @Override
    public void update(){

        if (this.FlyPressed) {
            this.fly();
        }

        if(!this.FlyPressed){
            this.down();
        }

        if(isDead){
            this.die();
        }

    }

    public void toggleFlyPressed() {
        this.FlyPressed = true;
    }

    public void unToggleFlyPressed() {
        this.FlyPressed = false;
    }

    public void fly(){
        state = STATE_UP;
        speed += 1;
        if(speed > MAX_UP_SPEED){
            speed = MAX_UP_SPEED;
        }
        y -= speed;
        checkBorder();
        hitbox.setLocation(x,y);
    }

    public void down(){
        state = STATE_NORMAL;
        speed += 0.5;
        if(speed > MAX_DOWN_SPEED){
            speed = MAX_DOWN_SPEED;
        }
        y += speed;
        checkBorder();
        hitbox.setLocation(x,y);
    }

    public void die(){
        state = STATE_DOWN;
        speed += 1;
        if(speed > MAX_DOWN_SPEED){
            speed = MAX_DOWN_SPEED+3;
        }
        y += speed;
        checkBorder();
        hitbox.setLocation(x,y);
    }

    public void checkBorder(){
        if(y < birdimg[state].getHeight(null)>>1){
            y = GameConstant.BAR_HEIGHT;
        }

        if(y > GameConstant.GROUND_HEIGHT - birdimg[state].getHeight()){
            y = GameConstant.GROUND_HEIGHT - birdimg[state].getHeight() + 1;
            endGame = true;
        }
    }

    public boolean getGameStatus(){return endGame;}

    public void setStatus(boolean isDead){this.isDead = isDead;}
}