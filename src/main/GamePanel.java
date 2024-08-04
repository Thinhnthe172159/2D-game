package main;

import Entity.Entity;
import Entity.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {

    //Screen setting
    final int originalTileSize = 16; //16x16
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;//48x48
    public final int maxScreenCol = 21;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol;//
    public final int screenHeight = tileSize * maxScreenRow;//

    //World setting
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
//    public final int WorldWidth=tileSize*maxScreenCol;
//    public final int WorldHeight=tileSize*maxScreenRow;

    //fps
    int fps = 60;
    //System
    TileManager tileM = new TileManager(this);
    KeyHandler keyH = new KeyHandler(this);
    Sound music = new Sound();
    Sound Se = new Sound();

    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter aSetter = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;

    //Entity and Object
    public Player player = new Player(this, keyH);
    public SuperObject obj[] = new SuperObject[20];
    public Entity npc[] = new Entity[10];

    //Game state 
    public int GameState;
    public final int playState = 1;
    public final int pauseState = 2;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);

    }

    public void setUpGame() {
        aSetter.setObject();
        aSetter.setNPC();
        PlayMusic(0);
      
        GameState = playState;

    }

    public void startGameThreat() {
        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;
        int drawCount = 0;
        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if (delta > 1) {
                update();

                repaint();
                delta--;
                drawCount++;
            }
            if (timer >= 1000000000) {
//               System.out.println("Fps: "+drawCount);
                drawCount = 0;
                timer = 0;
            }
        }
    }

    public void update() {
        if (GameState == playState) {
            //player
            player.update();
            //npc
            for(int i=0;i<npc.length;i++){
                if(npc[i]!=null){
                    npc[i].update();
                }    
            }
        }
        if (GameState == pauseState) {

        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //tile
        tileM.draw(g2);
        // debug
        long drawStart = 0;
        if (keyH.checkDrawTime == true) {
            drawStart = System.nanoTime();
        }
        //tile
        tileM.draw(g2);
        //object
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] != null) {
                obj[i].draw(g2, this);
            }
        }
        //npc
        for (int i = 0; i < npc.length; i++) {
            if (npc[i] != null) {
                npc[i].draw(g2);
            }
            //player
            player.draw(g2);
            ui.draw(g2);
            if (keyH.checkDrawTime == true) {
                long EndDraw = System.nanoTime();
                long passed = EndDraw - drawStart;
                g2.setColor(Color.white);
                g2.drawString("Draw time: " + passed, 10, 400);
                System.out.println("Draw time = " + passed);
            }

            g2.dispose();
        }
    }

    public void PlayMusic(int i) {
        music.setFile(i);
        music.play();
        music.loop();

    }

    public void StopMusic() {
        music.stop();
    }

    public void playSE(int i) {
        Se.setFile(i);
        Se.play();
    }

    private static class Public {

        public Public() {
        }
    }
}
