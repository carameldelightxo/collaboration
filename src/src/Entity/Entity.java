package Entity;

import java.awt.image.BufferedImage;


public class Entity {
    public int xPos;
    public int yPos;
    public int moveSpeed;

    public BufferedImage frontS1, frontS2,frontW1, frontW2, backS1, backS2, backW1, backW2,
     leftS1, leftS2, leftW1, leftW2, rightS1, rightS2, rightW1, rightW2;
    public String direction;

    public Entity(int xPos, int yPos, int moveSpeed, String direction){
        this.xPos = xPos;
        this.yPos = yPos;
        this.moveSpeed = moveSpeed;
        this.direction = direction;
    }
}
