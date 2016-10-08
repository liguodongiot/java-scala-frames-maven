package com.lgd.generate.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liguodong on 2016/10/8.
 */
public class ParseSqlStat {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(ParseSqlStat.class);


    /*
     CREATE TABLE `student_info` (
     `stu_name` varchar(255) DEFAULT NULL,
     `stu_age` int(11) DEFAULT NULL,
     `id` int(11) NOT NULL AUTO_INCREMENT,
     `stu_score` double(10,4) DEFAULT NULL,
     `stu_date` date DEFAULT NULL,
     PRIMARY KEY (`id`)
     ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
     */
    public static String[] parseCreateTableStat(String sql){

        String[] parseTableInfo = new String[3];

        String[] splitLine = sql.split("\n");

        //解析表名
        if(splitLine[0].contains("CREATE TABLE")){

            Pattern pattern = Pattern.compile("`(.*)`");
            Matcher matcher = pattern.matcher(splitLine[0]);

            if(matcher.find()){
                String tableName = matcher.group(1);
                LOGGER.info("Table Name : " + tableName);
                parseTableInfo[0] = tableName;
            }
        }else{
            try {
                throw new Exception("sql statements error!!!");
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }


        //解析字段名和字段类型
        StringBuilder colNameStr = new StringBuilder();
        StringBuilder colTypeStr = new StringBuilder();
        for (int i = 1; i < splitLine.length; i++) {

            if(splitLine[i].contains("AUTO_INCREMENT")){
                continue;
            }
            if(splitLine[i].contains("PRIMARY KEY")){
                break;
            }
            Pattern pattern = Pattern.compile("`(.*)` ([a-z]{1,})");
            Matcher matcher = pattern.matcher(splitLine[i]);
            if(matcher.find()){
                String colName = matcher.group(1);
                String colType = matcher.group(2);
                LOGGER.info("colName:"+colName+",colType:"+colType);
                colNameStr.append(colName).append(",");
                colTypeStr.append(colType).append(",");
            }

        }

        colNameStr.deleteCharAt(colNameStr.length()-1);
        colTypeStr.deleteCharAt(colTypeStr.length()-1);
        LOGGER.info("colNameStr:"+colNameStr);
        LOGGER.info("colTypeStr:"+colTypeStr);
        parseTableInfo[1] = colNameStr.toString();
        parseTableInfo[2] = colTypeStr.toString();

        return parseTableInfo;
    }


}
