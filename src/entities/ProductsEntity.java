package entities;

public class ProductsEntity {
    private String id;
    private String name;
    private int stock;
    private String image;
    private int price;

    public ProductsEntity() {
    }

    public ProductsEntity(String id, String name, int stock, String image, int price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.image = image;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
