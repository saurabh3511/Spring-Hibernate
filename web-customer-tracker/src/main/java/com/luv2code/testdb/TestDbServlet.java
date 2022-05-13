package com.luv2code.testdb;



import java.sql.Connection;
import java.sql.DriverManager;

public class TestDbServlet {
    public static void main(String[] args) {

        String jdbcUrl = "jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
        String user = "springstudent";
        String pass = "Mysql@123";

        try {
            System.out.println("Connecting to database: " + jdbcUrl);

            Connection myConn =
                    DriverManager.getConnection(jdbcUrl, user, pass);

            System.out.println("Connection successful!!!");

        }
        catch (Exception exc) {
            exc.printStackTrace();
        }

    }
}

