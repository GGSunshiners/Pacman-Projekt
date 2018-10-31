package Pacman.Component.Agents;
//import Chip.Engine.Engine;
import java.awt.Point;
import java.util.LinkedList;

/**
 * Class untuk mengandalikan movement hantu dengan cara memindahkan currentPosition ke posisi yang akan dituju
 * seperti atas, kanan, kiri, bawah dan inventory player dengan cara menyimpan id nama dari item yang bisa 
 * dibandingkan di kelas lain.
 * @author TampanCrew Arts (Harseto and Alvin)
 * @version 1.0 Early Access
 */
public class Ghost {
    
    /**
     * Sebuah kordinat posisi ghost pada saat ini yang bertipe Point.
     */
    private Point currentPosition;
    
    /*
     * Kecepatan ghost dalam mode scatter 
     */
    private int scatSpeed;
    
     /*
     * Kecepatan ghost dalam mode chase 
     */
    private int chaseSpeed;
    
     /*
     * Kecepatan ghost dalam mode frightened
     */
    private int frightSpeed;
    
    /**
     * engine yang akan digunakan
     */
    //private Engine engine;
    
    /**
     * Constructor ini berfungsi untuk menginisialisasikan startingPosition player dalam sebuah level.
     * @param startingPosition Attribute currentPosition.
     * @param foodTotal menginisialisasi jumlah diamond yang harus diambil
     * @param engine engine yang akan digunakan
     */
    public Ghost(Point startingPosition, int scatSpeed, int chaseSpeed, int frightSpeed/*, Engine engine*/)
    {
        //this.engine=engine;
        this.scatSpeed = scatSpeed;
        this.chaseSpeed = chaseSpeed;
        this.frightSpeed = frightSpeed;
        currentPosition=new Point();
        currentPosition.setLocation(startingPosition.x, startingPosition.y);
    }
    
     /**
     * method ini berfungsi untuk menginisialisasikan startingPosition player dalam sebuah level.
     * @param x koordinat x yang dituju
     * @param y koordinat y yang dituju
     * @param foodTotal menginisialisasi jumlah diamond yang harus diambil
     */
    public void updatePlayer(int x, int y, int scatSpeed, int chaseSpeed, int frightSpeed)
    {
        this.scatSpeed = scatSpeed;
        this.chaseSpeed = chaseSpeed;
        this.frightSpeed = frightSpeed;
        this.currentPosition.setLocation(x, y);
    }
    
    /**
     * Memindahkan kordinat player berdasarkan arah
     * yang user arahkan yang sudah di handle di engine.
     * @param x kordinat x setelah player bergerak yang bertipe int.
     * @param y kordinat y setelah player bergerak yang bertipe int.
     */
    public void move(int x, int y)
    {
        this.currentPosition.move(x, y);
    }
    
    /**
     * Memanggil posisi Point player pada saat ini
     * untuk digunakan pada class lain.
     * @return Attribute currentPosition.
     */
    public Point getCurPosition()
    {
        return this.currentPosition;
    }
    
    public int getScatSpeed()
    {
        return this.scatSpeed;
    }
    
    public int getChaseSpeed()
    {
        return this.chaseSpeed;
    }
    
    public int getFrightSpeed()
    {
        return this.frightSpeed;
    }
}
