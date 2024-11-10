package Entity;
import MainGame.*;

import java.awt.*;

public class Player extends Entity {
    GamePanel gp;
    PlayerKeyInputs inputHandler;

    public Player(GamePanel gp, PlayerKeyInputs inputHandler){
        super(384, 288, 1);
        this.gp = gp;
        this.inputHandler = inputHandler;
    }

    public void update(){

        if(inputHandler.shiftPressed){
            moveSpeed = 3;
        }
        else{
            moveSpeed = 1;
        }
        //top left == 0,0 -> subtracting y moves up, adding x moves right
        if(inputHandler.upPressed){
            yPos -= moveSpeed;
        }
        if(inputHandler.downPressed){
            yPos += moveSpeed;
        }
        if(inputHandler.leftPressed){
            xPos -= moveSpeed;
        }
        if(inputHandler.rightPressed){
            xPos += moveSpeed;
        }
    }
    public void draw(Graphics2D graphics2D){
        graphics2D.setColor(Color.black);

        graphics2D.fillRect(xPos, yPos, gp.tileSize, gp.tileSize);

        graphics2D.dispose();

    }
}
