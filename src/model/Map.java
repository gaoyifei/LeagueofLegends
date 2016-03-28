/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author GaoYifei
 */
public class Map {
    public int mapID;
    public String mapName;
    //public int maxPlayer;
    public String mapSize;
    public int totalTime;
    
    public Map(){
        
    }
    public Map(int mapID, String mapName, String mapSize,int totalTime) throws MalformedURLException, IOException{
      //  this.mapID=mapID;
        this.mapID = mapID;
        this.mapName = mapName;
        //this.maxPlayer = maxPlayer;
        this.mapSize = mapSize;
        this.totalTime = totalTime;
        
    }
    
}
