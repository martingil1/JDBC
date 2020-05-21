package org.example.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConnection {

    private static Connection con = null;

    public static Connection connectionDB()  {
        if (con == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/test_jdbc", "root", "root");
                System.out.println("conexion aceptada");
            } catch (SQLException | ClassNotFoundException ex) {
                 ex.printStackTrace();
                System.out.println("Error de conexion");
            }
        }
        return con;
    }
}

