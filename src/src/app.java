import javax.swing.*;
import java.awt.*;

public class app {

    private static void initWindow() {

        JFrame window = new JFrame("Our Boba Game!!! :3");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.add(new GamePanel()); //see GamePanel,
        window.pack(); //sets window size to specified size in GamePanel
        window.setLocationRelativeTo(null); //put window in the middle of the screen
        window.setVisible(true);


    }

    public static void main(String[] args) {
        initWindow();
    }



}
class GamePanel extends JPanel implements Runnable{ //RyiSnow on YouTube ty ty

    final int tileSize = 48; //each 1 tile is 48x48 pixels, final means it can't be changed
    final int screenHeight = 12 * tileSize; //576 pixels tall // 12 tiles tall, temp size
    final int screenWidth = 16 * tileSize; //768 pixels wide // 16 tiles tall, temp size

    Thread gameThread;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run(){

    }
}
