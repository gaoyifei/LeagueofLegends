/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import logic.PlayerLogic;

import javax.swing.*;
import java.awt.*;
import javax.imageio.*;
import view.ImagePanel;
import java.lang.Object;
import java.io.*;
import java.awt.image.*;

/**
 *
 * @author GaryFolder
 */

public class jFrame extends javax.swing.JFrame {
/**
* Resizes an image using a Graphics2D object backed by a BufferedImage.
* @param srcImg - source image to scale
* @param w - desired width
* @param h - desired height
* @return - the new resized image
*/
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
     * Creates new form NewJFrame
     */
    public PlayerLogic playerLogic = PlayerLogic.getInstance();
    public jFrame() {
        BufferedImage myImage = new BufferedImage(5, 5, BufferedImage.TYPE_INT_ARGB);;
        try{
           myImage = ImageIO.read(new File("yasuo.jpg"));} 
        catch (IOException e) {}
        myImage = getScaledImage(myImage,900,500);
        setContentPane(new ImagePanel(myImage));
        setTitle("League of Legends Analysis Interface");
    
        initComponents();
  //     setSize(1400,800);
    //    Graphics2D g2 = myImage.createGraphics();
        
       // jPanel1.paintComponent(g2);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new PlayersPanel();
        c1 = new CardLayout();
        jPanel2.setLayout(c1);
        jPanel2.add(jPanel3, "administrator");
        jPanel2.add(jPanel1, "players");
        jButton4 = new javax.swing.JButton();
        
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        
        jButton4.setText("switch");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton4);
        jPanel1.jButton3.setText("switch");
        jPanel1.jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
        );
        //show()
        c1.show(jPanel2,"players");
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        c1.show(jPanel2,"players");
    }      

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
   //     jFrame.c1.show(jFrame.jPanel2,"administrators");
        c1.show(jPanel2,"administrator");
        
    }  
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jFrame().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private CardLayout c1;
    private PlayersPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}