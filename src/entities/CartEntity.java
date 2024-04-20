package entities;

import java.util.ArrayList;

public class CartEntity {

    private ArrayList<CartItemEntity> cartItems = new ArrayList<>();

    private int totalPrice = 0;

    private int totalPaid = 0;

    private int kembalian = 0;

    public CartEntity() {
    }

    public ArrayList<CartItemEntity> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItemEntity> cartItems) {
        this.cartItems = cartItems;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(int totalPaid) {
        this.totalPaid = totalPaid;
    }

    public int getKembalian() {
        return kembalian;
    }

    public void setKembalian(int kembalian) {
        this.kembalian = kembalian;
    }
}
