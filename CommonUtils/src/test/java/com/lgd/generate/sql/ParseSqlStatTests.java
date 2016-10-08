package com.lgd.generate.sql;

import org.junit.Test;

/**
 * Created by liguodong on 2016/10/8.
 */
public class ParseSqlStatTests {

    String sql = "CREATE TABLE `student_info` (\n" +
            "  `stu_name` varchar(255) DEFAULT NULL,\n" +
            "  `stu_age` int(11) DEFAULT NULL,\n" +
            "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
            "  `stu_score` double(10,4) DEFAULT NULL,\n" +
            "  `stu_date` date DEFAULT NULL,\n" +
            "  PRIMARY KEY (`id`)\n" +
            ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;";


    @Test
     public void test(){
        String[] result = ParseSqlStat.parseCreateTableStat(sql);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }


        String insert = GenerateSqlUtils.executeBatchInsert(result[0],result[1],result[2],1000);

        System.out.println("insert : "+insert);
    }

}
