package com.kraft.tests.jdbc_test.day1;

import java.sql.*;

public class Jdbc1_intro {
    public static void main(String[] args) throws SQLException {
        //Şirketlerde ilgili database e bağlanmak için bu kısmı genel olrak veriyorlar
        //biz burda kendi localimizdekine bağlanıyoruz.

        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "Ayseasci1984";

        //create connection
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);

        // Create a statement object
        Statement statement=connection.createStatement();

        //run query and get the result in result set object
        ResultSet resultSet = statement.executeQuery("select * from employees");

        //move pointer to the next row

        resultSet.next();

        //getting information by column name

        System.out.println(resultSet.getString("employeeId"));
        System.out.println(resultSet.getString("firstname"));

        //getting the information by index number
        System.out.println(resultSet.getString(3));
        System.out.println(resultSet.getString(4));

        System.out.println(".......................................................");
        //move pointer to the 2nd row
        resultSet.next();

        //get phonenumber by the column name
        System.out.println("resultSet.getString(\"phonenumber\") = " + resultSet.getString("phonenumber"));
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));

        System.out.println(".........................................................................................");

        //get all employeeId, firstname and lastname in one shot (starting with 3rd row)

          while(resultSet.next()) {
          System.out.println(resultSet.getString("employeeId")
                              +"-"
                              +resultSet.getString("firstname")
                              +"-"
                              +resultSet.getString("lastname"));
      }

        resultSet.close();
        statement.close();
        connection.close();

    }
}
