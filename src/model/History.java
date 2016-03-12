/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author GaoYifei
 */
public class History {
    
    public int matchID;
    public int playerID;
    public int equipID;
    public int mapID;
    public ArrayList<Player> playerList;
    public Equipment equip;
    public Map map;
    public boolean gameResult;
    public String roles;
    public int playingTime;
    
    public History(){
        
    }
    
    
}
