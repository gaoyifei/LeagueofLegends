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
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GaoYifei
 */
public class PlayerLogic {
    public DBConnection db = DBConnection.getInstance();
    static private PlayerLogic instance = null;
    
    
    public static PlayerLogic getInstance() {
        // this is not thread-safe but it's ok since we don't have
        // multiple threads accessing the object
        if(instance == null) instance = new PlayerLogic();
        return instance;

    }
    
    public ArrayList<Player> allPlayers(){
        ArrayList<Player> playerList = new ArrayList();
        try {
            
           playerList =  db.getAllPlayer();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return playerList;

    }
    
   
    public void addPlayer(int level, String nickName, String rank) throws SQLException{
        db.insertPlayer( level,  rank,  nickName);
    }

    
    public void deletePlayer(int playerID) throws SQLException{
        db.deletePlayer(playerID);
    }
    
    
    public ArrayList<String> lookUp(int playerID) throws SQLException{
        int pID = playerID;
        Player player = db.getPlayer(pID);
        int wins = db.getPlayerWins(pID);
        int loses = db.getPlayerLose(pID);
        int totalTime = db.getTotalTime(pID);     
        String commentMap = db.getMostCommonMap(pID);
        String favorEquip = db.getFavorEquip(pID);
        Hero bestHero = new Hero();
        bestHero = db.getBestHero(pID);
        String favorRole = db.getFavorRoles(pID);
        String equipBestHero = db.getFavorEquipOfBestHero(playerID);

//        HashMap test = new HashMap();
//        test.put("pID", pID);
//        test.put("wins", wins);
//        test.put("loses", loses);
//        test.put("totalTime", totalTime);
//        test.put("commentMap", commentMap);
//        test.put("favorEquip", favorEquip);
//        test.put("favorRule", favorEquip);
//        test.put("bestHero", bestHero);
        
        ArrayList<String> result = new ArrayList();

        result.add(Integer.toString(wins));
        result.add(Integer.toString(loses));
        result.add(commentMap);
        result.add(favorEquip);
        result.add(Integer.toString(totalTime));
        result.add(bestHero.heroName);
        result.add(Float.toString(bestHero.heroWinrate));
        result.add(equipBestHero);
        result.add(favorRole);

        return result;
    }
    public ArrayList<String> playerInfo(int playerID) throws SQLException{
        int pID = playerID;
        Player player = db.getPlayer(pID);
        int level = player.level;
        String nikeName  = player.nickName;
        String rank = player.rank;
       
        
//        String commentMap = db.getMostCommonMap(pID);
//        String favorEquip = db.getFavorEquip(pID);
//        String favorRole = db.getFavorRoles(pID);
//        Hero bestHero = new Hero();
//        bestHero = db.getBestHero(pID);
//        HashMap test = new HashMap();
//        test.put("pID", pID);
//        test.put("wins", wins);
//        test.put("loses", loses);
//        test.put("totalTime", totalTime);
//        test.put("commentMap", commentMap);
//        test.put("favorEquip", favorEquip);
//        test.put("favorRule", favorEquip);
//        test.put("bestHero", bestHero);
        
        ArrayList<String>result = new ArrayList();
        result.add(Integer.toString(pID));
        result.add(nikeName);
        result.add(rank);
        result.add(Integer.toString(level));
        
//        result.add(commentMap);

//        result.add(favorEquip);
//        result.add(favorRole);
//        result.add(bestHero.heroName);
        
        return result;
        
        
    }
    
}