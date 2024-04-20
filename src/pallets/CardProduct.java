/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pallets;

import com.formdev.flatlaf.ui.FlatLineBorder;
import entities.CartEntity;
import entities.CartItemEntity;
import entities.ProductsEntity;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JPanel;
import models.CartModel;
import raven.swing.AvatarIcon;
import utils.Utils;

/**
 *
 * @author manik
 */
public class CardProduct extends javax.swing.JPanel {
    ProductsEntity product;
    CartModel cartModel;
    /**
     * Creates new form CardProduct
     */
    public CardProduct(ProductsEntity product, CartModel cartModel) {
        initComponents();
        this.setOpaque(true);
        this.product = product;


        this.cartModel = cartModel;
        this.setBorder(new FlatLineBorder(new Insets(0, 0, 0, 0), Color.GRAY, 0, 20));

        lblPrice.setIcon(new AvatarIcon(getClass().getResource("/icons/price.png"), 13, 13, 1));
        lblStock.setIcon(new AvatarIcon(getClass().getResource("/icons/stock.png"), 13, 13, 1));

        lblName.setText(product.getName());
        lblPrice.setText(Utils.integerToRupiah(product.getPrice()));
        lblStock.setText(String.valueOf(product.getStock()));
        lblImage.setIcon(new AvatarIcon(getClass().getResource(String.format("/storage/products/%s", product.getImage())), 200, 200, 10));

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblImage = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblStock = new javax.swing.JLabel();
        lblAddToCart = new javax.swing.JLabel();
        lblPrice = new javax.swing.JLabel();
        lblName = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(250, 154));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(300, 200));
        setSize(new java.awt.Dimension(250, 300));
        setLayout(new java.awt.BorderLayout());

        lblImage.setPreferredSize(new java.awt.Dimension(150, 150));
        add(lblImage, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setPreferredSize(new java.awt.Dimension(150, 150));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblStock.setFont(new java.awt.Font("Helvetica", 0, 12)); // NOI18N
        lblStock.setText("92");
        jPanel1.add(lblStock, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 118, -1));

        lblAddToCart.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/addToChart.png"))); // NOI18N
        lblAddToCart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblAddToCart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAddToCartMouseClicked(evt);
            }
        });
        jPanel1.add(lblAddToCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, -1, -1));

        lblPrice.setText("10000");
        jPanel1.add(lblPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        lblName.setEditable(false);
        lblName.setColumns(20);
        lblName.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblName.setLineWrap(true);
        lblName.setRows(5);
        lblName.setWrapStyleWord(true);
        lblName.setBorder(null);
        lblName.setFocusable(false);
        lblName.setOpaque(false);
        jPanel1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 38, 144, 50));

        add(jPanel1, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void lblAddToCartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAddToCartMouseClicked
        // TODO add your handling code here:

        cartModel.addToCart(product);
        System.out.println("Size" + cartModel.getCart().getCartItems());
        System.out.println("Qty" + cartModel.getCart().getCartItems().get(0).getQuantity());
    
    }//GEN-LAST:event_lblAddToCartMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAddToCart;
    private javax.swing.JLabel lblImage;
    private javax.swing.JTextArea lblName;
    private javax.swing.JLabel lblPrice;
    private javax.swing.JLabel lblStock;
    // End of variables declaration//GEN-END:variables
}
