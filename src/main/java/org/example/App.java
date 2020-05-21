package org.example;

import org.example.Connection.ClassConnection;
import org.example.Services.ProductService;
import org.example.models.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        System.out.println( "Hello World!" );
        Connection connection = ClassConnection.connectionDB();
        System.out.println(connection);
        ProductService ps = new ProductService();
       /* Product product = new Product.Builder()
                .name("Cuaderno")
                .price(23.00)
                .brand("Rivadavia")
                .unit(2)
                .quantity(1)
                .discount(15.00)
                .build();

        ps.save(product);*/


        /*Integer idUpdate = ps.update(new Product.Builder()
                .name("CuadernoModificado2")
                .price(262.00)
                .brand("Rivadavia")
                .unit(4)
                .quantity(22)
                .discount(32.00)
                .build(),1);

        */


    }
}
