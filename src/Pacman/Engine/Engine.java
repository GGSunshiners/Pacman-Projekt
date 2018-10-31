package Pacman.Engine;

import Pacman.Component.*;
import Pacman.Component.Level.*;
import Pacman.Component.GameObjects.*;
import Pacman.Component.Status;
import Pacman.Component.Agents.*;
import Pacman.Gui.Board;
import java.awt.Point;

/**
 * Class ini berfungsi sebagai class utama untuk mengoperasikan game Maling Challenge.
 * @author TampanCrew arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class Engine {
    
    /**
     * Attribute player.
     */
    private Player player;
    
    /**
     * Attribute status.
     */
    private Status status;
    
    /**
     * Attribute board.
     */
    private Board board;
    
    /**
     * Attribute array of obstacles. 
     */
    private GameObjects gameObjects; 
    
    /**
     * Attribute 2 array dari Maps.
     */
    private Maps peta[][];
    
    /**
     * Attribute drawer.
     */
    private Drawer drawer;
    
    /**
     * Attribute level yang akan dipakai dalam permainan ini
     */
    private Level stage;
    
    private Settings setting;
    
    private String direction;
    
    /**
     * Constructor ini berfungsi untuk menginisialisasi semua attribute dalam
     * sebuah engine yang diambil dari class level.
     * @param level Level yang sekarang akan dijalankan engine.
     * @param board gui yang digunakan
     */
    public Engine(Level level, Settings setting, Board board)
    {
        stage=level;
        this.setting=setting;
        player=new Player(level.getStartingPosition(), setting.getPacmanSpeed(), setting.getCorneringRate(), level.getPlayerStartingOrientation(), this);
        drawer = new Drawer(level, board, player);
        this.board=board;
        status=new Status(level.getLives(), level.getSumOfFood(), this);
        gameObjects=level.getGameObjects();
        this.peta = level.getMaps();
        updateTotalScore(level.getSumOfFood());
    }
    
    /**
     * method ini adalah semi-constructor
     * dipisahkan dari constructor untuk menghindari terjadinya double engine
     * bila dibuat new Drawer9)
     * @param level level baru yang akan dijalankan
     */
    public void updateNewEngine(Level level, Settings setting)
    {
        this.stage = level;
        this.peta = level.getMaps();
        this.player.updatePlayer(level.getStartingPosition().x, level.getStartingPosition().y, level.getSumOfFood(), setting.getPacmanSpeed(), setting.getCorneringRate());
        this.drawer.repaint();
        this.status.restart(level.getLives(), level.getSumOfFood());
        this.gameObjects=level.getGameObjects();
        this.drawer.updateDrawer(stage, player);
        updateTotalScore(level.getSumOfFood());
    }
    
    /**
     * Memberitahu board bahwa player sudah mati, agar board bisa menampilkan kolom gameOver.
     */
    public void playerIsDead()
    {
        this.board.gameOver();
    }
    
    public void playerIsWin()
    {
        this.board.gameOver();
    }
    
    /**
     * Memberitahu board berapa diamond yang perlu diambil player pada saat ini, agar board bisa menupdatenya
     * @param diamonds Jumlah diamond yang dibutuhkan.
     */
    public void updateTotalScore(int score)
    {
        board.updateScore(score);
    }
    
    public void repaint()
    {
        this.drawer.repaint();
    }

    /**
     * Menentukan kondisi yang dialamin player pada saat dia bergerak, tergantung apa yang ada diarah
     * gerakannya.
     * @param direction direction yang diambil player yang sudah di translate menjadi String yang simpel,
     * 0=Up, 1=left, 2=down, 3=right.
     */
    public void runMovingCondition(String direction, String agent)
    {   
        int x=0;
        int y=0;
        Point movedDirection;
        if(agent.equals("Pacman"))
        {
            movedDirection=this.player.runMovingConditionChild(direction);
            x=movedDirection.x;
            y=movedDirection.y;
            if(this.peta[x][y]!=null)
            {
                if(this.peta[x][y].getType().contains("gameObject"))
                {
                    this.gameObjectsCondition(x,y,direction);
                }
            } 
            else 
            {
                this.player.move(x, y);
                repaint();
            }
        }
        else
        {
            while(true)
            {}
        }
    }
    
    /**
     * Method yang dijalankan oleh runMovingCondition dan tidak bisa dijalankan oleh method lain, berfungsi
     * untuk memanggil suara(To be implemented), pergerakan player dan pengambilan item, dan pendeletetan item.
     * @param x Koordinat x posisi potensi player.
     * @param y Koordinat y posisi potensi player.
     */
    /*public void itemCondition(int x, int y)
    {
        this.player.move(x,y);
        this.player.takeItem(this.peta[x][y].getTypeKind());
        this.peta[x][y]=null;
        this.drawer.drawDeletedItem(x, y);
    }*/
    
    /**
     * Method yang dijalankan oleh runMovingCondition dan tidak bisa dijalankan oleh method lain, berfungsi
     * untuk memanggil suara ketika menabrak obstacles, pergerakan player jika punya item yang merupakan
     * antiObstaclesnya, dan pemanggil playerIsDead jika player menabrak obstacle yang resInDeath=true.
     * @param x Koordinat x posisi potensi player.
     * @param y Koordinat y posisi potensi player.
     */
    public void gameObjectsCondition(int x,int y,String direction)
    {
        if(peta[x][y].getTypeKind().contains("food")){
            peta[x][y]=null;
            this.player.move(x, y);
            status.addFoodCount();
            drawer.drawDeletedItem(x,y);
            status.addScore(setting.getFoodValue());
        }
        else if(peta[x][y].getTypeKind().contains("cherry"))
        {
            peta[x][y]=null;
            this.player.move(x, y);
            drawer.drawDeletedItem(x,y);
            status.addScore(setting.getCherryValue());
        }
        else if(peta[x][y].getTypeKind().contains("powerPellet"))
        {
            peta[x][y]=null;
            this.player.move(x, y);
            drawer.drawDeletedItem(x,y);
            status.addScore(setting.getPowerPelletValue());
        }
        else if(peta[x][y].getTypeKind().contains("teleport"))
        {
            Teleport[] teleport=gameObjects.getTeleport();
            for(int i=0;i<teleport.length;i++)
            {
                Point teleportTo = teleport[i].teleportPoint(x, y);
                if(teleportTo!=null)
                {
                    if(direction.equals("Up"))
                    {
                        this.player.move(teleportTo.x, teleportTo.y-1);
                    }
                    if(direction.equals("Left"))
                    {
                        this.player.move(teleportTo.x-1, teleportTo.y);
                    }
                    if(direction.equals("Down"))
                    {
                        this.player.move(teleportTo.x, teleportTo.y+1);
                    }
                    if(direction.equals("Right"))
                    {
                        this.player.move(teleportTo.x+1, teleportTo.y);
                    }
                }
            }
        }
        else if(peta[x][y].getTypeKind().contains("sideTunnel"))
        {
            this.player.move(x, y);
            //Lower speed if ghost
        }
        else if(peta[x][y].getTypeKind().contains("ghostBase"))
        {
            //Denied entry if not ghost and not fright mode
        }
    }
}