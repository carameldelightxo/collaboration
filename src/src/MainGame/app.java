package MainGame;

import javax.swing.*;

public class app {

    private static void initWindow() {

        JFrame window = new JFrame("Our Boba Game!!! :3");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setResizable(false);
        GamePanel gamePanel = new GamePanel(); //see mainGame.GamePanel class
        window.add(gamePanel);
        window.pack(); //sets window size to specified size in mainGame.GamePanel
        window.setLocationRelativeTo(null); //put window in the middle of the screen
        window.setVisible(true);

        gamePanel.startGameThread();

    }

    public static void main(String[] args) {
        initWindow();
    }



}

