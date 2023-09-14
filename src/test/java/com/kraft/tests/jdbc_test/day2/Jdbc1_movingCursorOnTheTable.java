package com.kraft.tests.jdbc_test.day2;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc1_movingCursorOnTheTable {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Ayseasci1984";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from employees");

        //how to find how many rows we have

        resultSet.last();
        int rowCount=resultSet.getRow();
        System.out.println("rowCount = " + rowCount);

        System.out.println(" ");
        //how to go to the firstline
        resultSet.first();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());

        //how to get "Ahmet" firstname directly?
        resultSet.absolute(7);
        System.out.println("resultSet.getString(\"firstname\") = " + resultSet.getString("firstname"));

        System.out.println(" ");

        //how to go sixth row
        resultSet.previous();
        System.out.println("resultSet.getRow() = " + resultSet.getRow());


        resultSet.close();
        statement.close();
        connection.close();


    }




}
