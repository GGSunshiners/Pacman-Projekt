/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacman.Component;

/**
 *
 * @author GG.Sunshiners
 */
public class Settings {
    
    private int pacmanSpeed;
    
    private int corneringRate;
    
    private int chaseSpeed;
    
    private int frightSpeed;
    
    private int scatterSpeed;
    
    private int coc;
    
    private int viewDistance;
    
    private int foodValue;
    
    private int powerPelletValue;
    
    private int ghostValue;
    
    private int minusPerDistance;
    
    private int cherryValue;
    
    private int frightGhostValue;
    
    public Settings(int pacmanSpeed, int corneringRate, int chaseSpeed, int frightSpeed, int scatterSpeed, int coc, 
            int viewDistance, int foodValue, int powerPelletValue, int ghostValue, int minusPerDistance, int cherryValue,
            int frightGhostValue) {
        this.pacmanSpeed=pacmanSpeed;
        this.corneringRate=corneringRate;
        this.chaseSpeed=chaseSpeed;
        this.frightSpeed=frightSpeed;
        this.scatterSpeed=scatterSpeed;
        this.coc=coc;
        this.viewDistance=viewDistance;
        this.foodValue=foodValue;
        this.powerPelletValue=powerPelletValue;
        this.ghostValue=ghostValue;
        this.minusPerDistance=minusPerDistance;
        this.cherryValue=cherryValue;
        this.frightGhostValue=frightGhostValue;
    }

    public int getPacmanSpeed() {
        return pacmanSpeed;
    }

    public int getCorneringRate() {
        return corneringRate;
    }

    public int getChaseSpeed() {
        return chaseSpeed;
    }

    public int getFrightSpeed() {
        return frightSpeed;
    }

    public int getScatterSpeed() {
        return scatterSpeed;
    }

    public int getCoc() {
        return coc;
    }

    public int getViewDistance() {
        return viewDistance;
    }

    public int getFoodValue() {
        return foodValue;
    }

    public int getPowerPelletValue() {
        return powerPelletValue;
    }

    public int getGhostValue() {
        return ghostValue;
    }

    public int getMinusPerDistance() {
        return minusPerDistance;
    }

    public int getCherryValue() {
        return cherryValue;
    }

    public int getFrightGhostValue() {
        return frightGhostValue;
    }
}
