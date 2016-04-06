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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import logic.GameLogic;

/**
 *
 * @author GaoYifei
 */
public class MapPanel extends javax.swing.JPanel {
    MainFrame mainFrame;
    public GameLogic gameLogic = GameLogic.getInstance();
    DefaultTableModel mapModel;
    DefaultTableModel rankModel;
    /**
     * Creates new form mapPanel
     */
    public MapPanel() throws SQLException {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapPane = new javax.swing.JScrollPane();
        mapTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        rankPane = new javax.swing.JScrollPane();
        rankTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mapPic = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1400, 800));

        mapTable.setAutoCreateRowSorter(true);
        mapTable.setBackground(new java.awt.Color(137, 71, 35));
        mapTable.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        mapTable.setForeground(new java.awt.Color(255, 255, 255));
        mapTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Map ID", "Map Name", "Map Size", "Total Played Times"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        mapTable.setRowHeight(30);
        mapTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        mapPane.setViewportView(mapTable);

        jLabel3.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Map  Information");

        rankTable.setAutoCreateRowSorter(true);
        rankTable.setBackground(new java.awt.Color(137, 71, 35));
        rankTable.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        rankTable.setForeground(new java.awt.Color(255, 255, 255));
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
        rankTable.setRowHeight(30);
        rankPane.setViewportView(rankTable);

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Player  Rank ");

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pic/home.png"))); // NOI18N
        jLabel1.setText("Back to Menu");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Map & Rank");

        mapPic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/map/normal.jpg"))); // NOI18N
        mapPic.setText("map pic");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1)
                .addGap(274, 274, 274)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(194, 194, 194))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rankPane, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mapPane, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(155, 155, 155)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(mapPic, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(261, 261, 261))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(mapPane, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(rankPane, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(mapPic, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(430, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        // TODO add your handling code here:
        mainFrame.changePanel(0);
        
    }//GEN-LAST:event_jLabel1MouseClicked

    public void init() throws SQLException{
        mapModel = new DefaultTableModel(
        gameLogic.listMap(),
                new String [] {
                "Map ID", "Map Name", "Map Size", "Total Played Times"
            }
        );
        
        rankModel = new DefaultTableModel(
        gameLogic.rankDistri(),
        new String [] {
                "Rank", "Sum", "Percentage"
            }
        );
        
        mapTable.setModel(mapModel);
        rankTable.setModel(rankModel);
      
        ListSelectionModel selectionModel = mapTable.getSelectionModel();
        
        ListSelectionListener listener = new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(!selectionModel.getValueIsAdjusting()){
                    int row = mapTable.getSelectedRow();
                    if(row == 0){
                        mapPic.setIcon(new ImageIcon(getClass().getResource("/map/normal.jpg"))); 
        
                    }
                    else if(row == 1){
                        mapPic.setIcon(new ImageIcon(getClass().getResource("/map/rank.jpg"))); 
        
                    }
                    else{
                        mapPic.setIcon(new ImageIcon(getClass().getResource("/map/ARAM.jpg"))); 
         
                    }
                }
            }
        
    };
        
        selectionModel.addListSelectionListener(listener);

            
            
        
    }
    @Override
    protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       BufferedImage myImage = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);;
        try{
           myImage = ImageIO.read(new File("src/pic/lol2.png"));} 
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
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane mapPane;
    private javax.swing.JLabel mapPic;
    private javax.swing.JTable mapTable;
    private javax.swing.JScrollPane rankPane;
    private javax.swing.JTable rankTable;
    // End of variables declaration//GEN-END:variables
}
