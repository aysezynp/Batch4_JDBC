package com.kraft.tests.jdbc_test.day2;

import org.testng.annotations.Test;

import java.sql.*;
import java.util.*;
import java.util.Map;

public class Jdbc3_ListOfMapExamples {
    String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    String dbUsername = "postgres";
    String dbPassword = "Ayseasci1984";

    @Test
    public void test1() throws SQLException {
        Connection connection= DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
        Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet=statement.executeQuery("Select firstname,lastname, salary, jobId from employees");

        List<Map<String,Object>>queryData=new ArrayList<>();

        Map<String,Object>row1=new HashMap<>();
        row1.put("firstname","Eren");
        row1.put("lastname","Çengel");
        row1.put("salary",100000);
        row1.put("jobId","QA");

        Map<String,Object>row2=new HashMap<>();
        row2.put("firstname","Alperen");
        row2.put("lastname","Çengel");
        row2.put("salary",120000);
        row2.put("jobId","Dev");

        System.out.println("row1 = " + row1);
        System.out.println("row2 = " + row2);

        queryData.add(row1);
        queryData.add(row2);

        //get the Eren's lastname directly
        System.out.println("queryData.get(1).get(\"lastname\") = " + queryData.get(0).get("lastname"));

        //get the Alperen's salary
        System.out.println("queryData.get(1).get(\"salary\") = " + queryData.get(1).get("salary"));

//------------------------------------------------------------------------------------------------------------

        //how to fill out a list of map with the information that comes from database

        List<Map<String,Object>>queryData2=new ArrayList<>();

        ResultSetMetaData resultSetMetaData=resultSet.getMetaData();

        // go to the first line
        resultSet.next();

        //create a map that will contain the data of the frist line
        Map<String,Object>row1dynamic=new HashMap<>();
        row1dynamic.put(resultSetMetaData.getColumnName(1),resultSet.getString("firstname"));
        row1dynamic.put(resultSetMetaData.getColumnName(2),resultSet.getString("lastname"));
        row1dynamic.put(resultSetMetaData.getColumnName(3),resultSet.getString("salary"));
        row1dynamic.put(resultSetMetaData.getColumnName(4),resultSet.getString("jobid"));

        System.out.println("row1dynamic = " + row1dynamic);

        //go to second line
        resultSet.next();

        //create a map that will contain the data of the second line
        Map<String,Object>row2dynamic=new HashMap<>();
        row2dynamic.put(resultSetMetaData.getColumnName(1),resultSet.getString("firstname"));
        row2dynamic.put(resultSetMetaData.getColumnName(2),resultSet.getString("lastname"));
        row2dynamic.put(resultSetMetaData.getColumnName(3),resultSet.getString("salary"));
        row2dynamic.put(resultSetMetaData.getColumnName(4),resultSet.getString("jobid"));

        System.out.println("row2dynamic = " + row2dynamic);

        queryData2.add(row1dynamic);
        queryData2.add(row2dynamic);

        System.out.println("queryData2.get(1).get(\"jobid\") = " + queryData2.get(1).get("jobid"));




        resultSet.close();
        statement.close();
        connection.close();


    }
}
