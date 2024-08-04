    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import javax.swing.JFrame;


public class main {
    public static void main(String [] args ){
        JFrame window= new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Game 2D Thinh Nguyen");
        
        GamePanel gamepanel=new GamePanel();
        window.add(gamepanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        gamepanel.setUpGame();
        gamepanel.startGameThreat();
        
    }
    
}
