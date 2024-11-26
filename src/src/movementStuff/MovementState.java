package movementStuff;

import Entity.*;

import java.awt.image.BufferedImage;

public abstract class MovementState {
    public abstract void updateDirection();
    public abstract BufferedImage displaySprite();
    public abstract void tryMoving(boolean collided);

}
