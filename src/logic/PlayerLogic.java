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

/**
 *
 * @author GaoYifei
 */
public class PlayerLogic {
    public DBConnection db = DBConnection.getInstance();
    
    public ArrayList<Player> allPlayers() throws SQLException{
        return db.getAllPlayer();
        
    }
    public void addPlayer(Player player){
        
    }
    public ArrayList playerInfo(Player player) throws SQLException{
        int pID = player.playerID;
        int wins = db.getPlayerWins(pID);
        int loses = db.getPlayerLose(pID);
        int totalTime = db.getTotalTime(pID);
        String commentMap = db.getMostCommonMap(pID);
        String favorEquip = db.getFavorEquip(pID);
        String favorRole = db.getFavorRoles(pID);
        Hero bestHero = new Hero();
        bestHero = db.getBestHero(pID);
        HashMap test = new HashMap();
        test.put("pID", pID);
        test.put("wins", wins);
        test.put("loses", loses);
        test.put("totalTime", totalTime);
        test.put("commentMap", commentMap);
        test.put("favorEquip", favorEquip);
        test.put("favorRule", favorEquip);
        test.put("bestHero", bestHero);
        
        ArrayList result = new ArrayList();
        result.add(wins);
        result.add(loses);
        result.add(totalTime);
        result.add(commentMap);
        result.add(favorEquip);
        result.add(favorRole);
        result.add(bestHero);
        return result;
        
        
    }
    
}
