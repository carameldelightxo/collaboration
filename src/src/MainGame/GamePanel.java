package MainGame;
import GameStates.*;
import Entity.*;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{ //RyiSnow on YouTube ty ty

    public final int tileSize = 48; //each 1 tile is 48x48 pixels, final means it can't be changed
    final int screenHeight = 12 * tileSize; //576 pixels tall // 12 tiles tall, temp size
    final int screenWidth = 16 * tileSize; //768 pixels wide // 16 tiles tall, temp size

    int fps = 60;

    public PlayerKeyInputs inputHandler = new PlayerKeyInputs();
    public Player player = new Player(this, inputHandler);
    Thread gameThread;

    GameState gameState = new PlayState(this);
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(new Color(255, 192, 203));
        this.setDoubleBuffered(true);

        this.addKeyListener(inputHandler);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){
        double drawInterval= 1000000000.0/fps; //the game's display will be updated 60 times per second
        double delta = 0; //represents difference in time between current time and last checked time
        long lastTime = System.nanoTime(); //returns current time in nanoseconds
        long currentTime = System.nanoTime();

        while(gameThread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if(delta >= 1) {
                //update game info EX: position
                gameState.update();

                //display new info
                repaint();
                delta--;
            }

        }

    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        gameState.paintComponent(graphics);

    }

}