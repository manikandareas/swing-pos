package models;

import entities.ProductsEntity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductsModel {

    public static ArrayList<ProductsEntity> getProducts() {
        Connection conn = DatabaseManager.getConnection();
        ArrayList<ProductsEntity> products = new ArrayList<>();

        try {
            String sql = "SELECT * FROM products;";

            ResultSet rs = conn.createStatement().executeQuery(sql);

            while (rs.next()) {
               products.add(new ProductsEntity(
                       rs.getString("id"), rs.getString("name"), rs.getInt("stock"), rs.getString("image"), rs.getInt("price")
               ));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, String.format("Upps somethin went wrong : ", e.getMessage()));
        }
        DatabaseManager.closeConnection(conn);
        return products;
    }

}
