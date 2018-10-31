package Pacman.Component.GameObjects;

import Pacman.Component.Level.Level;
import Pacman.Component.Settings;
import java.awt.Point;

/**
 * Class ini berfungsi untuk menyimpan attribute antiObstacle dan menentukan apakah inheritance dari Obstacle
 * berakibat dengan kematian dengan resInDeath.
 * @author Harseto Pandityo
 * @version 0.1
 */
public class GameObjects {
    
    private Cherry cherry;
    
    private Food food;
    
    private GhostBase ghostBase;
    
    private PowerPellet powerPellet;
    
    private SideTunnel sideTunnel;
    
    private Teleport[] teleport;
    
    private Level level;
    
    public GameObjects(Settings settings, Level level)
    {
        this.level=level;
        cherry=new Cherry(settings.getCherryValue());
        food=new Food(settings.getFoodValue());
        ghostBase=new GhostBase();
        powerPellet=new PowerPellet(settings.getPowerPelletValue());
        //param placeholder
        sideTunnel=new SideTunnel(40);
        Point[][] teleportCoordinate=level.getTeleportCoordinate();
        teleport=new Teleport[1];
        for(int i=0;i<1;i++)
        {
            teleport[i]=new Teleport(teleportCoordinate[i][0],teleportCoordinate[i][1]);
        }
    }

    public Cherry getCherry() {
        return cherry;
    }

    public Food getFood() {
        return food;
    }

    public GhostBase getGhostBase() {
        return ghostBase;
    }

    public PowerPellet getPowerPellet() {
        return powerPellet;
    }

    public SideTunnel getSideTunnel() {
        return sideTunnel;
    }

    public Teleport[] getTeleport() {
        return teleport;
    }

    public Level getLevel() {
        return level;
    }
}
