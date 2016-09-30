package com.lgd.generate.sql;

import com.lgd.strs.StringFormatUtils;
import org.junit.Test;

/**
 * Created by liguodong on 2016/9/28.
 */
public class GenerateSqlUtilsTests {

//    String tableName="stuedent_info";
//    String[] colName={"name","age"};
//    String[] colValue={"'liguodong'","15"};

    //generateInsertStatement(tableName, colName, colValue);
    String tableName="score_store_stat_all";
    String colNameString = "stat_date,\n" +
            "visit_uv,\n" +
            "sign_uv,\n" +
            "sign_div_visit,\n" +
            "sign_score_mall_uv,\n" +
            "score_mall_div_sign,\n" +
            "new_uv_score,\n" +
            "new_percent_score,\n" +
            "new_morrow_retention_uv_score,\n" +
            "new_morrow_retention_rate_score,\n" +
            "morrow_retention_uv,\n" +
            "morrow_retention_rate,\n" +
            "seven_retention_uv,\n" +
            "seven_retention_rate,\n" +
            "center_uv,\n" +
            "center_score_uv,\n" +
            "center_socre_div_center,\n" +
            "new_uv_sign,\n" +
            "new_percent_sign,\n" +
            "new_morrow_uv_sign,\n" +
            "new_morrow_rate_sign\n";

    //String[] colName={"name","age"};

    //String[] colValue={"'liguodong'","15"};
    String colValueString = "";



    @Test
    public void test(){

        String[] colName = StringFormatUtils.strToArr(colNameString,",");
        //GenerateSqlUtils.generateInsertStatement(tableName, colName, colNameString);
    }


}
