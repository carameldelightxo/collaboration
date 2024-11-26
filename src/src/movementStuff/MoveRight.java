package movementStuff;

import Entity.Player;
import MainGame.PlayerKeyInputs;

import java.awt.image.BufferedImage;

public class MoveRight extends MovementState{
    Player player;
    PlayerKeyInputs inputHandler;
    public MoveRight(Player player, PlayerKeyInputs inputHandler){
        this.player = player;
        this.inputHandler = inputHandler;
        player.direction = "right";
    }
    public void updateDirection() {
        if (inputHandler.leftPressed) {
            player.movementState = new MoveLeft(player, inputHandler);
            inputHandler.rightPressed = false;
            return;
        }
        if (inputHandler.downPressed) {
            player.movementState = new MoveDown(player, inputHandler);
            inputHandler.rightPressed = false;
            return;
        }
        if (inputHandler.upPressed) {
            player.movementState = new MoveUp(player, inputHandler);
            inputHandler.rightPressed = false;
            return;
        }
    }

    public void tryMoving(boolean collided){
        if(!collided){
            player.xPos += player.moveSpeed;
            player.hitBox.x = player.xPos + 8;
        }
    }

    public BufferedImage displaySprite(){
        if (player.currentSprite == 0) {
            return player.rightS;
        }
        else if(player.currentSprite == 1){
            return player.rightW1;
        }
        else{
            return player.rightW2;
        }
    }
}
