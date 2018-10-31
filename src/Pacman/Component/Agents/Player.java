package Pacman.Component.Agents;
import Pacman.Engine.Engine;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.Timer;

/**
 * Class untuk mengandalikan movement dengan cara memindahkan currentPosition ke posisi yang akan dituju
 * seperti atas, kanan, kiri, bawah dan inventory player dengan cara menyimpan id nama dari item yang bisa 
 * dibandingkan di kelas lain.
 * @author Harseto Pandityo
 * @version 0.1
 */
public class Player implements ActionListener{
    
    /**
     * Sebuah kordinat posisi player pada saat ini yang bertipe Point.
     */
    private Point currentPosition;
    
    /*
    * Kecepatan dari player
    */
    private int speed;
    
    /*
    * Persentase player berhasil dalam cornering
    */
    private int corneringRate;
    
    /**
     * engine yang akan digunakan
     */
    private Engine engine;
    
    private Timer timer;
    
    private String direction;
    
    /**
     * Constructor ini berfungsi untuk menginisialisasikan startingPosition player dalam sebuah level.
     * @param startingPosition Attribute currentPosition.
     * @param speed
     * @param foodTotal menginisialisasi jumlah diamond yang harus diambil
     * @param engine engine yang akan digunakan
     */
    public Player(Point startingPosition, int speed, int corneringRate, String direction, Engine engine)
    {
        this.engine=engine;
        this.speed = speed;
        this.corneringRate = corneringRate;
        currentPosition=new Point();
        currentPosition.setLocation(startingPosition.x, startingPosition.y);
        this.direction=direction;
        this.timer=new Timer(200,this);
        timer.start();
    }

    public String getDirection() {
        return direction;
    }
    
    /**
     * method ini berfungsi untuk menginisialisasikan startingPosition player dalam sebuah level.
     * @param x koordinat x yang dituju
     * @param y koordinat y yang dituju
     * @param foodTotal menginisialisasi jumlah diamond yang harus diambil
     * @param speed
     * @param corneringRate
     */
    public void updatePlayer(int x, int y, int foodTotal, int speed, int corneringRate)
    {
        this.speed = speed;
        this.corneringRate = corneringRate;
        this.currentPosition.setLocation(x, y);
    }
    
    /**
     * method ini berfungsi untuk mengubah posisi (x,y) player saat ini
     * dengan posisi baru
     * @param newPosition posisi baru untuk player
     */
    public void setPosition(Point newPosition)
    {
        this.currentPosition=newPosition;
    }
    
    public Point runMovingConditionChild(String direction)
    {
        int x=0;
        int y=0;
        if(direction.equals("Up"))
        {
            changeDirection("Up");
            System.out.println("Pacman moving up");
            x=(int)(currentPosition.getX());
            y=(int)(currentPosition.getY()-1);
        }
        else if(direction.equals("Left"))
        {
            changeDirection("Left");
            System.out.println("Pacman moving left");
            x=(int)(currentPosition.getX()-1);
            y=(int)(currentPosition.getY());
        }
        else if(direction.equals("Down"))
        {
            changeDirection("Down");
            System.out.println("Pacman moving down");
            x=(int)(currentPosition.getX());
            y=(int)(currentPosition.getY()+1);
        }
        else if(direction.equals("Right"))
        {
            changeDirection("Right");
            System.out.println("Pacman moving right");
            x=(int)(currentPosition.getX()+1);
            y=(int)(currentPosition.getY());
        }
        Point result=new Point(x,y);
        return result;
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
    
    public void changeDirection(String direction)
    {
        this.direction=direction;
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
    
    /**
     * Memanggil kecepatan player pada saat ini
     * untuk digunakan pada class lain.
     * @return Attribute currentPosition.
     */
    public int getSpeed()
    {
        return this.speed;
    }
    
    /**
     * Memanggil persentase player berhasil cornering pada saat ini
     * untuk digunakan pada class lain.
     * @return Attribute currentPosition.
     */
    public int getCorneringRate()
    {
        return this.corneringRate;
    }
    
    /**
     * Memasukan item yang diambil oleh player yang di handle di engine kedalam LinkedList inventory untuk
     * dicek sebagai antiObstacles atau jumlah diamond yang diperlukan untuk keluar.
     * @param itemType id nama dari sebuah item agar bisa dimasukan kedalam Linked List .
     */
    public void takeItem(String itemType)
    {
        if(itemType.contains("food"))
        {
            //foodCount++;
            //engine.updateScore(foodTotal-foodCount);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        engine.runMovingCondition(direction,"Pacman");
    }
}
