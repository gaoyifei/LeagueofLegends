<<<<<<< HEAD
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
//hi

/**
 *
 * @author GaoYifei
 */
public class LeagueofLegends {
    public DBConnection db = DBConnection.getInstance();
    
    public LeagueofLegends() throws SQLException {
        this.init();
        Player p = new Player();
        p = db.getPlayer(1);
        
        //testing
        int testwin = db.getPlayerWins(3);
        int testlose = db.getPlayerLose(3);
        String testmap = db.getMostCommonMap(3);
        String testfequip = db.getFavorEquip(3);
        String testfroles = db.getFavorRoles(3);
        int testtotaltime = db.getTotalTime(3);
        Hero testhero = db.getBestHero(3);
        String tstbestequip = db.getFavorEquipOfBestHero(1);
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
=======

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


/**
 *
 * @author GaoYifei
 */
public class LeagueofLegends {
    public DBConnection db = DBConnection.getInstance();
    
    public LeagueofLegends() throws SQLException {
        this.init();
        Player p = new Player();
        p = db.getPlayer(1);
        
        //testing
        int testwin = db.getPlayerWins(3);
        int testlose = db.getPlayerLose(3);
        String testmap = db.getMostCommonMap(3);
        String testfequip = db.getFavorEquip(3);
        String testfroles = db.getFavorRoles(3);
        int testtotaltime = db.getTotalTime(3);
        Hero testhero = db.getBestHero(3);
        String tstbestequip = db.getFavorEquipOfBestHero(1);
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
>>>>>>> master
