package Entity;
import MainGame.*;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    PlayerKeyInputs inputHandler;

    public Player(GamePanel gp, PlayerKeyInputs inputHandler){
        super(384, 288, 1, "front");
        this.gp = gp;
        this.inputHandler = inputHandler;
       // getPlayerImage();
    }

    public void getPlayerImage(){

        try{
            frontS1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_front_SL.png"));
            frontS2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_front_SR.png"));
            frontW1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_front_WL.png"));
            frontW2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_front_W2.png"));

            backS1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_back_SL.png"));
            backS2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_back_SR.png"));
            backW1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_back_WL.png"));
            backW2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_back_WR.png"));

            leftS1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_left_SL.png"));
            leftS2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_left_SR.png"));
            leftW1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_left_WL.png"));
            leftW2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_left_WR.png"));

            rightS1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_right_SL.png"));
            rightS2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_right_SR.png"));
            rightW1 = ImageIO.read(getClass().getResourceAsStream("/player/temp_right_WL.png"));
            rightW2 = ImageIO.read(getClass().getResourceAsStream("/player/temp_right_WR.png"));
        }
        catch(IOException e){
           e.printStackTrace();
        }
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
            direction = "back";
            yPos -= moveSpeed;
        }
        if(inputHandler.downPressed){
            direction = "front";
            yPos += moveSpeed;
        }
        if(inputHandler.leftPressed){
            direction = "left";
            xPos -= moveSpeed;
        }
        if(inputHandler.rightPressed){
            direction = "right";
            xPos += moveSpeed;
        }
    }
    public void draw(Graphics2D graphics2D){

        graphics2D.setColor(Color.black);

        graphics2D.fillRect(xPos, yPos, gp.tileSize, gp.tileSize);

        graphics2D.dispose();
/**
        BufferedImage image = null;

        switch(direction){
            case "front":
                image = frontS1;
                break;
            case "back":
                image = backS1;
                break;
            case "left":
                image = leftS1;
                break;
            case "right":
                image = rightS1;
                break;
        }

        graphics2D.drawImage(image, xPos, yPos, gp.tileSize, gp.tileSize, null);

        graphics2D.dispose();
**/

    }
}
