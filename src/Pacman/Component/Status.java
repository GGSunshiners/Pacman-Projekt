package Pacman.Component;
import Pacman.Engine.Engine;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author GG.Sunshiners
 */
public class Status implements ActionListener{
    
    private int score;
    
    private Timer timer;
    
    private int lives;
    
    private boolean isGameOver;
    
    private Engine engine;
    
    /**
     * Jumlah dari diamond yang harus diambil oleh player
     */
    private int foodTotal;
    
    /**
     * Jumlah dari diamond yang sudah diambil oleh player
     */
    private int foodCount;
    
    public Status(int lives, int foodTotal, Engine engine)
    {
        this.score=0;
        this.timer=new Timer(1000, this);
        this.lives=lives;
        this.isGameOver=false;
        this.engine=engine;
        this.foodCount=0;
        this.foodTotal=foodTotal;
        timer.start();
    }
    
    public void restart(int lives, int foodTotal)
    {
        resetScore();
        resetLives(lives);
        resetFoodCount();
        gameIsStarted();
        timer.start();
    }
    
    public void resetFoodCount() {
        this.foodCount=0;
    }
    
    public void addFoodCount() {
        this.foodCount++;
    }
    
    public int addScore(int score)
    {
        this.score+=score;
        return this.score;
    }
    
    public int resetScore()
    {
        this.score=0;
        return this.score;
    }
    
    public int addLives()
    {
        this.lives++;
        return this.lives;
    }
    
    public int decreaseLives()
    {
        this.lives--;
        return this.lives;
    }
    
    public int resetLives(int lives)
    {
        this.lives=lives;
        return this.lives;
    }
    
    public boolean gameIsOver()
    {
        this.isGameOver=true;
        return this.isGameOver;
    }
    
    public boolean gameIsStarted()
    {
        this.isGameOver=false;
        return this.isGameOver;
    }
    
    public int getScore()
    {
        return this.score;
    }
    
    public int getLives()
    {
        return this.lives;
    }
    
    public boolean getIsGameOver()
    {
        return this.isGameOver;
    }
    
    public void checkSituation()
    {
        if(foodReqChecker()==true)
        {
            engine.playerIsWin();
            timer.stop();
        }
        else if(getIsGameOver()==true)
        {
            engine.playerIsDead();
            timer.stop();
        }
    }

    /**
     * Mencek id item food apakah sudah ada memenuhi untuk menang atau tidak.
     * @return true jika sudah memenuhi dan false jika belum memenuhj.
     */
    public boolean foodReqChecker()
    {
        if(this.foodCount<this.foodTotal)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        checkSituation();
    }
    
}
