/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;



public class UI {
public GamePanel gp;
Graphics2D g2;
public Font arial_40,arial_80B;
//BufferedImage keyimage;

public boolean messageON= false;
public String message="";
int messageCounter=0;
public boolean gameFinished=false;
double playTime;


    public UI(GamePanel gp) {
        this.gp = gp;
         arial_40=new Font("Arial",Font.PLAIN,40);
         arial_80B=new Font("Arial",Font.BOLD,80);
//         OBJ_Key key= new OBJ_Key(gp);
//         keyimage=key.image;
         
    }
    
    public void ShowMessage(String text){
        message=text;
        messageON=true;
    }
    public void draw(Graphics2D g2) {
        
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if (gp.GameState == gp.playState) {
            
        }
        if (gp.GameState == gp.pauseState) {
            drawPauseState();
        }
        
    }

    public void drawPauseState() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,80F));
        String text = "PAUSED";
        int x = getXforCenter(text);
        int y = gp.screenHeight / 2;
        g2.drawString(text, x, y);
    }

    public int getXforCenter(String text) {
        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth /2 - length/2;
        return x;
    }

}
