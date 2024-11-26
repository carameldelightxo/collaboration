package GameStates;

import MainGame.GamePanel;
import MainGame.PlayerKeyInputs;

import java.awt.*;

public class PauseState extends GameState {
    private GamePanel gp;
    int optionNum = 0;
    PlayerKeyInputs inputHandler;
    public PauseState(GamePanel gp){
        this.gp = gp;
        this.inputHandler = gp.inputHandler;
    }

    @Override
    public void update() {

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

        if(inputHandler.upPressed && optionNum > 0){
            optionNum--;
            inputHandler.upPressed = false;
        }
        if(inputHandler.downPressed && optionNum < 3){
            optionNum ++;
            inputHandler.downPressed = false;
        }


        drawPauseOptions(xPos, yPos, graphics2D);

        graphics2D.dispose();
    }

    public void drawPauseOptions(int xPos, int yPos, Graphics2D graphics2D){
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



    @Override
    public void changeStates(String state){
        if(state.equals("pause")){
            gp.gameState = new PlayState(gp);
        }
    }
}
