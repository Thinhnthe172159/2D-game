/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tile;

import main.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;
import main.UtilityTool;

/**
 *
 * @author thinh
 */
public class TileManager {

    GamePanel gp;
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[50];
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();
        loadMap("/map/world01.txt");
    }

    public void getTileImage() {

//        setup(0, "grass", false);
//        setup(1, "wall", true);
//        setup(2, "water", true);
//        setup(3, "earth", false);
//        setup(4, "tree", true);
//        setup(5, "sand", false);
//        setup(6, "doorOpened", false);
        setup(0, "doorOpened", false);
        setup(1, "doorOpened", false);
        setup(2, "doorOpened", false);
        setup(3, "doorOpened", false);
        setup(4, "doorOpened", false);
        setup(5, "doorOpened", false);
        setup(6, "doorOpened", false);
        setup(7, "doorOpened", false);
        setup(8, "doorOpened", false);
        setup(9, "doorOpened", false);
//        
//place hold
        setup(10, "grass00", false);
        setup(11, "grass01", false);
        setup(12, "water00", true);
        setup(13, "water01", true);
        setup(14, "water02", true);
        setup(15, "water03", true);
        setup(16, "water04", true);
        setup(17, "water05", true);
        setup(18, "water06", true);
        setup(19, "water07", true);
        setup(20, "water08", true);
        setup(21, "water09", true);
        setup(22, "water10", true);
        setup(23, "water11", true);
        setup(24, "water12", true);
        setup(25, "water13", true);
        setup(26, "road00", false);
        setup(27, "road01", false);
        setup(28, "road02", false);
        setup(29, "road03", false);
        setup(30, "road04", false);
        setup(31, "road05", false);
        setup(32, "road06", false);
        setup(33, "road07", false);
        setup(34, "road08", false);
        setup(35, "road09", false);
        setup(36, "road10", false);
        setup(37, "road11", false);
        setup(38, "road12", false);
        setup(39, "earth", false);
        setup(40, "wall", true);
        setup(41, "tree", true);
        setup(42, "doorOpened", false);

    }

    public void setup(int index, String Imagepath, boolean collision) {
        UtilityTool uTool = new UtilityTool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/Tiles/" + Imagepath + ".png"));
            tile[index].image = uTool.scaleImage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;
            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();
                while (col < gp.maxWorldCol) {
                    String number[] = line.split(" ");
                    int num = Integer.parseInt(number[col]);
                    mapTileNum[col][row] = num;
                    col++;
                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;

                }
            }
            br.close();
        } catch (Exception e) {
        }
    }

    public void draw(Graphics2D g2) {
        int WorldCol = 0;
        int WorldRow = 0;

        while (WorldCol < gp.maxWorldCol && WorldRow < gp.maxWorldRow) {
            int tileNum = mapTileNum[WorldCol][WorldRow];

            int worldX = WorldCol * gp.tileSize;
            int worldY = WorldRow * gp.tileSize;
            int screenX = worldX - gp.player.WorldX + gp.player.ScreenX;
            int screenY = worldY - gp.player.WorldY + gp.player.ScreenY;

            if (worldX + gp.tileSize > gp.player.WorldX - gp.player.ScreenX
                    && worldX - gp.tileSize < gp.player.WorldX + gp.player.ScreenX
                    && worldY + gp.tileSize > gp.player.WorldY - gp.player.ScreenY
                    && worldY - gp.tileSize < gp.player.WorldY + gp.player.ScreenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            WorldCol++;

            if (WorldCol == gp.maxWorldCol) {
                WorldCol = 0;

                WorldRow++;

            }

        }
    }
}
