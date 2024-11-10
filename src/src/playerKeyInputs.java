import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class playerKeyInputs implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;

    @Override
    public void keyTyped(KeyEvent e) {
        //shrug
    }

    @Override
    public void keyPressed(KeyEvent inputKey) {
        int keyCode = inputKey.getKeyCode();
        //each key the player can press has a number corresponding to it (similar to ASCII), EX: 'A' = 65
        if(keyCode == KeyEvent.VK_W){ //if they press 'W'...
            upPressed = true;
        }
        if(keyCode == KeyEvent.VK_A){ //if they press 'A'...
            leftPressed = true;
        }
        if(keyCode == KeyEvent.VK_S){ //if they press 'S'...
            downPressed = true;
        }
        if(keyCode == KeyEvent.VK_D){ //if they press 'D'...
            rightPressed = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent inputKey) {
        int keyCode = inputKey.getKeyCode();
        if(keyCode == KeyEvent.VK_W){ //if they release 'W'...
            upPressed = false;
        }
        if(keyCode == KeyEvent.VK_A){ //if they release 'A'...
            leftPressed = false;
        }
        if(keyCode == KeyEvent.VK_S){ //if they release 'S'...
            downPressed = false;
        }
        if(keyCode == KeyEvent.VK_D){ //if they release 'D'...
            rightPressed = false;
        }
    }
}
