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
import javax.swing.JOptionPane;
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
        
       
        
        equipTable.setModel(equipModel);
        heroTable.setModel(heroModel);
        
        
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       BufferedImage myImage = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);;
        try{
           myImage = ImageIO.read(new File("src/pic/lolBlur.png"));} 
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
        heroPane = new javax.swing.JScrollPane();
        heroTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        equButton = new javax.swing.JButton();
        heroButton = new javax.swing.JButton();
        switchButton = new javax.swing.JLabel();
        simulateButton = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 800));

        equipTable.setAutoCreateRowSorter(true);
        equipTable.setBackground(new java.awt.Color(35, 74, 142));
        equipTable.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        equipTable.setForeground(new java.awt.Color(187, 149, 137));
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

        heroTable.setAutoCreateRowSorter(true);
        heroTable.setBackground(new java.awt.Color(35, 74, 142));
        heroTable.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        heroTable.setForeground(new java.awt.Color(187, 149, 137));
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

        switchButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        switchButton.setForeground(new java.awt.Color(255, 255, 255));
        switchButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/home.png"))); // NOI18N
        switchButton.setText("Back to Menu");
        switchButton.setToolTipText("Player Info\n");
        switchButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                switchButtonMouseClicked(evt);
            }
        });

        simulateButton.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        simulateButton.setForeground(new java.awt.Color(255, 255, 255));
        simulateButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/controller.png"))); // NOI18N
        simulateButton.setText("Simulate Game");
        simulateButton.setToolTipText("Simulate the Game\n");
        simulateButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                simulateButtonMouseClicked(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("PingFang TC", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Game Statistics");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(equipPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 140, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(heroPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addComponent(switchButton, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(equButton)
                        .addGap(161, 161, 161))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(heroButton)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(simulateButton)
                        .addGap(66, 66, 66))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(simulateButton)
                    .addComponent(switchButton)
                    .addComponent(jLabel5))
                .addGap(61, 61, 61)
                .addComponent(jLabel2)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(heroPane, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(heroButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(equButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(equipPane, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(101, Short.MAX_VALUE))
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
            equButton.setText("Order By Times");
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
            heroButton.setText("Order By Times");
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
        mainFrame.changePanel(0);
    }//GEN-LAST:event_switchButtonMouseClicked

    private void simulateButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_simulateButtonMouseClicked
        
        
        try {
            // TODO add your handling code here:
            gameLogic.simulate();
        } catch (SQLException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object[] options = { "OK" };
        JOptionPane.showOptionDialog(null, "Successfully Played a 5v5 Game ! ", "Warning",
        JOptionPane.DEFAULT_OPTION, JOptionPane.YES_OPTION,
        null, options, options[0]);
        try {
            this.init();
        } catch (SQLException ex) {
            Logger.getLogger(GamePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_simulateButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton equButton;
    private javax.swing.JScrollPane equipPane;
    private javax.swing.JTable equipTable;
    private javax.swing.JButton heroButton;
    private javax.swing.JScrollPane heroPane;
    private javax.swing.JTable heroTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel simulateButton;
    private javax.swing.JLabel switchButton;
    // End of variables declaration//GEN-END:variables
}
