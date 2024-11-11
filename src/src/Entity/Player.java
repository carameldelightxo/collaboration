package Entity;
import MainGame.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    PlayerKeyInputs inputHandler;

    public Player(GamePanel gp, PlayerKeyInputs inputHandler){
        super(384, 288, 1, "front");
        this.gp = gp;
        this.inputHandler = inputHandler;
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            frontS1 = ImageIO.read(new File("out/res/player/temp_front_SL.png"));
            frontS2 = ImageIO.read(new File("out/res/player/temp_front_SR.png"));
            frontW1 = ImageIO.read(new File("out/res/player/temp_front_WL.png"));
            frontW2 = ImageIO.read(new File("out/res/player/temp_front_WR.png"));

            backS1 = ImageIO.read(new File("out/res/player/temp_back_SL.png"));
            backS2 = ImageIO.read(new File("out/res/player/temp_back_SR.png"));
            backW1 = ImageIO.read(new File("out/res/player/temp_back_WL.png"));
            backW2 = ImageIO.read(new File("out/res/player/temp_back_WR.png"));

            leftS1 = ImageIO.read(new File("out/res/player/temp_left_SL.png"));
            leftS2 = ImageIO.read(new File("out/res/player/temp_left_SR.png"));
            leftW1 = ImageIO.read(new File("out/res/player/temp_left_WL.png"));
            leftW2 = ImageIO.read(new File("out/res/player/temp_left_WR.png"));

            rightS1 = ImageIO.read(new File("out/res/player/temp_right_SL.png"));
            rightS2 = ImageIO.read(new File("out/res/player/temp_right_SR.png"));
            rightW1 = ImageIO.read(new File("out/res/player/temp_right_WL.png"));
            rightW2 = ImageIO.read(new File("out/res/player/temp_right_WR.png"));
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
        if(inputHandler.downPressed || inputHandler.upPressed || inputHandler.leftPressed || inputHandler.rightPressed){
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
            spriteFrame++;
            if(spriteFrame < 10){
                currentSprite = 0;
            }
            if(spriteFrame > 10 && spriteFrame < 20){
                currentSprite = 1;
            }
            else if(spriteFrame > 20 && spriteFrame < 30){
                currentSprite = 2;
            }
            else if(spriteFrame > 30 && spriteFrame < 40){
                currentSprite = 3;
            }
            else if(spriteFrame > 40){
                currentSprite = 0;
                spriteFrame = 0;
            }
        }
        //top left == 0,0 -> subtracting y moves up, adding x moves right


    }
    public void draw(Graphics2D graphics2D){
/**
        graphics2D.setColor(Color.black);

        graphics2D.fillRect(xPos, yPos, gp.tileSize, gp.tileSize);

        graphics2D.dispose();
 **/

        BufferedImage image = null;

        switch(direction){
            case "front":
                if (currentSprite == 0) {
                    image = frontS1;
                }
                else if(currentSprite == 1){
                    image = frontW1;
                }
                else if(currentSprite == 2){
                    image = frontS2;
                }
                else if(currentSprite == 3){
                    image = frontW2;
                }


                break;
            case "back":
                if (currentSprite == 0) {
                    image = backS1;
                }
                else if(currentSprite == 1){
                    image = backW1;
                }
                else if(currentSprite == 2){
                    image = backS2;
                }
                else if(currentSprite == 3){
                    image = backW2;
                }
                break;
            case "left":
                if (currentSprite == 0) {
                    image = leftS1;
                }
                else if(currentSprite == 1){
                    image = leftW1;
                }
                else if(currentSprite == 2){
                    image = leftS2;
                }
                else if(currentSprite == 3){
                    image = leftW2;
                }
                break;
            case "right":
                if (currentSprite == 0) {
                    image = rightS1;
                }
                else if(currentSprite == 1){
                    image = rightW1;
                }
                else if(currentSprite == 2){
                    image = rightS2;
                }
                else if(currentSprite == 3){
                    image = rightW2;
                }
                break;
        }

        graphics2D.drawImage(image, xPos, yPos, gp.tileSize, gp.tileSize, null);

        graphics2D.dispose();

    }
}
