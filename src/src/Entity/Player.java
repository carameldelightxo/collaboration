package Entity;
import MainGame.*;
import movementStuff.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    GamePanel gp;
    PlayerKeyInputs inputHandler;
    public MovementState movementState;

    public Player(GamePanel gp, PlayerKeyInputs inputHandler, String skin){
        super(384, 288, 1, "front");
        this.gp = gp;
        this.inputHandler = inputHandler;
        this.hitBox = new Rectangle(xPos + 8, yPos + 16, 32, 32);
        this.movementState = new MoveDown(this, inputHandler);
        getPlayerImage(skin);
    }

    public void getPlayerImage(String skin){
        if(skin.equals("default")) {
            try {
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
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void update(){
        if(inputHandler.leftPressed || inputHandler.rightPressed
        || inputHandler.upPressed || inputHandler.downPressed){

            if(inputHandler.shiftPressed){
                moveSpeed = 3;
            }
            else{
                moveSpeed = 1;
            }

            movementState.updateDirection();

            calculateSprite();

            collided = false;
            gp.collisionCatcher.checkTile(this);

            movementState.tryMoving(collided);

        }
        else{
            idleSprite();
        }
        //top left == 0,0 -> subtracting y moves up, adding x moves right


    }
    public void draw(Graphics2D graphics2D){

        BufferedImage image = movementState.displaySprite();

        //display character
        graphics2D.drawImage(image, xPos, yPos, gp.tileSize, gp.tileSize, null);

        //display hitbox
        graphics2D.drawRect(xPos + 8, yPos + 16, 32, 32);

    }
}
