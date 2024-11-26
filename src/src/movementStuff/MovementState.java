package movementStuff;

import Entity.*;

import java.awt.image.BufferedImage;

public abstract class MovementState {
    public abstract void updateDirection();
    public abstract BufferedImage displaySprite();
    public abstract void tryMoving(boolean collided);


    public void calculateSprite(Entity e){
        e.spriteFrame++;
        if(e.spriteFrame < 10){//stand 1
            e.currentSprite = 0;
        }
        if(e.spriteFrame > 10 && e.spriteFrame < 20){ //walk 1
            e.currentSprite = 1;
        }
        else if(e.spriteFrame > 20 && e.spriteFrame < 30){ //stand 1
            e.currentSprite = 0;
        }
        else if(e.spriteFrame > 30 && e.spriteFrame < 40){ //walk 2
            e.currentSprite = 2;
        }
        else if (e.spriteFrame > 40){ //stand 1
            e.currentSprite = 0;
            e.spriteFrame = 0;
        }
    }

    public void idleSprite(Entity e){
        if(e.spriteFrame < 20){
            e.currentSprite = 0;
            e.spriteFrame = 9;
        }
        else{
            e.currentSprite = 0;
            e.spriteFrame = 29;
        }
    }
}
