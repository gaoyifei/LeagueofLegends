
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import model.Equipment;
import model.Hero;
import model.Map;
import model.Player;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
    
    public ArrayList<Player> getAllPlayer() throws SQLException{
        String query = "SELECT playerID, nikeName, level, rank FROM Player;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<Player> playerList = new ArrayList<Player>();
        while(rs.next());
        {
            Player p = new Player();
            p.level = rs.getInt("level");
            p.nickName = rs.getString("nikeName");
            p.playerID = rs.getInt("playerID");
            p.rank = rs.getString("rank");
            playerList.add(p);
            
        }
        
        
        return playerList;
        
        
        
    }
    
    public Player getPlayer(int playerID) throws SQLException {
        String query = "SELECT playerID, nikeName, level, rank FROM Player WHERE PlayerID = " + playerID + ";";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        Player player = new Player();
        player.level = rs.getInt("level");
        player.nickName = rs.getString("nikeName");
        player.playerID = rs.getInt("playerID");
        player.rank = rs.getString("rank");
        
        
        return player;
        
    }
    
    public int getPlayerWins(int playerID) throws SQLException {
        String query = "SELECT sum(MatchHistory.gameResult) as sumwins "
                    + "FROM MatchHistory "
                    + "WHERE MatchHistory.playerID = " + playerID + " ;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int sumwins = rs.getInt("sumwins");
        
        return sumwins;
        
    }
    
    public int getPlayerLose(int playerID) throws SQLException {
        String query = "SELECT count(MatchHistory.gameResult) as battletimes, sum(MatchHistory.gameResult) as sumwins "
                    + "FROM MatchHistory "
                    + "WHERE MatchHistory.playerID = " + playerID + " ;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int battletimes = rs.getInt("battletimes");
        int sumwins = rs.getInt("sumwins");
        int lose = battletimes - sumwins;
        
        return lose;
        
    }
    
    public String getMostCommonMap(int playerID) throws SQLException {
        String query = "SELECT temp.mapID "
                + "FROM(SELECT GameHistory.mapID,count(GameHistory.mapID) as mapcount "
                    + "FROM GameHistory, MatchHistory "
                    + "WHERE GameHistory.matchID = MatchHistory.matchID and MatchHistory.playerID = " + playerID
                    + " GROUP BY GameHistory.mapID) as temp "
                + "ORDER BY temp.mapcount desc limit 1;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int mapID = rs.getInt("mapID");
        
        String query2 = "SELECT mapName FROM Map WHERE mapID = " + mapID + ";";
        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery(query2);
        rs2.next();
        String mapName = rs2.getString("mapName");
        
        return mapName;
        
    }
    
    public String getFavorEquip(int playerID) throws SQLException {
       String query = "SELECT temp.equipID "
                + "FROM(SELECT MatchHistory.equipID,count(MatchHistory.equipID) as equipcount "
                    + "FROM MatchHistory "
                    + "WHERE MatchHistory.playerID = " + playerID
                    + " GROUP BY MatchHistory.equipID) as temp "
                + "ORDER BY temp.equipcount desc limit 1;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int equipID = rs.getInt("equipID");
        
        String query2 = "SELECT equipName FROM Equipment WHERE equipID = " + equipID + ";";
        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery(query2);
        rs2.next();
        String equipName = rs2.getString("equipName");
        
        return equipName;
        
    }
    
    public String getFavorRoles(int playerID) throws SQLException {
        String query = "SELECT temp.roles "
                + "FROM(SELECT MatchHistory.roles,count(MatchHistory.roles) as rolescount "
                    + "FROM MatchHistory "
                    + "WHERE MatchHistory.playerID = " + playerID
                    + " GROUP BY MatchHistory.roles) as temp "
                + "ORDER BY temp.rolescount desc limit 1;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        String favorroles = rs.getString("roles");
        
        return favorroles;
        
    }
    
    public int getTotalTime(int playerID) throws SQLException {
        String query = "SELECT sum(GameHistory.playingTime) as totaltime "
                    + "FROM GameHistory, MatchHistory "
                    + "WHERE GameHistory.matchID = MatchHistory.matchID and MatchHistory.playerID = " + playerID + " ;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int totaltime = rs.getInt("totaltime");
        
        return totaltime;
        
    }
    
    public Hero getBestHero(int playerID) throws SQLException {
        String query = "SELECT temp.heroID, (temp.sumwins/temp.battletimes) as winrate "
                + "FROM(SELECT MatchHistory.heroID,count(MatchHistory.heroID) as battletimes,sum(MatchHistory.gameResult) as sumwins "
                    + "FROM MatchHistory "
                    + "WHERE MatchHistory.playerID = " + playerID
                    + " GROUP BY MatchHistory.heroID) as temp "
                + "ORDER BY winrate desc limit 1;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        Hero hero = new Hero();
        rs.next();
        hero.heroID = rs.getInt("heroID");
        hero.heroWinrate = rs.getFloat("winrate");
        
        String query2 = "SELECT heroName FROM Hero WHERE heroID = " + hero.heroID + ";";
        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery(query2);
        rs2.next();
        hero.heroName = rs2.getString("heroName");
        
        return hero;
        
    }

    public String getFavorEquipOfBestHero(int playerID) throws SQLException {
        String query = "SELECT temp.heroID, (temp.sumwins/temp.battletimes) as winrate "
                + "FROM(SELECT MatchHistory.heroID,count(MatchHistory.heroID) as battletimes,sum(MatchHistory.gameResult) as sumwins "
                    + "FROM MatchHistory "
                    + "WHERE MatchHistory.playerID = " + playerID
                    + " GROUP BY MatchHistory.heroID) as temp "
                + "ORDER BY winrate desc limit 1;";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        rs.next();
        int heroID = rs.getInt("heroID");
        //float winrate = rs.getFloat("winrate");
        
        String query2 = "SELECT temp.equipID "
                + "FROM(SELECT MatchHistory.equipID,count(MatchHistory.equipID) as equipcount "
                    + "FROM MatchHistory "
                    + "WHERE MatchHistory.playerID = " + playerID + " AND MatchHistory.heroID = " + heroID
                    + " GROUP BY MatchHistory.equipID) as temp "
                + "ORDER BY temp.equipcount desc limit 1;";
        
        Statement stmt2 = conn.createStatement();
        ResultSet rs2 = stmt2.executeQuery(query2);
        rs2.next();
        int equipID = rs2.getInt("equipID");
        
        String query3 = "SELECT equipName FROM Equipment WHERE equipID = " + equipID + ";";
        Statement stmt3 = conn.createStatement();
        ResultSet rs3 = stmt3.executeQuery(query3);
        rs3.next();
        String equipName = rs3.getString("equipName");
        
        return equipName;
        
    }

    

    }



