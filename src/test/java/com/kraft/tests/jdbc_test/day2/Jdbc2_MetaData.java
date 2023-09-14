package com.kraft.tests.jdbc_test.day2;

import org.testng.annotations.Test;

import java.sql.*;

public class Jdbc2_MetaData {

    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Ayseasci1984";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from employees");

        //get the database related data inside the dbMetadata object

        DatabaseMetaData databaseMetaData=connection.getMetaData();
        System.out.println("databaseMetaData.getUserName() = " + databaseMetaData.getUserName());
        System.out.println("databaseMetaData.getDatabaseProductName() = " + databaseMetaData.getDatabaseProductName());
        System.out.println("databaseMetaData.getDatabaseProductVersion() = " + databaseMetaData.getDatabaseProductVersion());
        System.out.println("databaseMetaData.getDriverName() = " + databaseMetaData.getDriverName());
        System.out.println("databaseMetaData.getDriverVersion() = " + databaseMetaData.getDriverVersion());

        System.out.println(" ");

        //get the result set object metadata
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        //how many columns we have
        System.out.println("resultSetMetaData.getColumnCount() = " + resultSetMetaData.getColumnCount());

        System.out.println(" ");

        //column names
        //index number starts with one

        String nameOfFirstColumn = resultSetMetaData.getColumnName(1);
        String nameOfSecondColumn=resultSetMetaData.getColumnName(2);
        System.out.println("nameOfFirstColumn = " + nameOfFirstColumn);
        System.out.println("nameOfSecondColumn = " + nameOfSecondColumn);

        //print all the column names dynamically
        for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
            System.out.println(i+"-"+resultSetMetaData.getColumnName(i));
        }



        resultSet.close();
        statement.close();
        connection.close();


    }



}
