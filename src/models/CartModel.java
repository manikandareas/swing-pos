/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import entities.CartEntity;
import entities.CartItemEntity;
import entities.ProductsEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author manik
 */
public class CartModel {

    private CartEntity cart = new CartEntity();

    private static CartModel instance;

    private CartModel(){}

    public static synchronized CartModel getInstance(){
        if(instance == null){
            instance = new CartModel();
        }
        return instance;
    }

    public CartEntity getCart() {
        return this.cart;
    }

    public void addCartModelListener(CartModelListener listener){
        listeners.add(listener);
    }

    private void notifyListeners() {
        for (CartModelListener listener : listeners) {
            listener.onCartChanged(cart);
        }
    }

    public interface CartModelListener {
        void onCartChanged(CartEntity cartEntity);
    }

    private List<CartModelListener> listeners = new ArrayList<>();


    public void addToCart(ProductsEntity product) {
        CartItemEntity cartItemEntity = new CartItemEntity(product,1);

        int indexCartFromList = getIndexCartItem(this.cart.getCartItems(), cartItemEntity);

        if (indexCartFromList > -1) {
            CartItemEntity foundItem = this.cart.getCartItems().get(indexCartFromList);

           foundItem.setQuantity(foundItem.getQuantity() + 1);
        }else {
            this.cart.getCartItems().add(cartItemEntity);
        }
        notifyListeners();
    }



    public int getIndexCartItem(ArrayList<CartItemEntity> cartItems, CartItemEntity cartItemEntity) {
        int  foundIndex = -1;
        for (int i = 0; i < cartItems.size(); i++) {
            String idFromList = cartItems.get(i).getProductsEntity().getId();
            String idTarget = cartItemEntity.getProductsEntity().getId();

            if (Objects.equals(idFromList, idTarget)) {
                foundIndex = i;
                break;
            }
        }
        return foundIndex;
    }

}
