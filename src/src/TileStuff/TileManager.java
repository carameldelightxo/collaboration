package TileStuff;

import MainGame.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class TileManager {
    GamePanel gp;
    public Tile[] tile;
    public int tileMap[][];

    public TileManager(GamePanel gp){
        this.gp = gp;
        this.tile = new Tile[10];
        this.tileMap = new int[gp.columns + 2][gp.rows + 2];
        getTileImage();
        loadMap();
    }
    public void getTileImage(){
        try{
            tile[0] = new Tile();
            tile[0].collision = true;
            tile[0].image = ImageIO.read(new File("out/res/player/temp_back_SL.png"));

            tile[1] = new Tile();
            tile[1].image = ImageIO.read(new File("out/res/tiles/temp_floor_0.png"));

            tile[2] = new Tile();
            tile[2].collision = true;
            tile[2].image = ImageIO.read(new File("out/res/tiles/example_box.png"));

            tile[3] = new Tile();
            tile[3].collision = true;
            tile[3].image = ImageIO.read(new File("out/res/player/temp_front_SL.png"));
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadMap(){//should pass in the file path instead
        try{
            ArrayList<String> map = new ArrayList<>(Files.readAllLines(Paths.get("out/res/maps/base_map_00.txt")));
            for(int row = 0; row < gp.rows + 2; row++){
                String line = map.get(row);
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(" ")));
                for(int column = 0; column < gp.columns + 2; column++){
                    tileMap[column][row] = Integer.parseInt(splits.get(column));
                }
            }
        }
        catch(Exception e){
            System.out.println("load map failed");
            for(int row = 0; row < gp.rows + 2; row++){
                for(int column = 0; column < gp.columns + 2; column++){
                    tileMap[column][row] = 2;
                }
            }
        }
    }

    public void draw(Graphics2D graphics2D){
        int x;
        int y = 0 - gp.tileSize;
        //graphics2D.drawImage(tile[0].image, x, y, gp.tileSize, gp.tileSize, null);
        //^^if we make one map image we can do it like this

        for(int row = 0; row < gp.rows + 2; row++){
            x = 0 - gp.tileSize;
            for(int column = 0; column < gp.columns + 2; column++){
                int tileNum = tileMap[column][row];
                graphics2D.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
                x+= gp.tileSize;
            }
            y += gp.tileSize;
        }

    }
}
