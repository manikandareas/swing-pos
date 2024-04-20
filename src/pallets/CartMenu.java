/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package pallets;

import entities.CartEntity;
import entities.CartItemEntity;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import models.CartModel;
import raven.swing.AvatarIcon;
import utils.Utils;

/**
 *
 * @author manik
 */
public class CartMenu extends javax.swing.JPanel {
    private static CartModel cartModel;

    /**
     * Creates new form CartMenu
     */
    public CartMenu(CartModel cartModel) {
        initComponents();
        this.cartModel = cartModel;
        init();
        this.pnlCartMain.setLayout(new GridLayout(10, 1));
        lblCart.setIcon(new AvatarIcon(getClass().getResource("/icons/cart.png"), 30, 30, 999));
        txtTotal.setText(Utils.integerToRupiah(cartModel.getCart().getTotalPrice()));

    }

    private void init() {

        cartModel.addCartModelListener(new CartModel.CartModelListener() {
            @Override
            public void onCartChanged(CartEntity cartEntity) {
                pnlCartMain.removeAll();

                pnlCartMain.setLayout(new GridLayout(10, 1));

                ArrayList<Integer> total = new ArrayList<>();

                System.out.println("cart changed");
                for (CartItemEntity item : cartEntity.getCartItems()) {
                    total.add(item.getProductsEntity().getPrice() * item.getQuantity());

                    renderCartItems(item);
                }

                cartModel.getCart().setTotalPrice(total.stream().mapToInt(Integer::intValue).sum());
                txtTotal.setText(Utils.integerToRupiah(cartModel.getCart().getTotalPrice()));
            }
        });
    }

//      CardProduct cardProduct = new CardProduct(product, cartModel);
//        pnlItem.add(cardProduct);
//        cardProduct.setVisible(true);
//        scrollPane.repaint();
//        scrollPane.revalidate();
    public void renderCartItems(CartItemEntity cartItemEntity) {

        CartItem cartItem = new CartItem(cartItemEntity);
        this.pnlCartMain.repaint();

        this.pnlCartMain.add(cartItem);
            cartItem.setVisible(true);
        this.pnlCartMain.revalidate();


    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlCartTitle = new javax.swing.JPanel();
        lblCart = new javax.swing.JLabel();
        pnlCartFooter = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnOrder = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblTotal = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        pnlCartMain = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        pnlCartTitle.setPreferredSize(new java.awt.Dimension(400, 80));
        pnlCartTitle.setRequestFocusEnabled(false);
        pnlCartTitle.setLayout(new java.awt.GridLayout(2, 0));

        lblCart.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        lblCart.setText("Cart");
        pnlCartTitle.add(lblCart);

        add(pnlCartTitle, java.awt.BorderLayout.NORTH);

        pnlCartFooter.setPreferredSize(new java.awt.Dimension(400, 150));
        pnlCartFooter.setLayout(new java.awt.BorderLayout(0, 10));

        jPanel2.setPreferredSize(new java.awt.Dimension(100, 40));
        jPanel2.setLayout(new java.awt.GridLayout());

        btnOrder.setBackground(new java.awt.Color(102, 102, 255));
        btnOrder.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        btnOrder.setForeground(new java.awt.Color(255, 255, 255));
        btnOrder.setText("Order");
        btnOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(btnOrder);

        pnlCartFooter.add(jPanel2, java.awt.BorderLayout.SOUTH);

        jPanel1.setPreferredSize(new java.awt.Dimension(300, 0));
        jPanel1.setLayout(new java.awt.GridLayout(3, 2, 0, 10));

        lblTotal.setText("Total");
        jPanel1.add(lblTotal);

        txtTotal.setEditable(false);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setFocusable(false);
        jPanel1.add(txtTotal);

        jLabel3.setText("Dibayar");
        jPanel1.add(jLabel3);
        jPanel1.add(jTextField2);

        jLabel5.setText("Kembalian");
        jPanel1.add(jLabel5);
        jPanel1.add(jTextField3);

        pnlCartFooter.add(jPanel1, java.awt.BorderLayout.CENTER);

        add(pnlCartFooter, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout pnlCartMainLayout = new javax.swing.GroupLayout(pnlCartMain);
        pnlCartMain.setLayout(pnlCartMainLayout);
        pnlCartMainLayout.setHorizontalGroup(
            pnlCartMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        pnlCartMainLayout.setVerticalGroup(
            pnlCartMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 170, Short.MAX_VALUE)
        );

        add(pnlCartMain, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOrder;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lblCart;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel pnlCartFooter;
    private javax.swing.JPanel pnlCartMain;
    private javax.swing.JPanel pnlCartTitle;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
