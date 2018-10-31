/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.Component.GameObjects;

/**
 *
 * @author GG.Sunshiners
 */
public class PowerPellet {
    
    /**
     * Sebuah String yang menyimpan id agentd yang bisa terpengaruhi oleh GameObject.
     */
    protected String effectFor;
    
    /**
     * Sebuah String yang menyimpan nama dari GameObject.
     */
    protected String gameObjectName;
    
    private int addScore;
    
    public PowerPellet(int addScore)
    {
        this.addScore = addScore;
        this.effectFor = "Pacman";
        this.gameObjectName = "PowerPellet";
    }

    public int effect() {
        return addScore;
    }

    public String getEffectFor() {
        return effectFor;
    }

    public String getGameObjectName() {
        return gameObjectName;
    }

    public int getAddScore() {
        return addScore;
    }
    
    
    
}
