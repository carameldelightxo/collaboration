package GameStates;

import MainGame.GamePanel;
import MainGame.PlayerKeyInputs;

import java.awt.*;

public class PauseState extends GameState {
    private GamePanel gp;
    int optionNum = 0;
    PlayerKeyInputs inputHandler;
    subState subState;
    public PauseState(GamePanel gp){
        this.gp = gp;
        this.inputHandler = gp.inputHandler;
        this.subState = new mainPause(this);
    }

    @Override
    public void update() {
        subState.update();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D graphics2D = (Graphics2D)graphics;
        gp.tileManager.draw(graphics2D);
        gp.player.draw(graphics2D);

        graphics2D.setColor(Color.white);
        graphics2D.setFont(graphics2D.getFont().deriveFont(32f));

        int xPos = gp.tileSize*11;
        int yPos = gp.tileSize*0;
        int frameWidth = gp.tileSize*5;
        int frameHeight = gp.tileSize*7;

        drawSubWindow(xPos, yPos, frameWidth, frameHeight, graphics2D); //inside GameState

        subState.draw(xPos, yPos, graphics2D);

        graphics2D.dispose();
    }




    @Override
    public void changeStates(String state){
        if(state.equals("pause")){
            gp.gameState = new PlayState(gp);
        }
        else if(state.equals("title")){
            gp.gameState = new TitleState(gp);
        }
    }

    public class mainPause implements subState{
        PauseState pauseState;
        public mainPause(PauseState pauseState){
            this.pauseState = pauseState;
        }

        public void update() {
            if (inputHandler.upPressed && optionNum > 0) {
                optionNum--;
                inputHandler.upPressed = false;
            }
            if (inputHandler.downPressed && optionNum < 3) {
                optionNum++;
                inputHandler.downPressed = false;
            }

            if(inputHandler.spacePressed && optionNum == 3){
                pauseState.subState = new maybeQuit(pauseState);
                optionNum = 0;
                inputHandler.spacePressed = false;
            }
        }

        public void draw(int xPos, int yPos, Graphics2D graphics2D){
            xPos += gp.tileSize;
            yPos += gp.tileSize - 2;
            graphics2D.drawString("Pause♡", xPos, yPos);

            yPos += gp.tileSize;
            graphics2D.drawString("???", xPos, yPos);
            if(optionNum == 0){
                graphics2D.drawString("♡", xPos - 30, yPos);
            }

            yPos += gp.tileSize;
            graphics2D.drawString("???", xPos, yPos);
            if(optionNum == 1){
                graphics2D.drawString("♡", xPos - 30, yPos);
            }

            yPos += gp.tileSize;
            graphics2D.drawString("???", xPos, yPos);
            if(optionNum == 2){
                graphics2D.drawString("♡", xPos - 30, yPos);
            }

            yPos += 2 * gp.tileSize;
            graphics2D.drawString("Quit", xPos, yPos);
            if(optionNum == 3){
                graphics2D.drawString("♡", xPos - 30, yPos);
            }
        }


    }
    public class maybeQuit implements subState{
        PauseState pauseState;
        public maybeQuit(PauseState pauseState){
            this.pauseState = pauseState;
        }

        public void update() {
            if (inputHandler.upPressed && optionNum > 0) {
                optionNum--;
                inputHandler.upPressed = false;
            }
            if (inputHandler.downPressed && optionNum < 1) {
                optionNum++;
                inputHandler.downPressed = false;
            }
            if(inputHandler.spacePressed && optionNum == 0){ //yes, quit
                gp.gameState = new TitleState(gp);
            }
            if(inputHandler.spacePressed && optionNum == 1){ //no, stay paused
                pauseState.subState = new mainPause(pauseState);
                optionNum = 0;
                inputHandler.spacePressed = false;
            }
        }


        public void draw(int xPos, int yPos, Graphics2D graphics2D){
            xPos += (int)(0.5 * gp.tileSize);
            yPos += gp.tileSize - 2;
            graphics2D.drawString("Are you sure?", xPos, yPos);

            xPos += (int) (0.5 * gp.tileSize);
            yPos += 2 * gp.tileSize;
            graphics2D.drawString("Yes", xPos, yPos);
            if(optionNum == 0){
                graphics2D.drawString("♡", xPos - 30, yPos);
            }

            yPos += gp.tileSize;
            graphics2D.drawString("No", xPos, yPos);
            if(optionNum == 1){
                graphics2D.drawString("♡", xPos - 30, yPos);
            }
        }
    }

}
