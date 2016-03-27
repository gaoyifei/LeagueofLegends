/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import java.awt.image.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import logic.GameLogic;
import model.Equipment;
import model.Hero;
import model.Map;

/**
 *
 * @author GaoYifei
 */
public class GamePanel extends javax.swing.JPanel {
    MainFrame mainFrame;
    public GameLogic gameLogic = GameLogic.getInstance();
    ArrayList<Map> mapList;
    ArrayList<Hero> heroList;
    ArrayList<Equipment> equipList;
    ArrayList<Hero> heroListOP;
    ArrayList equipListOP;
    ArrayList rankDistri;
    DefaultTableModel equipModel;
    DefaultTableModel heroModel;
    DefaultTableModel mapModel;
    DefaultTableModel rankModel;
    int eFlag;
    int hFlag;
    /**
     * Creates new form GmaePanel
     */
    public GamePanel() throws SQLException {
        
        
        initComponents();
        init();
    }
    private void init() throws SQLException{
        
        eFlag = 0;
        hFlag = 0;
        
        equipModel = new DefaultTableModel(
        gameLogic.listEquip(0),
        new String [] {
                "Equip ID", "Equip Name", "Price", "Types", "Times", "Winrate"
            }
        );
        
        heroModel = new DefaultTableModel(
        gameLogic.listHero(0),
        new String [] {
                "Hero ID", "Hero Name", "Times", "Winrate"
            }
        );
        
        mapModel = new DefaultTableModel(
        gameLogic.listMap(),
                new String [] {
                "Map ID", "Map Name", "Map Size", "Total Time"
            }
        );
        
        rankModel = new DefaultTableModel(
        gameLogic.rankDistri(),
        new String [] {
                "Rank", "Sum", "Percentage"
            }
        );
        
        equipTable.setModel(equipModel);
        heroTable.setModel(heroModel);
        mapTable.setModel(mapModel);
        rankTable.setModel(rankModel);
        
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       BufferedImage myImage = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);;
        try{
           myImage = ImageIO.read(new File("src/pic/lol.png"));} 
        catch (IOException e) {}
        //myImage = getScaledImage(myImage,1080,720);
        
        g.drawImage(myImage, 0, 0, this);
    }
    
    
     private BufferedImage getScaledImage(BufferedImage src, int w, int h){
    int finalw = w;
    int finalh = h;
    double factor = 1.0d;
    if(src.getWidth() > src.getHeight()){
        factor = ((double)src.getHeight()/(double)src.getWidth());
        finalh = (int)(finalw * factor);                
    }else{
        factor = ((double)src.getWidth()/(double)src.getHeight());
        finalw = (int)(finalh * factor);
    }   

    BufferedImage resizedImg = new BufferedImage(finalw, finalh, BufferedImage.TRANSLUCENT);
    Graphics2D g2 = resizedImg.createGraphics();
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(src, 0, 0, finalw, finalh, null);
    g2.dispose();
    return resizedImg;
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        equipPane = new javax.swing.JScrollPane();
        equipTable = new javax.swing.JTable();
        mapPane = new javax.swing.JScrollPane();
        mapTable = new javax.swing.JTable();
        rankPane = new javax.swing.JScrollPane();
        rankTable = new javax.swing.JTable();
        heroPane = new javax.swing.JScrollPane();
        heroTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        equButton = new javax.swing.JButton();
        heroButton = new javax.swing.JButton();
        switchButton = new javax.swing.JLabel();
        simulateButton = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1080, 720));

        equipTable.setAutoCreateRowSorter(true);
        equipTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Equip ID", "Equip Name", "Price", "Types", "Times", "Winrate"
            }
        ));
        equipTable.setOpaque(false);
        equipPane.setViewportView(equipTable);

        mapTable.setAutoCreateRowSorter(true);
        mapTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Map ID", "Map Name", "Map Size", "Total Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mapPane.setViewportView(mapTable);

        rankTable.setAutoCreateRowSorter(true);
        rankTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Rank", "Sum", "Percentage"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        rankPane.setViewportView(rankTable);

        heroTable.setAutoCreateRowSorter(true);
        heroTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Hero ID", "Hero Name", "Times", "Winrate"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        heroPane.setViewportView(heroTable);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Equipment  Statistics");

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hero  Statistics");

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Map  Statistics");

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Player  Rank Statistics");

        equButton.setText("Order By Winrate");
        equButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equButtonMouseClicked(evt);
            }
        });
        equButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                equButtonActionPerformed(evt);
            }
        });

        heroButton.setText("Order By Winrate");
        heroButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                heroButtonMouseClicked(evt);
            }
        });
        heroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heroButtonActionPerformed(evt);
            }
        });

        switchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/queen.png"))); // NOI18N
        switchButton.setToolTipText("Player Info\n");
        switchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                switchButtonMouseClicked(evt);
            }
        });

        simulateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/controller.png"))); // NOI18N
        simulateButton.setToolTipText("Simulate the Game\n");

        jLabel5.setFont(new java.awt.Font("PingFang TC", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Game Statistics");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(87, 87, 87)
                                .addComponent(equButton)
                                .addGap(32, 32, 32))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(mapPane, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(equipPane, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE))))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rankPane, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(heroPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(26, 26, 26)
                        .addComponent(heroButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(simulateButton)
                        .addGap(52, 52, 52))))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(94, 94, 94))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(switchButton)
                            .addComponent(simulateButton))
                        .addGap(77, 77, 77)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(equButton))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(heroButton)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(heroPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(equipPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rankPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mapPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void equButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_equButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_equButtonActionPerformed

    private void heroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heroButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_heroButtonActionPerformed

    private void equButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equButtonMouseClicked
        if(eFlag == 0){
            equButton.setText("List All Equipment");
            eFlag = 1;
        }
        else{
            equButton.setText("Order By Winrate");
            eFlag = 0;
        }
        try {
            // TODO add your handling code here:
            equipModel = new DefaultTableModel(
                    gameLogic.listEquip(eFlag),
                    new String [] {
                        "Equip ID", "Equip Name", "Price", "Types", "Times", "Winrate"
                    }
                    
            );
            
        } catch (SQLException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        equipTable.setModel(equipModel);
    }//GEN-LAST:event_equButtonMouseClicked

    private void heroButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_heroButtonMouseClicked
        // TODO add your handling code here:
        if(hFlag == 0){
            heroButton.setText("List All Hero");
            hFlag = 1;
        }
        else{
            heroButton.setText("Order By Winrate");
            hFlag = 0;
        }
        try {
           
            heroModel = new DefaultTableModel(
                gameLogic.listHero(hFlag),
                new String [] {
                    "Hero ID", "Hero Name", "Times", "Winrate"
                }
            );
            
        } catch (SQLException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        heroTable.setModel(heroModel);
    }//GEN-LAST:event_heroButtonMouseClicked

    private void switchButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_switchButtonMouseClicked
        // TODO add your handling code here:
        mainFrame.changePanel();
    }//GEN-LAST:event_switchButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton equButton;
    private javax.swing.JScrollPane equipPane;
    private javax.swing.JTable equipTable;
    private javax.swing.JButton heroButton;
    private javax.swing.JScrollPane heroPane;
    private javax.swing.JTable heroTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane mapPane;
    private javax.swing.JTable mapTable;
    private javax.swing.JScrollPane rankPane;
    private javax.swing.JTable rankTable;
    private javax.swing.JLabel simulateButton;
    private javax.swing.JLabel switchButton;
    // End of variables declaration//GEN-END:variables
}
