package GameStates;

import java.awt.*;

public abstract class GameState {
    public abstract void update();
    public abstract void paintComponent(Graphics graphics);
    public abstract void changeStates(String state);

    public void drawSubWindow(int xPos, int yPos, int frameWidth, int frameHeight, Graphics2D graphics2D){
        graphics2D.setColor(new Color(0,0,0,150)); //background = black + low opacity
        graphics2D.fillRoundRect(xPos, yPos, frameWidth, frameHeight, 35, 35);

        graphics2D.setColor(Color.white);
        graphics2D.setStroke(new BasicStroke(5));
        graphics2D.drawRoundRect(xPos + 5, yPos + 5,
                frameWidth - 10, frameHeight - 10, 25, 25);
    }

}
