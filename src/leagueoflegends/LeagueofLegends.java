/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leagueoflegends;
import JDBC.DBConnection;
import java.io.IOException;
import java.sql.SQLException;
import model.Player;
import model.Hero;
import model.Equipment;
import model.Map;
import java.util.ArrayList;

/**
 *
 * @author GaoYifei
 */
public class LeagueofLegends {
    public DBConnection db = DBConnection.getInstance();
    
    public LeagueofLegends() throws SQLException {
        this.init();
        
        //testing Player-oriented SQL
        Player p = new Player();
        p = db.getPlayer(1);
      
        int testwin = db.getPlayerWins(3);
        int testlose = db.getPlayerLose(3);
        String testmap = db.getMostCommonMap(3);
        String testfequip = db.getFavorEquip(3);
        String testfroles = db.getFavorRoles(3);
        int testtotaltime = db.getTotalTime(3);
        Hero testhero = db.getBestHero(3);
        String tstbestequip = db.getFavorEquipOfBestHero(1);
        
        //testing Developer-oriented SQL
        ArrayList<Hero> h = new ArrayList();
        h = db.getOPHero(1);
        
        ArrayList<Equipment> e = new ArrayList();
        e = db.getOPEquip(1);
        
        ArrayList<Map> m = new ArrayList();
        m = db.getMapInfor();
        
        ArrayList<Player> pr = new ArrayList();
        pr = db.getrankDistribute();
        
        //testing Insert and Delete
        int testin = db.insertPlayer(15, "bronze", "cao");
        int testde = db.deletePlayer(10);
        
    }
    
    public void init(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
       System.out.println("Application start");
       LeagueofLegends game = new LeagueofLegends();
      
    }
    
}
