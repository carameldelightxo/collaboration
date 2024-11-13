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
        this.hitBox = new Rectangle(xPos + 8, yPos + 16, 32, 32);
        getPlayerImage();
    }

    public void getPlayerImage(){
        try{
            frontS = ImageIO.read(new File("out/res/player/default/default_front_stand.png"));
            frontW1 = ImageIO.read(new File("out/res/player/default/default_front_walk1.png"));
            frontW2 = ImageIO.read(new File("out/res/player/default/default_front_walk2.png"));

            backS = ImageIO.read(new File("out/res/player/default/default_back_stand.png"));
            backW1 = ImageIO.read(new File("out/res/player/default/default_back_walk1.png"));
            backW2 = ImageIO.read(new File("out/res/player/default/default_back_walk2.png"));

            leftS = ImageIO.read(new File("out/res/player/default/default_left_stand.png"));
            leftW1 = ImageIO.read(new File("out/res/player/default/default_left_walk1.png"));
            leftW2 = ImageIO.read(new File("out/res/player/default/default_left_walk2.png"));

            rightS = ImageIO.read(new File("out/res/player/default/default_right_stand.png"));
            rightW1 = ImageIO.read(new File("out/res/player/default/default_right_walk1.png"));
            rightW2 = ImageIO.read(new File("out/res/player/default/default_right_walk2.png"));
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
            }
            if(inputHandler.downPressed){
                direction = "front";
            }
            if(inputHandler.leftPressed){
                direction = "left";
            }
            if(inputHandler.rightPressed){
                direction = "right";
            }
            spriteFrame++;
            if(spriteFrame < 10){//stand 1
                currentSprite = 0;
            }
            if(spriteFrame > 10 && spriteFrame < 20){ //walk 1
                currentSprite = 1;
            }
            else if(spriteFrame > 20 && spriteFrame < 30){ //stand 1
                currentSprite = 0;
            }
            else if(spriteFrame > 30 && spriteFrame < 40){ //walk 2
                currentSprite = 2;
            }
            else if (spriteFrame > 40){ //stand 1
                currentSprite = 0;
                spriteFrame = 0;
            }
            collided = false;
            gp.collisionCatcher.checkTile(this);
            if(!collided){
                switch(direction){
                    case "back":
                        yPos -= moveSpeed;
                        hitBox.y = yPos + 16;
                        break;
                    case "front":
                        yPos += moveSpeed;
                        hitBox.y = yPos + 16;
                        break;
                    case "left":
                        xPos -= moveSpeed;
                        hitBox.x = xPos + 8;
                        break;
                    case "right":
                        xPos += moveSpeed;
                        hitBox.x = xPos + 8;
                        break;

                }
            }

        }
        else{
            if(spriteFrame < 20){
                currentSprite = 0;
                spriteFrame = 9;
            }
            else{
                currentSprite = 0;
                spriteFrame = 29;
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
                    image = frontS;
                }
                else if(currentSprite == 1){
                    image = frontW1;
                }
                else if(currentSprite == 2){
                    image = frontW2;
                }


                break;
            case "back":
                if (currentSprite == 0) {
                    image = backS;
                }
                else if(currentSprite == 1){
                    image = backW1;
                }
                else if(currentSprite == 2){
                    image = backW2;
                }
                break;
            case "left":
                if (currentSprite == 0) {
                    image = leftS;
                }
                else if(currentSprite == 1){
                    image = leftW1;
                }
                else if(currentSprite == 2){
                    image = leftW2;
                }
                break;
            case "right":
                if (currentSprite == 0) {
                    image = rightS;
                }
                else if(currentSprite == 1){
                    image = rightW1;
                }
                else if(currentSprite == 2){
                    image = rightW2;
                }
                break;
        }

        graphics2D.drawImage(image, xPos, yPos, gp.tileSize, gp.tileSize, null);
        graphics2D.drawRect(xPos + 8, yPos + 16, 32, 32);

        graphics2D.dispose();

    }
}
