package movementStuff;

import Entity.Player;
import MainGame.PlayerKeyInputs;

import java.awt.image.BufferedImage;

public class MoveLeft extends MovementState{
    Player player;
    PlayerKeyInputs inputHandler;
    public MoveLeft(Player player, PlayerKeyInputs inputHandler){
        this.player = player;
        this.inputHandler = inputHandler;
        player.direction = "left";
    }
    public void updateDirection(){
        if(inputHandler.upPressed){
            player.movementState = new MoveUp(player, inputHandler);
            inputHandler.leftPressed = false;
            return;
        }
        if(inputHandler.downPressed){
            player.movementState = new MoveDown(player, inputHandler);
            inputHandler.leftPressed = false;
            return;
        }
        if(inputHandler.rightPressed){
            player.movementState = new MoveRight(player, inputHandler);
            inputHandler.leftPressed = false;
            return;
        }
    }

    public void tryMoving(boolean collided){
        if(!collided){
            player.xPos -= player.moveSpeed;
            player.hitBox.x = player.xPos + 8;
        }
    }

    public BufferedImage displaySprite(){
        if (player.currentSprite == 0) {
            return player.leftS;
        }
        else if(player.currentSprite == 1){
            return player.leftW1;
        }
        else{
            return player.leftW2;
        }
    }

}
