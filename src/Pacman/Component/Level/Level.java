/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.Component.Level;
import Pacman.Component.*;
import Pacman.Component.GameObjects.*;
import java.awt.Point;

/**
 * Class ini berfungsi untuk menginisialisasi time, playerStartingPosition, dan petaLevel
 * yang berisi koordinat, fungsi Maps bisa diliat di javadocs Maps.
 * @author Harseto Pandityo
 * @version 0.1
 */
public class Level {
    
    /**
     * Array 2 dimensi yang mensimulisasikan sebuah Maps dengan koordinat x dan y, more information in Maps
     * javadocs.
     */
    private Maps petaLevel[][];
    
    private Point teleportCoordinate[][];
    
    /**
     * Posisi awal player dalam sebuah level, akan dipakai didalam constructor player.
     */
    private Point playerStartingPosition;
    
    private GameObjects gameObjects;
    
    private int lives;
    
    private Settings setting;
    
    private String playerStartingOrientation;
    
     /**
     * Constructor ini berfungsi untuk membuat point baru untuk playerstartingposition, constructor ini akan
     * diperpanjang di kelas inheritancenya.
     */
    public Level(Settings setting)
    {
        this.playerStartingOrientation="Left";
        this.playerStartingPosition=new Point();
        playerStartingPosition.setLocation(14, 24);
        petaLevel=new Maps[29][32];
        teleportCoordinate=new Point[1][2];
        lives=3;
        this.setting=setting;
    }

    public String getPlayerStartingOrientation() {
        return playerStartingOrientation;
    }
    
    /**
     * Menjalankan seluruh initialize yang ada di level.
     */
    public void initializeLevel()
    {
        this.initializeWalls();
        this.initializeGameObjects();
        this.initializeGameObjectsClass(setting, this);
    }
    
    public void initializeGameObjectsClass(Settings setting, Level level)
    {
        gameObjects=new GameObjects(setting, this);
    }
    
