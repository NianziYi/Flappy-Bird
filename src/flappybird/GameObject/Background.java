package flappybird.GameObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;

public class Background extends GameObject{
    public Background(int x, int y, BufferedImage BGimg){
        super(x,y,BGimg);
    }

    public void update(){}
}
