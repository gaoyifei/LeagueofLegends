/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leagueoflegends;
import JDBC.DBConnection;
import java.io.IOException;
import java.sql.SQLException;


/**
 *
 * @author GaoYifei
 */
public class LeagueofLegends {
    public DBConnection db = DBConnection.getInstance();
    
    public LeagueofLegends() {
        this.init();
    }
    
    public void init(){
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       System.out.println("Application start");
       LeagueofLegends game = new LeagueofLegends();
    }
    
}