    public void initializeWalls() 
    {
        Maps wall = new Maps("wall", "wall");
        for (int i = 1; i <= 28; i++) {
            petaLevel[i][1]=wall;
        }
        petaLevel[1][2]=wall;
        petaLevel[14][2]=wall;
        petaLevel[15][2]=wall;
        petaLevel[28][2]=wall;
        petaLevel[1][3]=wall;
        for (int i = 3; i <= 6; i++) {
            petaLevel[i][3]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][3]=wall;
        }
        petaLevel[14][3]=wall;
        petaLevel[15][3]=wall;
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][3]=wall;
        }
        petaLevel[22][3]=wall;
        for (int i = 23; i <= 26; i++) {
            petaLevel[i][3]=wall;
        }
        petaLevel[28][3]=wall;
        petaLevel[1][4]=wall;
        for (int i = 3; i <= 6; i++) {
            petaLevel[i][4]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][4]=wall;
        }
        petaLevel[14][4]=wall;
        petaLevel[15][4]=wall;
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][4]=wall;
        }
        for (int i = 23; i <= 26; i++) {
            petaLevel[i][4]=wall;
        }
        petaLevel[28][4]=wall;
        petaLevel[1][5]=wall;
        for (int i = 3; i <= 6; i++) {
            petaLevel[i][5]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][5]=wall;
        }
        petaLevel[14][5]=wall;
        petaLevel[15][5]=wall;
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][5]=wall;
        }
        for (int i = 23; i <= 26; i++) {
            petaLevel[i][5]=wall;
        }
        petaLevel[28][5]=wall;
        petaLevel[1][6]=wall;
        petaLevel[28][6]=wall;
        petaLevel[1][7]=wall;
        for (int i = 3; i <= 6; i++) {
            petaLevel[i][7]=wall;
        }
        petaLevel[8][7]=wall;
        petaLevel[9][7]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][7]=wall;
        }
        petaLevel[20][7]=wall;
        petaLevel[21][7]=wall;
        for (int i = 23; i <= 26; i++) {
            petaLevel[i][7]=wall;
        }
        petaLevel[28][7]=wall;
        petaLevel[1][8]=wall;
        for (int i = 3; i <= 6; i++) {
            petaLevel[i][8]=wall;
        }
        petaLevel[8][8]=wall;
        petaLevel[9][8]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][8]=wall;
        }
        petaLevel[20][8]=wall;
        petaLevel[21][8]=wall;
        for (int i = 23; i <= 26; i++) {
            petaLevel[i][8]=wall;
        }
        petaLevel[28][8]=wall;
        petaLevel[1][9]=wall;
        petaLevel[8][9]=wall;
        petaLevel[9][9]=wall;
        petaLevel[14][9]=wall;
        petaLevel[15][9]=wall;
        petaLevel[20][9]=wall;
        petaLevel[21][9]=wall;
        petaLevel[28][9]=wall;
        for (int i = 1; i <= 6; i++) {
            petaLevel[i][10]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][10]=wall;
        }
        petaLevel[14][10]=wall;
        petaLevel[15][10]=wall;
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][10]=wall;
        }
        for (int i = 23; i <= 28; i++) {
            petaLevel[i][10]=wall;
        }
        petaLevel[6][11]=wall;
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][11]=wall;
        }
        petaLevel[14][11]=wall;
        petaLevel[15][11]=wall;
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][11]=wall;
        }
        petaLevel[23][11]=wall;
        petaLevel[6][12]=wall;
        petaLevel[8][12]=wall;
        petaLevel[9][12]=wall;
        petaLevel[20][12]=wall;
        petaLevel[21][12]=wall;
        petaLevel[23][12]=wall;
        petaLevel[6][13]=wall;
        petaLevel[8][13]=wall;
        petaLevel[9][13]=wall;
        for (int i = 11; i <= 13; i++) {
            petaLevel[i][13]=wall;
        }
        for (int i = 16; i <= 18; i++) {
            petaLevel[i][13]=wall;
        }
        petaLevel[20][13]=wall;
        petaLevel[21][13]=wall;
        petaLevel[23][13]=wall;
        for (int i = 1; i <= 6; i++) {
            petaLevel[i][14]=wall;
        }
        petaLevel[8][14]=wall;
        petaLevel[9][14]=wall;
        petaLevel[11][14]=wall;
        petaLevel[18][14]=wall;
        petaLevel[20][14]=wall;
        petaLevel[21][14]=wall;
        for (int i = 23; i <= 28; i++) {
            petaLevel[i][14]=wall;
        }
        petaLevel[11][15]=wall;
        petaLevel[18][15]=wall;
        for (int i = 1; i <= 6; i++) {
            petaLevel[i][16]=wall;
        }
        petaLevel[8][16]=wall;
        petaLevel[9][16]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][16]=wall;
        }
        petaLevel[20][16]=wall;
        petaLevel[21][16]=wall;
        for (int i = 23; i <= 28; i++) {
            petaLevel[i][16]=wall;
        }
        petaLevel[6][17]=wall;
        petaLevel[8][17]=wall;
        petaLevel[9][17]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][17]=wall;
        }
        petaLevel[20][17]=wall;
        petaLevel[21][17]=wall;
        petaLevel[23][17]=wall;
        petaLevel[6][18]=wall;
        petaLevel[8][18]=wall;
        petaLevel[9][18]=wall;
        petaLevel[20][18]=wall;
        petaLevel[21][18]=wall;
        petaLevel[23][18]=wall;
        petaLevel[6][19]=wall;
        petaLevel[8][19]=wall;
        petaLevel[9][19]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][19]=wall;
        }
        petaLevel[20][19]=wall;
        petaLevel[21][19]=wall;
        petaLevel[23][19]=wall;
        for (int i = 1; i <= 6; i++) {
            petaLevel[i][20]=wall;
        }
        petaLevel[8][20]=wall;
        petaLevel[9][20]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][20]=wall;
        }
        petaLevel[20][20]=wall;
        petaLevel[21][20]=wall;
        for (int i = 23; i <= 28; i++) {
            petaLevel[i][20]=wall;
        }
        petaLevel[1][21]=wall;
        petaLevel[14][21]=wall;
        petaLevel[15][21]=wall;
        petaLevel[28][21]=wall;
        petaLevel[1][22]=wall;
        for (int i = 3; i <= 6; i++) {
            petaLevel[i][22]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][22]=wall;
        }
        petaLevel[14][22]=wall;
        petaLevel[15][22]=wall;
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][22]=wall;
        }
        for (int i = 23; i <= 26; i++) {
            petaLevel[i][22]=wall;
        }
        petaLevel[28][22]=wall;
        petaLevel[1][23]=wall;
        for (int i = 3; i <= 6; i++) {
            petaLevel[i][23]=wall;
        }
        for (int i = 8; i <= 12; i++) {
            petaLevel[i][23]=wall;
        }
        petaLevel[14][23]=wall;
        petaLevel[15][23]=wall;
        for (int i = 17; i <= 21; i++) {
            petaLevel[i][23]=wall;
        }
        for (int i = 23; i <= 26; i++) {
            petaLevel[i][23]=wall;
        }
        petaLevel[28][23]=wall;
        petaLevel[1][24]=wall;
        petaLevel[5][24]=wall;
        petaLevel[6][24]=wall;
        petaLevel[23][24]=wall;
        petaLevel[24][24]=wall;
        petaLevel[28][24]=wall;
        for (int i = 1; i <= 3; i++) {
            petaLevel[i][25]=wall;
        }
        petaLevel[5][25]=wall;
        petaLevel[6][25]=wall;
        petaLevel[8][25]=wall;
        petaLevel[9][25]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][25]=wall;
        }
        petaLevel[20][25]=wall;
        petaLevel[21][25]=wall;
        petaLevel[23][25]=wall;
        petaLevel[24][25]=wall;
        for (int i = 26; i <= 28; i++) {
            petaLevel[i][25]=wall;
        }
        for (int i = 1; i <= 3; i++) {
            petaLevel[i][26]=wall;
        }
        petaLevel[5][26]=wall;
        petaLevel[6][26]=wall;
        petaLevel[8][26]=wall;
        petaLevel[9][26]=wall;
        for (int i = 11; i <= 18; i++) {
            petaLevel[i][26]=wall;
        }
        petaLevel[20][26]=wall;
        petaLevel[21][26]=wall;
        petaLevel[23][26]=wall;
        petaLevel[24][26]=wall;
        for (int i = 26; i <= 28; i++) {
            petaLevel[i][26]=wall;
        }
        petaLevel[1][27]=wall;
        petaLevel[8][27]=wall;
        petaLevel[9][27]=wall;
        petaLevel[14][27]=wall;
        petaLevel[15][27]=wall;
        petaLevel[20][27]=wall;
        petaLevel[21][27]=wall;
        petaLevel[28][27]=wall;
        petaLevel[1][28]=wall;
        for (int i = 3; i <= 12; i++) {
            petaLevel[i][28]=wall;
        }
        petaLevel[14][28]=wall;
        petaLevel[15][28]=wall;
        for (int i = 17; i <= 26; i++) {
            petaLevel[i][28]=wall;
        }
        petaLevel[28][28]=wall;
        petaLevel[1][29]=wall;
        for (int i = 3; i <= 12; i++) {
            petaLevel[i][29]=wall;
        }
        petaLevel[14][29]=wall;
        petaLevel[15][29]=wall;
        for (int i = 17; i <= 26; i++) {
            petaLevel[i][29]=wall;
        }
        petaLevel[28][29]=wall;
        petaLevel[1][30]=wall;
        petaLevel[28][30]=wall;
        for (int i = 1; i <= 28; i++) {
            petaLevel[i][31]=wall;
        }
    }
    
    public void initializeGameObjects() {
        Maps food=new Maps("gameObjects","food");
        Maps powerPellet=new Maps("gameObjects", "powerPellet");
        Maps ghostBase=new Maps("gameObjects", "ghostBase");
        Maps sideTunnel=new Maps("gameObjects", "sideTunnel");
        Maps teleport=new Maps("gameObjects","teleport");
        Maps cherry=new Maps("gameObjects","cherry");
        
        for (int i = 2; i <= 13; i++) {
            petaLevel[i][2]=food;
        }
        for (int i = 16; i <= 27; i++) {
            petaLevel[i][2]=food;
        }
        petaLevel[2][3]=food;
        petaLevel[5][3]=food;
        petaLevel[13][3]=food;
        petaLevel[16][3]=food;
        petaLevel[22][3]=food;
        petaLevel[27][3]=food;
        petaLevel[2][4]=powerPellet;
        petaLevel[5][4]=food;
        petaLevel[13][4]=food;
        petaLevel[16][4]=food;
        petaLevel[22][4]=food;
        petaLevel[27][4]=powerPellet;
        petaLevel[2][5]=food;
        petaLevel[5][5]=food;
        petaLevel[13][5]=food;
        petaLevel[16][5]=food;
        petaLevel[22][5]=food;
        petaLevel[27][5]=food;
        for (int i = 2; i <= 27; i++) {
            petaLevel[i][6]=food;
        }
        petaLevel[2][7]=food;
        petaLevel[7][7]=food;
        petaLevel[10][7]=food;
        petaLevel[19][7]=food;
        petaLevel[22][7]=food;
        petaLevel[27][7]=food;
        petaLevel[2][8]=food;
        petaLevel[7][8]=food;
        petaLevel[10][8]=food;
        petaLevel[19][8]=food;
        petaLevel[22][8]=food;
        petaLevel[27][8]=food;
        for (int i = 2; i <= 7; i++) {
            petaLevel[i][9]=food;
        }
        for (int i = 10; i <= 13; i++) {
            petaLevel[i][9]=food;
        }
        for (int i = 16; i <= 19; i++) {
            petaLevel[i][9]=food;
        }
        for (int i = 22; i <= 27; i++) {
            petaLevel[i][9]=food;
        }
        petaLevel[7][10]=food;
        petaLevel[22][10]=food;
        petaLevel[7][11]=food;
        petaLevel[22][11]=food;
        petaLevel[7][12]=food;
        petaLevel[22][12]=food;
        petaLevel[7][13]=food;
        petaLevel[14][13]=ghostBase;
        petaLevel[15][13]=ghostBase;
        petaLevel[22][13]=food;
        petaLevel[7][14]=food;
        petaLevel[22][14]=food;
        petaLevel[1][15]=teleport;
        teleportCoordinate[0][0]=new Point(1,15);
        for (int i = 2; i <= 6; i++) {
            petaLevel[i][15]=sideTunnel;
        }
        petaLevel[7][15]=food;
        petaLevel[22][15]=food;
        for (int i = 23; i <= 27; i++) {
            petaLevel[i][15]=sideTunnel;
        }
        petaLevel[28][15]=teleport;
        teleportCoordinate[0][1]=new Point(28,15);
        petaLevel[7][16]=food;
        petaLevel[22][16]=food;
        petaLevel[7][17]=food;
        petaLevel[22][17]=food;
        petaLevel[7][18]=food;
        petaLevel[15][18]=cherry;
        petaLevel[22][18]=food;
        petaLevel[7][19]=food;
        petaLevel[22][19]=food;
        petaLevel[7][20]=food;
        petaLevel[22][20]=food;
        for (int i = 2; i <= 13; i++) {
            petaLevel[i][21]=food;
        }
        
        petaLevel[27][23]=food;
        petaLevel[2][24]=powerPellet;
        petaLevel[3][24]=food;
        petaLevel[4][24]=food;
        for (int i = 7; i <= 13; i++) {
            petaLevel[i][24]=food;
        }
        for (int i = 16; i <= 22; i++) {
            petaLevel[i][24]=food;
        }
        petaLevel[25][24]=food;
        petaLevel[26][24]=food;
        petaLevel[27][24]=powerPellet;
        petaLevel[4][25]=food;
        petaLevel[7][25]=food;
        petaLevel[10][25]=food;
        petaLevel[19][25]=food;
        petaLevel[22][25]=food;
        petaLevel[25][25]=food;
        petaLevel[4][26]=food;
        petaLevel[7][26]=food;
        petaLevel[10][26]=food;
        petaLevel[19][26]=food;
        petaLevel[22][26]=food;
        petaLevel[25][26]=food;
        for (int i = 2; i <= 7; i++) {
            petaLevel[i][27]=food;
        }
        for (int i = 10; i <= 13; i++) {
            petaLevel[i][27]=food;
        }
        for (int i = 16; i <= 19; i++) {
            petaLevel[i][27]=food;
        }
        for (int i = 22; i <= 27; i++) {
            petaLevel[i][27]=food;
        }
        petaLevel[2][28]=food;
        petaLevel[13][28]=food;
        petaLevel[16][28]=food;
        petaLevel[27][28]=food;
        petaLevel[2][29]=food;
        petaLevel[13][29]=food;
        petaLevel[16][29]=food;
        petaLevel[27][29]=food;
        for (int i = 2; i <= 27; i++) {
            petaLevel[i][30]=food;
        }
}
    
     /**
     * Method ini berfungsi untuk memanggil attribute time yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Posisi awal seorang player.
     */
    public Point getStartingPosition()
    {
        return this.playerStartingPosition;
    }
    
    public int getLives(){
        return lives;
    }
    
    /**
     * Method ini berfungsi untuk memanggil petaLevel yang akan digunakan 
     * oleh class Board dan Engine.
     * @return Array 2 dimensi semua maps yang mensimulisasikan peta koordinat.
     */
    public Maps[][] getMaps()
    {
        return this.petaLevel;
    }
    
    /**
     * mendapatkan tinggi dari map level
     * @return tinggi map level
     */
    public int getHeight()
    {
        return 0;
    }
    
    /**
     * mendapatkan lebar dari map level
     * @return tinggi map level
     */
    public int getWidth()
    {
        return 0;
    }
    
    /**
     * method ini berfungsi untuk mengembalikan jumlah food dalam level
     * @return jumlah food dalam level
     */
    public int getSumOfFood() 
    {
        return 0;
    }
    
    /**
     * Method ini berfungsi untuk memanggil sebuah array Obstacle yang akan
     * digunakan oleh class Board dan Engine.
     * @return Array dari jenis-jenis Obstacles.
     */
    public GameObjects getGameObjects()
    {
        return this.gameObjects;
    }
    
    /**
     * Method ini berfungsi untuk memanggil sebuah array Obstacle yang akan
     * digunakan oleh class Board dan Engine.
     * @return Array dari jenis-jenis Obstacles.
     */
    public Point[][] getTeleportCoordinate()
    {
        return teleportCoordinate;
    }
}
