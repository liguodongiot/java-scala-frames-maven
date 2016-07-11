package com.lgd.generate.sql;

import com.lgd.vo.BaseVo;
import com.lgd.vo.ColumnValueVo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liguodong on 2016/7/11.
 */
public class GenerateSqlUtils {


    /**
     * INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
     * @param tableName
     */
    public static void generateInsertStatement(String tableName,String[] colName,String[] colValue){

        String template = "INSERT INTO '%s' (%s) VALUES (%s);";

        StringBuilder colNameStr = new StringBuilder();
        StringBuilder colValueStr = new StringBuilder();


        for (int i = 0; i < colName.length; i++) {

            colNameStr.append(colName[i]);
            if(i!=colName.length-1){
                colNameStr.append(",");
            }

        }

        for (int i = 0; i < colValue.length; i++) {
            colValueStr.append(colValue[i]);
            if(i!=colValue.length-1){
                colValueStr.append(",");
            }
        }
        System.out.println(String.format(template, tableName, colNameStr.toString(), colValueStr.toString()));


    }

    public static void generateInsertStatement(String tableName, String[] colName,List<String[]> colValue){

        for (String[] temp:colValue){
            generateInsertStatement(tableName,colName,temp);
        }

    }


    public static void generateInsertStatementVo(String tableName, String[] colName,List<BaseVo> colValue){

        for (BaseVo temp:colValue){
           // generateInsertStatement(tableName,colName,temp);
        }

    }


    public static void main(String[] args) {

        String tableName="Stuedent_info";
        String[] colName={"name","age"};
        String[] colValue={"'liguodong'","15"};

        //generateInsertStatement(tableName, colName, colValue);

        List<String[]> list  = new ArrayList<String[]>();
        for (int i = 0; i < 10; i++) {
            list.add(colValue);
        }



        generateInsertStatement(tableName,colName,list);
    }




}
