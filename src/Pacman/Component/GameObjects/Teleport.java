/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.Component.GameObjects;

import java.awt.Point;

/**
 *
 * @author GG.Sunshiners
 */
public class Teleport {
    
    /**
     * Sebuah String yang menyimpan id agentd yang bisa terpengaruhi oleh GameObject.
     */
    protected String effectFor;
    
    /**
     * Sebuah String yang menyimpan nama dari GameObject.
     */
    protected String gameObjectName;
    
    private Point teleportFirst;
    
    private Point teleportSecond;
    
    public Teleport(Point teleportFirst, Point teleportSecond)
    {
        this.teleportFirst=teleportFirst;
        this.teleportSecond=teleportSecond;
        this.effectFor = "Both";
        this.gameObjectName = "Teleport";
    }
    
    public Point teleportPoint(int x, int y) {
        if((teleportFirst.x==x)&&(teleportFirst.y==y))
        {
            return teleportSecond;
        }
        else if((teleportSecond.x==x)&&(teleportSecond.y==y))
        {
            return teleportFirst;
        }
        else
        {
            return null;
        }
    }

    public String getEffectFor() {
        return effectFor;
    }

    public String getGameObjectName() {
        return gameObjectName;
    }

    public Point getTeleportFirst() {
        return teleportFirst;
    }

    public Point getTeleportSecond() {
        return teleportSecond;
    }
    
    
}
