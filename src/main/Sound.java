/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author thinh
 */
public class Sound {
    Clip clip;
    URL soundURL[]= new URL[30];

    public Sound() {
        soundURL[0]=getClass().getResource("/Sound/Zelda.wav");
        soundURL[1]=getClass().getResource("/Sound/coin.wav");
        soundURL[2]=getClass().getResource("/Sound/fanfare.wav");
        soundURL[3]=getClass().getResource("/Sound/powerup.wav");
        soundURL[4]=getClass().getResource("/Sound/unlock.wav");
        soundURL[5]=getClass().getResource("/Sound/unlock.wav");
    }
    public void setFile(int i){
        try {
            AudioInputStream ais= AudioSystem.getAudioInputStream(soundURL[i]);
            clip= AudioSystem.getClip();
            clip.open(ais);
        } catch (Exception e) {
       
        }
        
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
