/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import Entity.NPC_oldman;
import object.OBJ_Key;

import object.OBJ_boots;
import object.OBJ_bootsEnd;
import object.OBJ_chest;
import object.OBJ_door;

/**
 *
 * @author thinh
 */
public class AssetSetter {
    GamePanel gp;

    public AssetSetter(GamePanel gp) {
        this.gp = gp;
    }
    public void setObject(){
         
         
        
        
        
        
         gp.obj[8]= new OBJ_door(gp); // lay dooropened day
         gp.obj[8].worldX=12*gp.tileSize;
         gp.obj[8].worldY=23*gp.tileSize;
        
         gp.obj[1]= new OBJ_Key(gp);
         gp.obj[1].worldX=23*gp.tileSize;
         gp.obj[1].worldY=40*gp.tileSize;
         
         gp.obj[2]= new OBJ_Key(gp);
         gp.obj[2].worldX=36*gp.tileSize;
         gp.obj[2].worldY=7*gp.tileSize;
         
      
         
         gp.obj[4]= new OBJ_door(gp); // lay dooropened day
         gp.obj[4].worldX=10*gp.tileSize;
         gp.obj[4].worldY=12*gp.tileSize;
         
         gp.obj[5]= new OBJ_door(gp); // lay dooropened day
         gp.obj[5].worldX=8*gp.tileSize;
         gp.obj[5].worldY=28*gp.tileSize;
         
       
         
         gp.obj[0]= new OBJ_Key(gp);
         gp.obj[0].worldX=23*gp.tileSize;
         gp.obj[0].worldY=7*gp.tileSize;
         
         gp.obj[7]= new OBJ_boots(gp);
         gp.obj[7].worldX=37*gp.tileSize;
         gp.obj[7].worldY=42*gp.tileSize;
           
         gp.obj[6]= new OBJ_chest(gp);
         gp.obj[6].worldX=10*gp.tileSize;
         gp.obj[6].worldY=9*gp.tileSize;
         
         gp.obj[9]= new OBJ_bootsEnd(gp);
         gp.obj[9].worldX=8*gp.tileSize;
         gp.obj[9].worldY=34*gp.tileSize;
         
         
         
         
    }

    public void setNPC(){
        gp.npc[0]= new NPC_oldman(gp);
        gp.npc[0].WorldX=gp.tileSize*21;
        gp.npc[0].WorldY= gp.tileSize*21;
    }

    
    
    
}
