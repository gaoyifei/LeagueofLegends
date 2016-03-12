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
public class Equipment {
    public int equipID;
    public String equipName;
    public String types;
    public int price;
    
    public Equipment(int equipID, String equipName, String types, int price) throws MalformedURLException, IOException{
       this.equipID = equipID;
       this.equipName = equipName;
       this.types = types;
       this.price = price;
        
        
    }
}
