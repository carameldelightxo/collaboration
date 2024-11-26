package movementStuff;

import Entity.Player;
import MainGame.PlayerKeyInputs;

import java.awt.image.BufferedImage;

public class MoveUp extends MovementState{
    Player player;
    PlayerKeyInputs inputHandler;
    public MoveUp(Player player, PlayerKeyInputs inputHandler){
        this.player = player;
        this.inputHandler = inputHandler;
        player.direction = "back";
    }
    public void updateDirection(){
        if(!inputHandler.upPressed) {
            if (inputHandler.leftPressed) {
                player.movementState = new MoveLeft(player, inputHandler);
                return;
            }
            if (inputHandler.downPressed) {
                player.movementState = new MoveDown(player, inputHandler);
                return;
            }
            if (inputHandler.rightPressed) {
                player.movementState = new MoveRight(player, inputHandler);
                return;
            }
        }
    }

    public void tryMoving(boolean collided){
        if(!collided){
            player.yPos -= player.moveSpeed;
            player.hitBox.y = player.yPos + 16;
        }
    }

    public BufferedImage displaySprite(){
        if (player.currentSprite == 0) {
            return player.backS;
        }
        else if(player.currentSprite == 1){
            return player.backW1;
        }
        else{
            return player.backW2;
        }
    }
}
