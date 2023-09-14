package com.kraft.tests.jdbc_test.day2;

import com.kraft.utilities.DBUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class Jdbc5_DbUtilsPractice {

@Test
    public void listOfMap(){
    //create connection
    DBUtils.createConnection();

    //get all employees information and put them into list of map
    List<Map<String, Object>> list = DBUtils.getQueryResultMap("select * from employees");

    //print information that belongs the employees table
    System.out.println("list = " + list);

    //get the firstname of 5th row
    String actual=(String)list.get(4).get("firstname");
    String expected="Fethi";
    Assert.assertEquals(actual,expected);


    //close connection
    DBUtils.destroy();

}

@Test
    public void oneSingleRow(){
    DBUtils.createConnection();

    //get one row employee information and put them into map
    Map<String, Object> rowMap = DBUtils.getRowMap("select * from employees where firstname='Elif'");
    System.out.println("rowMap = " + rowMap);
    Integer expectedEmployeeId=1010;
    Integer actualEmployeeId=(Integer)rowMap.get("employeeid");
    Assert.assertEquals(actualEmployeeId,expectedEmployeeId);

    DBUtils.destroy();
}
}
