/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author GaoYifei
 */
public class Player {
    public int playerID;
    public String nickName;
    public int level;
    public String rank;
    public int pnumber;
    public float percentage;
    
    public Player(){
        
    }
    
    public Player(int playerID, String nickName, String mmr, int level, String rank, int pnumber, float percentage) throws MalformedURLException, IOException{

        this.playerID = playerID;
        this.nickName = nickName;
        this.level = level;
        this.rank = rank;
        this.pnumber = pnumber;
        this.percentage = percentage;


   }
    
}
