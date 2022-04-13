package flappybird.GameObject;

import flappybird.GameUtility.GameConstant;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tube extends GameObject{
    private int yDown;
    private int distance;
    private int bodyH;
    private Rectangle hitboxUp;
    private Rectangle hitboxDown;

    private final int maxD = 350;
    private final int minD = 300;
    private final int maxY = 300;
    private final int minY = 0;

    public Tube(int x, int y,BufferedImage tubeimg, int index){
        super(x,y,tubeimg);
        this.distance = getRandomNumber(minD,maxD);
        this.x = this.x + distance * (index-1);
        this.bodyH = (int)(this.h * 0.44);
        this.yDown = this.y + (int)(this.h * 0.56);

        hitboxUp = new Rectangle(this.x, this.y, this.w, this.bodyH);
        hitboxDown = new Rectangle(this.x, this.yDown, this.w, this.bodyH);
    }

    @Override
    public void update(){
        if(x <= -w){
            distance = getRandomNumber(minD,maxD);
            x = GameConstant.GAME_SCREEN_WIDTH + distance ;
            y = -getRandomNumber(minY,maxY); //get height of tube randomly
            yDown = y + (int)(h * 0.56);
        }
        x--;
        hitboxUp.setLocation(x,y);
        hitboxDown.setLocation(x,yDown);
    }

    public int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }

    public Rectangle getHitboxUp(){
        return this.hitboxUp;
    }

    public Rectangle getHitboxDown(){
        return this.hitboxDown;
    }

    public int getWidth(){
        return this.w;
    }
}
