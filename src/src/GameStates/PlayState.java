package GameStates;

import MainGame.GamePanel;

import java.awt.*;


public class PlayState implements GameState {

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

        gp.player.draw(graphics2D);
    }
}
