package flappybird.GameObject;

import flappybird.GameUtility.GameConstant;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Ground extends GameObject{

    public Ground(int x, int y, BufferedImage groundimg){
        super(x,y,groundimg);
    }

    @Override
    public void update(){
        if(this.x <= -(w-GameConstant.GAME_SCREEN_WIDTH)){
            x = 0;
        }
        x--;
    }

}
