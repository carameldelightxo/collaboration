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

    public void calculateSprite(){
        this.spriteFrame++;
        if(this.spriteFrame < 10){//stand 1
            this.currentSprite = 0;
        }
        if(this.spriteFrame > 10 && this.spriteFrame < 20){ //walk 1
            this.currentSprite = 1;
        }
        else if(this.spriteFrame > 20 && this.spriteFrame < 30){ //stand 1
            this.currentSprite = 0;
        }
        else if(this.spriteFrame > 30 && this.spriteFrame < 40){ //walk 2
            this.currentSprite = 2;
        }
        else if (this.spriteFrame > 40){ //stand 1
            this.currentSprite = 0;
            this.spriteFrame = 0;
        }
    }

    public void idleSprite(){
        if(this.spriteFrame < 20){
            this.currentSprite = 0;
            this.spriteFrame = 9;
        }
        else{
            this.currentSprite = 0;
            this.spriteFrame = 29;
        }
    }

}
