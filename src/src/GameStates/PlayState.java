package GameStates;

import MainGame.GamePanel;

import java.awt.*;


public class PlayState extends GameState {

    private GamePanel gp;
    public PlayState(GamePanel gamePanel){
        this.gp = gamePanel;
    }
    @Override
    public void update() {
        gp.player.update();
    }

    @Override
    public void paintComponent(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D)graphics;
        gp.tileManager.draw(graphics2D);
        gp.player.draw(graphics2D);

        graphics2D.dispose();
    }

    @Override
    public void changeStates(String state){
        if(state.equals("escape")){
            gp.gameState = new PauseState(gp);
        }
    }
}
