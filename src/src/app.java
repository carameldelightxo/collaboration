import javax.swing.*;
import java.awt.*;

public class app {

    private static void initWindow() {

        JFrame window = new JFrame("Our Boba Game!!! :3");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        GamePanel gamePanel = new GamePanel(); //see GamePanel class
        window.add(gamePanel);
        window.pack(); //sets window size to specified size in GamePanel
        window.setLocationRelativeTo(null); //put window in the middle of the screen
        window.setVisible(true);

        gamePanel.startGameThread();

    }

    public static void main(String[] args) {
        initWindow();
    }



}
class GamePanel extends JPanel implements Runnable{ //RyiSnow on YouTube ty ty

    final int tileSize = 48; //each 1 tile is 48x48 pixels, final means it can't be changed
    final int screenHeight = 12 * tileSize; //576 pixels tall // 12 tiles tall, temp size
    final int screenWidth = 16 * tileSize; //768 pixels wide // 16 tiles tall, temp size
    int fps = 60;
    int xPos = 100;
    int yPos = 100;
    int moveSpeed = 1;
    playerKeyInputs inputHandler = new playerKeyInputs();
    Thread gameThread;
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
                System.out.println(delta);
                //update game info EX: position
                update();

                //display new info
                repaint();
                delta--;
            }

        }

    }
    public void update(){

        if(inputHandler.upPressed){
            yPos -= moveSpeed;
        }
        if(inputHandler.downPressed){
            yPos += moveSpeed;
        }
        if(inputHandler.leftPressed){
            xPos -= moveSpeed;
        }
        if(inputHandler.rightPressed){
            xPos += moveSpeed;
        }
    }

    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics2D.setColor(Color.black);

        graphics2D.fillRect(xPos, yPos, tileSize, tileSize);

        graphics2D.dispose();
    }

}
