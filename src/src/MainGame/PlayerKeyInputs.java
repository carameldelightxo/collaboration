package MainGame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerKeyInputs implements KeyListener {

    public boolean upPressed;
    public boolean downPressed;
    public boolean leftPressed;
    public boolean rightPressed;
    public boolean enterPressed;
    public boolean shiftPressed;
    public boolean spacePressed;

    public GamePanel gp;

    public PlayerKeyInputs(GamePanel gp){
        this.gp = gp;
    }

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
        if(keyCode == KeyEvent.VK_ESCAPE){ //if they press 'ESCAPE'...
            gp.gameState.changeStates("escape");
        }
        if(keyCode == KeyEvent.VK_SPACE){ //if they press 'SPACE'...
            spacePressed = true;
        }
        if(keyCode == KeyEvent.VK_ENTER){ //if they press 'ENTER'...
            enterPressed = true;
        }
        if(keyCode == KeyEvent.VK_SHIFT){ //if they press 'SHIFT'...
            shiftPressed = true;
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
        if(keyCode == KeyEvent.VK_ENTER){ //if they release 'ENTER'...
            enterPressed = false;
        }
        if(keyCode == KeyEvent.VK_SPACE){ //if they release 'SPACE'...
            spacePressed = false;
        }
        if(keyCode == KeyEvent.VK_SHIFT){ //if they release 'SHIFT'...
            shiftPressed = false;
        }
    }
}
