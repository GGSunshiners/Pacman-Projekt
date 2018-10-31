package Pacman.Engine;

import Pacman.Component.Level.Level;
import Pacman.Component.Level.Maps;
import Pacman.Component.Agents.*;
import Pacman.Gui.Board;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Class ini berfungsi untuk mengatur semua keperluan penggambaran terhadap GUI.
 * penggambaran dilakukan dengan ukuran (20pixel x 20pixel) per kotaknya
 * @author Harseto Pandityo
 * @version 0.1
 */
public class Drawer extends JPanel {
    
    /**
     * atribut untuk menyimpan Graphics2D
     */
    private Graphics2D gd;
    
    /**
     * atribut untuk menyimpan alamat gambar
     */
    private URL imgUrl;
    
    /**
     * atribut untuk menampung gambar item dan obstacle yang akan digambar
     */
    private Image itemInMap;
    
    /**
     * atribut untuk menampung gambar karakter yang akan digambar
     */
    private Image character;
    
    /**
     * atribut untuk menampung peta level yang  akan digambar
     */
    private Maps[][] map;
    
    /**
     * atribut untuk menyimpan player
     */
    private Player player;
    
    private Ghost[] ghost;
    
    /**
     * atribut untuk menyimpan nama gambar yang akan digunakan
     */
    private String picName="black.jpg";
    
    /**
     * atribut untuk menyimpan typeKind yang akan dicari dari isi Maps[][]
     */
    private String typeKind="wall";
    
    /**
     * atribut untuk menyimpan level yang akan digambar
     */
    private Level level;
    
    /**
     * constractor dari Drawer
     * method ini berfungsi untuk menginisialisasi level, board dan player
     * @param stage adalah level yang akan digambar
     * @param board adalah GUI yang akan dimasukan kelas ini kedalam salah satu frame nya
     * @param player adalah player yang akan digambar
     */
    public Drawer(Level stage, Board board, Player player) {
        level = stage;
        level.initializeLevel();
        map = level.getMaps();
        this.player = player;
        repaint();
        JFrame f = new JFrame("Pacman Multi Agents By Harseto Pandityo");
        f.getContentPane().add(this);
        f.pack();
        f.setSize(4000, 4000);
        f.setVisible(true);
        board.setGameFrame(this);
        f.setVisible(false);
    }
    
    /**
     * method ini berfungsi untuk mengupdate isi dari level, dan player
     * @param stage adalah level baru yang akan digambar
     * @param player adalah player baru yang akan digambar
     */
    public void updateDrawer(Level stage, Player player)
    {
        this.level=stage;
        level.initializeLevel();
        map=level.getMaps();
        this.player=player;
        repaint();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        gd = (Graphics2D)g;
        imgUrl = getClass().getClassLoader().getResource("Background.png");
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 601; i+=100) {
            for (int j = 0; j < 440; j+=100) {
                gd.drawImage(itemInMap, i, j, 200, 200, null);
            }
        }
        drawDeleteItem();
        drawCharacter(player.getDirection(), "Pacman");
    }
    
    /**
     * menggambar isi dari level ini
     * @param picName nama file gambar yang akan digunakan
     * @param type jenis tipe apa yang akan digambar
     */    
    private void drawGameObjects(String picName, String type)
    {
        imgUrl = getClass().getClassLoader().getResource(picName);
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 29; i++) {
            for (int j = 0; j < 32; j++) {
                if(map[i][j]!=null && map[i][j].getTypeKind().contains(type))
                {
                    gd.drawImage(itemInMap, i*15, j*15, 15, 15, null);
                }
            }
        } 
    }
    
    /**
     * method yang dipanggil untuk menggambar level bila ada item yang menghilang
     * method ini akan memanggil method drawItem(String picName, String typeKind) dan drawObstacle(String picName, String typeKind)
     */
    private void drawDeleteItem() {
        drawGameObjects("Wall.png", "wall");
        drawGameObjects("Food.png", "food");
        drawGameObjects("Power Pellet.png", "powerPellet");
        drawGameObjects("Cherry.png", "cherry");
    }
    
    /**
     * method yang dipanggil untuk menggambar level bila ada item yang menghilang
     * method ini akan memanggil method drawDeletedItem()
     * @param i koordinat x dalam Maps[][] yang akan dihapus
     * @param j koordinat y dalam Maps[][] yang akan dihapus
     */
    public void drawDeletedItem(int i, int j) {
        map[i][j]=null;
        drawDeleteItem();
    }
    
    /**
     * menggambar ulang character dengan character yang sudah berubah arah
     * @param direction arah yang dihadap oleh character
     */
    public void drawCharacter(String direction, String agent)
    {
        String pic = ""+agent+" "+direction+".png";
        imgUrl = getClass().getClassLoader().getResource(pic);
        try {
            character = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        gd.drawImage(character, (int)player.getCurPosition().getX()*15, (int)player.getCurPosition().getY()*15, 15, 15, null);
    }
    
    /**
     * method untuk menggambar obstacle yang ada di level
     * gambar harus dalam format .jpg
     * gambar pintu harus : <warna> door wide.jpg,, dan <warna> door long.jpg 
     * @param picName nama file gambar. untuk pintu tulis warna nya saja
     * @param typeKind jenis dari obstacle yang akan digambar
     */
    /*
    private void drawGameObjects(String picName, String typeKind) {
        String pic="";
        pic = picName+".jpg";
        imgUrl = getClass().getClassLoader().getResource(pic);
        itemInMap = null;
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }        
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getTypeKind().contains(typeKind))
                {
                    int size=0;
                    if(map[i][j+1]!=null && map[i][j+1].getTypeKind().contains(typeKind))
                    {
                        for (int k = j+1; k < 22; k++) {
                            if(map[i][k]!=null && map[i][k].getTypeKind().contains(typeKind))
                            {
                                size++;
                            } else {
                                j=k;
                                break;
                            }
                        }
                        gd.drawImage(itemInMap, i*20, (j-(size+1))*20, 20, (size+1)*20, null);
                    }
                    else if((map[i][j+1]!=null && !map[i][j+1].getTypeKind().contains(typeKind)) || (map[i+1][j]==null))
                    {
                        gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                    }
                }
            }
        }
        
        if(typeKind.contains("Door"))
        {
            pic = picName+" door long.jpg";
        } else {
            pic = picName+"Datar.jpg";
        }
        imgUrl = getClass().getClassLoader().getResource(pic);
        try {
            itemInMap = ImageIO.read(imgUrl);
        } catch (IOException ex) {
            Logger.getLogger(Drawer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < 22; j++) {
                if(map[i][j]!=null && map[i][j].getTypeKind().contains(typeKind))
                {
                    int size=0;
                    if((i+1) < 30 && map[i+1][j]!=null && map[i+1][j].getTypeKind().contains(typeKind))
                    {
                        for (int k = i+1; k < 22; k++) {
                            if(map[k][j]!=null && map[k][j].getTypeKind().contains(typeKind))
                            {
                                size++;
                            } else {
                                i=k;
                                break;
                            }
                        }
                        gd.drawImage(itemInMap, (i-(size+1))*20, j*20, (size+1)*20, 20, null);
                    } else if((map[i][j+1]==null) && (map[i+1][j]!=null && !map[i+1][j].getType().contains(typeKind)))
                    {
                        gd.drawImage(itemInMap, i*20, j*20, 20, 20, null);
                    }
                }
            }
        }
    }
    */
}
