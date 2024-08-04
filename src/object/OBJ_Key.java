/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

import java.io.IOException;
import javax.imageio.ImageIO;
import main.GamePanel;

/**
 *
 * @author thinh
 */
public class OBJ_Key extends SuperObject{
        GamePanel gp;
    public OBJ_Key(GamePanel gp) {
        name ="Key";
        try {
            image=ImageIO.read(getClass().getResourceAsStream("/Objects/key.png"));
             uTool.scaleImage(image,gp.tileSize, gp.tileSize);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
