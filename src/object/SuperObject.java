/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import main.GamePanel;
import main.UtilityTool;

/**
 *
 * @author thinh
 */
public class SuperObject {

    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int worldX, worldY;
    public Rectangle soidArea= new Rectangle(0,0,48,48);
    public int soildAreaDefaultX=0;
    public int soildAreaDefaultY=0;
    UtilityTool uTool = new UtilityTool();

    public void draw(Graphics2D g2,GamePanel gp) {
        int screenX = worldX - gp.player.WorldX + gp.player.ScreenX;
        int screenY = worldY - gp.player.WorldY + gp.player.ScreenY;

        if (worldX + gp.tileSize > gp.player.WorldX - gp.player.ScreenX
                && worldX - gp.tileSize < gp.player.WorldX + gp.player.ScreenX
                && worldY + gp.tileSize > gp.player.WorldY - gp.player.ScreenY
                && worldY - gp.tileSize < gp.player.WorldY + gp.player.ScreenY) {
            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
