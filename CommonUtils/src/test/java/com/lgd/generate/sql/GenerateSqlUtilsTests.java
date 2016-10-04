package com.lgd.generate.sql;

import org.junit.Test;

/**
 * Created by liguodong on 2016/9/28.
 */
public class GenerateSqlUtilsTests {

//    String tableName="stuedent_info";
//    String[] colName={"name","age"};
//    String[] colValue={"'liguodong'","15"};

    //generateInsertStatement(tableName, colName, colValue);
    String tableName="emp";
    String colNameString = "enpname,\t\n" +
            "salary, \t\t\n" +
            "birthday,\t\n" +
            "age, \t\t\n" +
            "deptId";

    String colValueType = "varchar,\n" +
            "double, \n" +
            "date, \n" +
            "int,\n" +
            "int";
    String colValueString = "";

    //String[] colName={"name","age"};

    //String[] colValue={"'liguodong'","15"};




    @Test
    public void test(){

        String[] insertString = new String[10];

        for (int i = 0; i < insertString.length; i++) {
            String temp = GenerateSqlUtils.execute(tableName,colNameString,colValueType);
            insertString[i] = temp;
        }

        for (String temp : insertString) {
            System.out.println(temp);
        }


        //GenerateSqlUtils.generateInsertStatement(tableName, colName, colNameString);
    }


}
