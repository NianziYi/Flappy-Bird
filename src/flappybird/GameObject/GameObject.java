package flappybird.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
    protected int x;
    protected int y;
    protected int w;
    protected int h;
    protected BufferedImage img;
    protected Rectangle hitbox;

    public GameObject(){}

    public GameObject(int x, int y, BufferedImage img){
        this.x = x;
        this.y = y;
        this.img = img;
        this.w = img.getWidth();
        this.h = img.getHeight();
        this.hitbox = new Rectangle(x, y, w, h);
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img,x,y,null);
    }

    public abstract void update();

    public Rectangle getHitbox(){
        return this.hitbox;
    }

    public int getX(){
        return this.x;
    }
}
