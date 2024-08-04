/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author thinh
 */
public class UtilityTool {
    
    public BufferedImage scaleImage(BufferedImage original,int width, int height){
        BufferedImage scaleImage = new BufferedImage(width, height, original.getType());
        Graphics2D g2= scaleImage.createGraphics();
        g2.drawImage(original,0,0, width,height,null);
        g2.dispose();
        return scaleImage;
    }
}
