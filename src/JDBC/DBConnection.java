/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author GaoYifei
 */
public class DBConnection {
    String JDBC_DRIVER= "com.mysql.jdbc.Driver";  
    String DB_URL = "jdbc:mysql://localhost/CS542";
    String USER = "root";
    String PASS = "";
    Connection conn = null;
    
    private int maxPlayerID = 0;
    private int maxMapID = 0;
    private int maxEquipID = 0;
    private int maxHeroID = 0;
    private int maxMatchID = 0;

    static private DBConnection instance = null;

    public static DBConnection getInstance() {
        // this is not thread-safe but it's ok since we don't have
        // multiple threads accessing the object
        if(instance == null) instance = new DBConnection();
        return instance;
    }

    private DBConnection(){
        try {
            File jarPath=new File(DBConnection.class.getProtectionDomain().getCodeSource().getLocation().getPath());
            String propertiesPath=jarPath.getParentFile().getAbsolutePath();

            BufferedReader r = null;

            if(System.getProperty("os.name").startsWith("Windows")) {
                r = new BufferedReader(new FileReader(propertiesPath + "\\user.config"));
            } else {
                r = new BufferedReader(new FileReader(propertiesPath + "/user.config"));
            }

            String line = r.readLine();
            USER = line.split("=")[1].trim();
            line = r.readLine();
            if(line != null && line.split("=").length > 1)
                 PASS = line.split("=")[1].trim();

            r.close();
            } catch (Exception ex) {

            }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();

            String query = "SELECT MAX(playerID) AS MAXPLAYER FROM Player;";
            ResultSet rs = stmt.executeQuery(query);
            if(rs.next()) maxPlayerID = rs.getInt("MAXPLAYER") + 1;
            System.out.println("PlayerID max is " + maxPlayerID);

//            query = "SELECT MAX(mapID) AS MAXMAP FROM Map;";
//            rs = stmt.executeQuery(query);
//            if(rs.next()) maxMapID = rs.getInt("MAXMAP") + 1;
//
//            query = "SELECT MAX(equipID) AS MAXEQUIP FROM Equip;";
//            rs = stmt.executeQuery(query);
//            if(rs.next()) maxEquipID = rs.getInt("MAXEQUIP") + 1;
//
//            query = "SELECT MAX(heroID) AS MAXHERO FROM Hero;";
//            rs = stmt.executeQuery(query);
//            if(rs.next()) maxHeroID = rs.getInt("MAXHERO") + 1;
//            
//            query = "SELECT MAX(matchID) AS MAXMATCH FROM MatchHistory;";
//            rs = stmt.executeQuery(query);
//            if(rs.next()) maxMatchID = rs.getInt("MAXMATCH") + 1;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Problem creating connection.");
        }


    }

    }


 
