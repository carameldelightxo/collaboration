package movementStuff;

import Entity.*;
import MainGame.PlayerKeyInputs;

import java.awt.image.BufferedImage;

public class MoveDown extends MovementState{
    Player player;
    PlayerKeyInputs inputHandler;
    public MoveDown(Player player, PlayerKeyInputs inputHandler){
        this.player = player;
        this.inputHandler = inputHandler;
        player.direction = "front";
    }
    public void updateDirection(){
        if(!inputHandler.downPressed){
            if(inputHandler.upPressed){
                player.movementState = new MoveUp(player, inputHandler);
                return;
            }
            if(inputHandler.leftPressed){
                player.movementState = new MoveLeft(player, inputHandler);
                return;
            }
            if(inputHandler.rightPressed){
                player.movementState = new MoveRight(player, inputHandler);
                return;
            }
        }

    }

    public void tryMoving(boolean collided){
        if(!collided){
            player.yPos += player.moveSpeed;
            player.hitBox.y = player.yPos + 16;
        }
    }

    public BufferedImage displaySprite(){
        if (player.currentSprite == 0) {
            return player.frontS;
        }
        else if(player.currentSprite == 1){
            return player.frontW1;
        }
        else{
            return player.frontW2;
        }
    }
}
