package org.example.Services;

import org.example.Connection.ClassConnection;
import org.example.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    Connection connection = ClassConnection.connectionDB();

    public void save(Product p) throws SQLException {
        try {
            PreparedStatement stmt = connection.prepareStatement("INSERT INTO products (name,price,brand,unit,quantity,discount) VALUES (?,?,?,?,?,?)");
            stmt.setString(1, p.getName());
            stmt.setDouble(2, p.getPrice());
            stmt.setString(3, p.getBrand());
            stmt.setInt(4, p.getUnit());
            stmt.setInt(5, p.getQuantity());
            stmt.setDouble(6, p.getDiscount());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAll() throws SQLException {
        List<Product> products = new ArrayList<>();
        try {

            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from products");

            while (rs.next()) {
                products.add(new Product.Builder()
                        .name(rs.getString("name"))
                        .price(rs.getDouble("price"))
                        .brand(rs.getString("brand"))
                        .unit(rs.getInt("unit"))
                        .quantity(rs.getInt("quantity"))
                        .discount(rs.getDouble("discount"))
                        .build());
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Excepto");
            e.printStackTrace();
        }
        return products;
    }


    public Integer update(Product product,Integer idProduct) throws SQLException {

        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE products SET  name= ?, price = ?, brand = ?, unit = ?, quantity = ?, discount = ? WHERE id_product = ?");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setString(3, product.getBrand());
            ps.setInt(4, product.getUnit());
            ps.setInt(5, product.getQuantity());
            ps.setDouble(6, product.getDiscount());
            ps.setInt(7, idProduct);
            Integer rowsAffected = ps.executeUpdate();
            ps.close();
            return rowsAffected;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;

    }


    public void delete(Integer idProduct){

        try {
            PreparedStatement ps = connection.prepareStatement( "delete from products where id = ?");
            ps.setInt(1, idProduct);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
