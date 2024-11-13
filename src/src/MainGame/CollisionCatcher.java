package MainGame;
import Entity.*;

public class CollisionCatcher {
    GamePanel gp;
    public CollisionCatcher(GamePanel gp){
        this.gp = gp;
    }

    public void checkTile(Entity entity){
        int leftHitBox = entity.hitBox.x;
        int rightHitBox = entity.hitBox.x + entity.hitBox.width;
        int topHitBox = entity.hitBox.y;
        int bottomHitBox = entity.hitBox.y + entity.hitBox.height;

        int leftCol = (leftHitBox + gp.tileSize)/gp.tileSize;
        int rightCol = (rightHitBox + gp.tileSize)/gp.tileSize;
        int topRow = (topHitBox + gp.tileSize)/gp.tileSize;
        int bottomRow = (bottomHitBox + gp.tileSize)/gp.tileSize;
        int tile1;
        int tile2;
        switch(entity.direction){
            case "back":
                topRow = (topHitBox - entity.moveSpeed + gp.tileSize)/gp.tileSize;
                tile1 = gp.tileManager.tileMap[leftCol][topRow];
                tile2 = gp.tileManager.tileMap[rightCol][topRow];
                if(gp.tileManager.tile[tile1].collision || gp.tileManager.tile[tile2].collision){
                    entity.collided = true;
                }
                break;
            case "front":
                bottomRow = (bottomHitBox + entity.moveSpeed + gp.tileSize)/gp.tileSize;
                tile1 = gp.tileManager.tileMap[leftCol][bottomRow];
                tile2 = gp.tileManager.tileMap[rightCol][bottomRow];
                if(gp.tileManager.tile[tile1].collision || gp.tileManager.tile[tile2].collision){
                    entity.collided = true;
                }
                break;
            case "left":
                leftCol = (leftHitBox - entity.moveSpeed + gp.tileSize)/gp.tileSize;
                tile1 = gp.tileManager.tileMap[leftCol][topRow];
                tile2 = gp.tileManager.tileMap[leftCol][bottomRow];
                if(gp.tileManager.tile[tile1].collision || gp.tileManager.tile[tile2].collision){
                    entity.collided = true;
                }
                break;
            case "right":
                rightCol = (rightHitBox + entity.moveSpeed + gp.tileSize)/gp.tileSize;
                tile1 = gp.tileManager.tileMap[rightCol][topRow];
                tile2 = gp.tileManager.tileMap[rightCol][bottomRow];
                if(gp.tileManager.tile[tile1].collision || gp.tileManager.tile[tile2].collision){
                    entity.collided = true;
                }
                break;
        }


    }

}
