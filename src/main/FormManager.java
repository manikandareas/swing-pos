/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import entities.UsersEntity;
import form.Dashboard;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import models.CartModel;
import pallets.MyDrawer;
import raven.drawer.Drawer;
import raven.popup.GlassPanePopup;
import raven.swing.AvatarIcon;

/**
 *
 * @author manik
 */
public class FormManager extends javax.swing.JFrame {

    int xx, xy;
    UsersEntity session;


//    ArrayList<ProductsEntity> products;

    public FormManager(UsersEntity session) {
        GlassPanePopup.install(this);
        MyDrawer myDrawer = new MyDrawer();
        Drawer.getInstance().setDrawerBuilder(myDrawer);

        initComponents();

        setShowedForm(new Dashboard());

        setTitle("Cashier App");
        lblDrawer.setIcon(new AvatarIcon(getClass().getResource("/icons/drawer.png"), 15, 15, 1));
        this.session = session;


    }


    public static void setShowedForm(JPanel form) {
        pnlMain.removeAll();
        pnlMain.repaint();
        pnlMain.add(form);
        form.setVisible(true);
        Drawer.getInstance().closeDrawer();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDrawer = new javax.swing.JPanel();
        lblDrawer = new javax.swing.JLabel();
        pnlMain = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        pnlDrawer.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 10, 0, 0));
        pnlDrawer.setPreferredSize(new java.awt.Dimension(50, 23));
        pnlDrawer.setLayout(new java.awt.BorderLayout());

        lblDrawer.setForeground(new java.awt.Color(0, 0, 0));
        lblDrawer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblDrawer.setPreferredSize(new java.awt.Dimension(30, 30));
        lblDrawer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDrawerMouseClicked(evt);
            }
        });
        pnlDrawer.add(lblDrawer, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlDrawer, java.awt.BorderLayout.WEST);

        pnlMain.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnlMain.setPreferredSize(new java.awt.Dimension(1086, 765));
        pnlMain.setLayout(new java.awt.BorderLayout());
        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(1600, 828));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        // TODO add your handling code here:

        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_formMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xx, y - xy);
    }//GEN-LAST:event_formMouseDragged

    private void lblDrawerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDrawerMouseClicked
        // TODO add your handling code here:
           Drawer.getInstance().showDrawer();
    }//GEN-LAST:event_lblDrawerMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
         FlatLaf.registerCustomDefaultsSource("themes");
         FlatMacLightLaf.setup();



        UIManager.put("TextComponent.arc", 12);
        UIManager.put("PasswordField.showRevealButton", true);
        UIManager.put("JTextField.showClearButton", true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDrawer;
    private javax.swing.JPanel pnlDrawer;
    private static javax.swing.JPanel pnlMain;
    // End of variables declaration//GEN-END:variables
}
