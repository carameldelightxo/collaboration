package GameStates;

import MainGame.GamePanel;

import java.awt.*;

public class PauseState implements GameState {
    private GamePanel gp;

    public PauseState(GamePanel gp){
        this.gp = gp;
    }

    @Override
    public void update() {

    }

    @Override
    public void paintComponent(Graphics graphics) {

    }
}
