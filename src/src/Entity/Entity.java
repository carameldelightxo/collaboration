package Entity;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Entity {
    public int xPos;
    public int yPos;
    public int moveSpeed;
    public int spriteFrame;
    public int currentSprite;
    public Rectangle hitBox;
    public boolean collided = false;

    public BufferedImage frontS,frontW1, frontW2, backS, backW1, backW2,
            leftS, leftW1, leftW2, rightS, rightW1, rightW2;
    public String direction;

    public Entity(int xPos, int yPos, int moveSpeed, String direction){
        this.xPos = xPos;
        this.yPos = yPos;
        this.moveSpeed = moveSpeed;
        this.direction = direction;
        this.spriteFrame = 0;
        this.currentSprite = 0;
    }
}
