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
public class SideTunnel {
    
    /**
     * Sebuah String yang menyimpan id agentd yang bisa terpengaruhi oleh GameObject.
     */
    protected String effectFor;
    
    /**
     * Sebuah String yang menyimpan nama dari GameObject.
     */
    protected String gameObjectName;
    
    private int slowSpeed;
    
    public SideTunnel(int slowSpeed)
    {
        this.slowSpeed = slowSpeed;
        this.effectFor = "Ghost";
        this.gameObjectName = "SideTunnel";
    }

    public int effect() {
        return slowSpeed;
    }
    
}
