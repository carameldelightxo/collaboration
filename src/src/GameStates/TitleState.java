package GameStates;

import Entity.*;
import MainGame.GamePanel;
import MainGame.PlayerKeyInputs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TitleState extends GameState {
    private GamePanel gp;
    int optionNum = 0;
    PlayerKeyInputs inputHandler;
    subState subState;

    public TitleState(GamePanel gp){
        this.gp = gp;
        this.inputHandler = gp.inputHandler;
        this.subState = new TitleState.mainTitle(this);
    }

    @Override
    public void update() {
        subState.update();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        //gp.tileManager.draw(graphics2D); //temp

        graphics2D.setColor(Color.white);
        graphics2D.setFont(graphics2D.getFont().deriveFont(48f));
        int xPos = (int)((gp.tileSize * 2) + (0.5 * gp.tileSize));
        int yPos = (gp.tileSize * 2) - 2;
        subState.draw(xPos, yPos, graphics2D);

        graphics2D.dispose();
    }

    @Override
    public void changeStates(String state){
        if(state.equals("escape")){
            this.subState = new mainTitle(this); //change
            optionNum = 0;
        }
    }

    public class mainTitle implements subState{
        TitleState titleState;
        int maxOptions = 1;
        public mainTitle(TitleState titleState){
            this.titleState = titleState;
        }

        @Override
        public void update() {
            if(inputHandler.upPressed && optionNum > 0){
                optionNum --;
            }
            if(inputHandler.downPressed && optionNum < maxOptions){
                optionNum++;
            }

            if(inputHandler.spacePressed && optionNum == 0){
                titleState.subState = new characterSelect(titleState);
                inputHandler.spacePressed = false;
            }
        }

        @Override
        public void draw(int xPos, int yPos, Graphics2D graphics2D) {
            graphics2D.drawString("Title Screen of Our Game!", xPos, yPos);

            xPos += (int)((0.5 * gp.tileSize) + (2 * gp.tileSize));
            yPos += gp.tileSize + 2;
            graphics2D.fillRect(xPos, yPos, gp.tileSize * 6, gp.tileSize * 5);

            yPos += 3 * gp.tileSize;
            graphics2D.setColor(Color.black);
            graphics2D.drawString("cute boba pic", xPos, yPos);

            xPos += 2 * gp.tileSize;
            yPos += (4 * gp.tileSize) - 2;
            graphics2D.setColor(Color.white);
            graphics2D.drawString("Start!", xPos, yPos);
            if(optionNum == 0){
                graphics2D.drawString("♡", xPos - 40, yPos);
            }

            yPos += gp.tileSize;
            graphics2D.drawString("???", xPos, yPos);
            if(optionNum == 1){
                graphics2D.drawString("♡", xPos - 40, yPos);
            }
        }
    }


    public class characterSelect implements subState{
        Entity[] image;
        TitleState titleState;
        int maxOptions = 2;
        public characterSelect(TitleState titleState){
            this.titleState = titleState;
            this.image = new Entity[maxOptions + 1];
            initializeImages(image);
        }
        public void initializeImages(Entity[] image){
            try{
                //default person
                image[0] = new Entity(0,0,0,"front");
                image[0].frontS = ImageIO.read(new File("out/res/player/default/default_front_stand.png"));
                image[0].frontW1 = ImageIO.read(new File("out/res/player/default/default_front_walk1.png"));
                image[0].frontW2 = ImageIO.read(new File("out/res/player/default/default_front_walk2.png"));

                //placeholder
                image[1] = new Entity(0,0,0,"front");
                image[1].frontS = ImageIO.read(new File("out/res/tiles/barrier.png"));
                image[1].frontW1 = ImageIO.read(new File("out/res/tiles/barrier.png"));
                image[1].frontW2 = ImageIO.read(new File("out/res/tiles/barrier.png"));

                //placeholder
                image[2] = new Entity(0,0,0,"front");
                image[2].frontS = ImageIO.read(new File("out/res/tiles/barrier.png"));
                image[2].frontW1 = ImageIO.read(new File("out/res/tiles/barrier.png"));
                image[2].frontW2 = ImageIO.read(new File("out/res/tiles/barrier.png"));
            }
            catch(IOException e){
                e.printStackTrace();
            }
        }

        @Override
        public void update() {
            if(inputHandler.leftPressed){
                if(optionNum <= 0){
                    optionNum = maxOptions;
                }
                else{
                    optionNum--;
                }
                inputHandler.leftPressed = false;
            }
            if(inputHandler.rightPressed){
                if(optionNum >= maxOptions){
                    optionNum = 0;
                }
                else{
                    optionNum++;
                }
                inputHandler.rightPressed = false;
            }
            if(inputHandler.spacePressed && optionNum == 0){
                gp.gameState = new PlayState(gp);
                gp.player.getPlayerImage("default");
            }
        }

        @Override
        public void draw(int xPos, int yPos, Graphics2D graphics2D) {
            xPos += gp.tileSize;
            graphics2D.drawString("Pick Your Character", xPos, yPos);

            xPos -= 2 *gp.tileSize;
            yPos += gp.tileSize + 2;
            graphics2D.fillRect(xPos, yPos, 3*gp.tileSize, 3*gp.tileSize); //temp
            int thisSprite = optionNum - 1;
            if(thisSprite < 0){
                thisSprite = maxOptions;
            }
            graphics2D.drawImage(image[thisSprite].frontS, xPos, yPos, 3*gp.tileSize, 3*gp.tileSize, null);

            xPos += 4 * gp.tileSize;
            yPos += 2 * gp.tileSize;
            graphics2D.fillRect(xPos, yPos, 5*gp.tileSize, 5*gp.tileSize); //temp

            image[optionNum].calculateSprite();
            if (image[optionNum].currentSprite == 0) {
                graphics2D.drawImage(image[optionNum].frontS, xPos, yPos, 5*gp.tileSize, 5*gp.tileSize, null);
            }
            else if(image[optionNum].currentSprite == 1){
                graphics2D.drawImage(image[optionNum].frontW1, xPos, yPos, 5*gp.tileSize, 5*gp.tileSize, null);
            }
            else{
                graphics2D.drawImage(image[optionNum].frontW2, xPos, yPos, 5*gp.tileSize, 5*gp.tileSize, null);
            }



            xPos += 6 * gp.tileSize;
            yPos -= 2 * gp.tileSize;
            graphics2D.fillRect(xPos, yPos, 3*gp.tileSize, 3*gp.tileSize);//temp
             thisSprite= optionNum + 1;
            if(thisSprite > maxOptions){
                thisSprite = 0;
            }
            graphics2D.drawImage(image[thisSprite].frontS, xPos, yPos, 3*gp.tileSize, 3*gp.tileSize, null);
        }

        public void animate(Graphics2D graphics2D){

        }
    }
}
