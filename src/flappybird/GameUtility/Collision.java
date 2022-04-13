package flappybird.GameUtility;

import flappybird.GameObject.Bird;
import flappybird.GameObject.Ground;
import flappybird.GameObject.Tube;

import java.util.ArrayList;

public class Collision {
    private MusicPlayer music = new MusicPlayer();

    //check bird collide ground
    public void handleCollision(Bird b, Ground g) {
        if (b.getHitbox().intersects(g.getHitbox())) {
            b.setStatus(true);
            music.playMusic("crash.wav");
        }
    }

    //check bird collide tube
    public void handleCollision(Bird b, Tube t){
        if((b.getHitbox().intersects(t.getHitboxDown())) || (b.getHitbox().intersects(t.getHitboxUp()))){
            b.setStatus(true);
        }
    }

}
