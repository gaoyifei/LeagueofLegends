/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;
import model.Equipment;
import model.Hero;
import model.History;
import model.Player;
import model.Map;
import JDBC.DBConnection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author GaoYifei
 */
public class GameLogic {
    public DBConnection db = DBConnection.getInstance();
    static private GameLogic instance = null;
    
    public static GameLogic getInstance() {
        // this is not thread-safe but it's ok since we don't have
        // multiple threads accessing the object
        if(instance == null) instance = new GameLogic();
        return instance;
    }
    
    public Object[][] listEquip(int option) throws SQLException{
        
        int index;
        int size;
        ArrayList<Equipment> result;
        if(option == 1){
            result = db.getOPEquip(1);
        }
        else{
            result = db.getOPEquip(0);
        }
        size = result.size();
        Object[][] equipList = new Object[size][6];
        index = 0;
        
        while(index <= size - 1){
            
            equipList[index][0] = result.get(index).equipID;
            equipList[index][1] = result.get(index).equipName;
            equipList[index][2] = result.get(index).price;
            equipList[index][3] = result.get(index).types;
            equipList[index][4] = result.get(index).equiptimes;
            equipList[index][5] = result.get(index).equipWinrate + " %";
            index++;
            
        }
        return equipList;
        
    } 
    
 
    
    public Object[][] listHero(int option) throws SQLException{
        int index;
        int size;
        ArrayList<Hero> result;
        if(option == 1){
        result = db.getOPHero(1);
        }
        else{
        result = db.getOPHero(0);
        }
        
        size = result.size();
        Object[][] heroList = new Object[size][4];
        index = 0;
        
        while(index <= size - 1){  
            heroList[index][0] = result.get(index).heroID;
            heroList[index][1] = result.get(index).heroName;
            heroList[index][2] = result.get(index).herotimes;
            heroList[index][3] = result.get(index).heroWinrate + " %";
            index++;
            
        }
        return heroList;
    }
    
    
    
    public Object[][] listMap() throws SQLException{
        int index;
        int size;
        ArrayList<Map> result;
        result = db.getMapInfor();
        size = result.size();
        Object[][] mapList = new Object[size][4];
        index = 0;
        
        while(index <= size - 1){
            
            mapList[index][0] = result.get(index).mapID;
            mapList[index][1] = result.get(index).mapName;
            mapList[index][2] = result.get(index).mapSize;
            mapList[index][3] = result.get(index).totalTime;
            index++;
            
        }
        return mapList;
    }
    
    public Object[][] rankDistri() throws SQLException{
        int index;
        int size;
        ArrayList<Player> result;
        result = db.getrankDistribute();
        size = result.size();
        Object[][] rankList = new Object[size][3];
        index = 0;
        
        while(index <= size - 1){
            
            rankList[index][0] = result.get(index).rank;
            rankList[index][1] = result.get(index).pnumber;
            rankList[index][2] = result.get(index).percentage + " %";
           
            index++;
            
        }
        return rankList;
    }
    
    public void simulate() throws SQLException{
        db.simulateHistory();
    }
}
