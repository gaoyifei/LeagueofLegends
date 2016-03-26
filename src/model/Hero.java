/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author GaoYifei
 */
public class Hero {
    public int heroID;
    public String heroName;
    public float heroWinrate;
    public int herotimes;
    
    public Hero(){
        
    }
    public Hero(int heroID, String heroName, float heroWinrate, int herotimes){
        this.heroID = heroID;
        this.heroName = heroName;
        this.heroWinrate = heroWinrate;
        this.herotimes = herotimes;
    }
    
}
