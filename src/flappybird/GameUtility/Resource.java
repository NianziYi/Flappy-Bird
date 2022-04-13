package flappybird.GameUtility;

import flappybird.GameWindow.GamePanel;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static javax.imageio.ImageIO.read;

public class Resource {
    private static Map<String, BufferedImage> resources;
    private static Map<String, BufferedImage[]> resourcesArray;

    static{
        Resource.resources = new HashMap<>();
        Resource.resourcesArray = new HashMap<>();

        try{
            Resource.resources.put("background", read(Objects.requireNonNull(GamePanel.class.getClassLoader().getResource("bg.png"))));
            Resource.resources.put("ground", read(Objects.requireNonNull(GamePanel.class.getClassLoader().getResource("ground.png"))));
            Resource.resources.put("tube", read(Objects.requireNonNull(GamePanel.class.getClassLoader().getResource("tube.png"))));
            Resource.resources.put("board", read(Objects.requireNonNull(GamePanel.class.getClassLoader().getResource("score.png"))));

            Resource.resourcesArray.put("bird", new BufferedImage[]{
                    read(Objects.requireNonNull(GamePanel.class.getClassLoader().getResource("bird_normal.png"))),
                    read(Objects.requireNonNull(GamePanel.class.getClassLoader().getResource("bird_up.png"))),
                    read(Objects.requireNonNull(GamePanel.class.getClassLoader().getResource("bird_down.png")))
            });

        }catch (IOException ex){
            ex.printStackTrace();
            System.exit(-1);
        }
    }

    public static BufferedImage getResource(String key){
        return Resource.resources.get(key);
    }

    public static BufferedImage[] getResourceArray(String key){
        return Resource.resourcesArray.get(key);
    }
}
