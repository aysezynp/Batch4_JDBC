package com.kraft.tests.jdbc_test.day1;

import java.sql.*;

public class Jbdc2_practice {
    public static void main(String[] args) throws SQLException {
        String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
        String dbUsername = "postgres";
        String dbPassword = "Ayseasci1984";


        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from locations");



        //get the locationId, street address and postcode of first row

        resultSet.next();
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        System.out.println("resultSet.getString(3) = " + resultSet.getString(3));

        //hocanın yolu

        String locationIdOFFirstRow=resultSet.getString(1);
        String streetAddressOfFirstRow=resultSet.getString(2);
        String postcodeOfFirstRow=resultSet.getString(3);

        System.out.println("locationIdOFFirstRow = " + locationIdOFFirstRow);
        System.out.println("streetAddressOfFirstRow = " + streetAddressOfFirstRow);
        System.out.println("postcodeOfFirstRow = " + postcodeOfFirstRow);

        System.out.println("...................................");

        //get the locationId, streetAddress, city and region od second row
        resultSet.next();
        System.out.println("resultSet.getString(1) = " + resultSet.getString(1));
        System.out.println("resultSet.getString(2) = " + resultSet.getString(2));
        System.out.println("resultSet.getString(4) = " + resultSet.getString(4));
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));

        System.out.println("...................................");

        //get all information of 5th row

        resultSet.next();
        resultSet.next();
        resultSet.next();
        for (int i = 1; i <= 6; i++) {
            System.out.println(i+"-"+resultSet.getString(i));
        }
        System.out.println("...................................");

       //get the region of the last row

        resultSet.next();
        resultSet.next();
        resultSet.next();
        System.out.println("resultSet.getString(5) = " + resultSet.getString(5));


        resultSet.close();
        statement.close();
        connection.close();
    }
}
