import java.awt.*;

public class playState implements GameState {

    private GamePanel gp;
    public playState(GamePanel gamePanel){
        this.gp = gamePanel;
    }
    @Override
    public void update() {
        if(gp.inputHandler.upPressed){
            gp.yPos -= gp.moveSpeed;
        }
        if(gp.inputHandler.downPressed){
            gp.yPos += gp.moveSpeed;
        }
        if(gp.inputHandler.leftPressed){
            gp.xPos -= gp.moveSpeed;
        }
        if(gp.inputHandler.rightPressed){
            gp.xPos += gp.moveSpeed;
        }
    }

    @Override
    public void paintComponent(Graphics graphics) {

        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics2D.setColor(Color.black);

        graphics2D.fillRect(gp.xPos, gp.yPos, gp.tileSize, gp.tileSize);

        graphics2D.dispose();
    }
}
