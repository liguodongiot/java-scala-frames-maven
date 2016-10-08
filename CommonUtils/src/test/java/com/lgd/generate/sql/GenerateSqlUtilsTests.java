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
    String tableName="student_info";
    String colNameString = "stu_name,\n" +
            "stu_age,\n" +
            "stu_score,\n" +
            "stu_date";

    String colValueType = "varchar,\n" +
            "int,\n" +
            "double,\n" +
            "date";
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


    @Test
    public void testBatchInsert(){

        String result = GenerateSqlUtils.executeBatchInsert(tableName,colNameString,colValueType,1000);

        System.out.println("result : "+result);
    }


}
