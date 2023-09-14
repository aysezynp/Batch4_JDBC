package com.kraft.tests.jdbc_test.day2;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Jbcd4_DynamicList {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Ayseasci1984";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select * from employees");

        //create a resultSetMetaData object to get column-related information
        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        //list for keeping all rows in a list
        List<Map<String,Object>> queryData=new ArrayList<>();

        //get the column number Dynamically
        int columnCount=resultSetMetaData.getColumnCount();

        while(resultSet.next()){
            //create a map that contains row data
            Map<String,Object>map=new HashMap<>();
            for (int i = 1; i <=columnCount ; i++) {
            map.put(resultSetMetaData.getColumnName(i),resultSet.getString(i));
            }
            //add map into list
            queryData.add(map);
        }
        System.out.println("queryData = " + queryData);

        //get the jobid of last row
        System.out.println("queryData.get(queryData.size()-1).get(\"jobid\") = " + queryData.get(queryData.size() - 1).get("jobid"));



        resultSet.close();
        statement.close();
        connection.close();


    }
}
