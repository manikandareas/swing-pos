package entities;

public class CartItemEntity {
    private ProductsEntity productsEntity;
    private int quantity;

    public CartItemEntity() {
    }

    public CartItemEntity(ProductsEntity productsEntity, int quantity) {
        this.productsEntity = productsEntity;
        this.quantity = quantity;
    }

    public ProductsEntity getProductsEntity() {
        return productsEntity;
    }

    public void setProductsEntity(ProductsEntity productsEntity) {
        this.productsEntity = productsEntity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

