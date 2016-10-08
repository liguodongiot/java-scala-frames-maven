package com.lgd.generate.sql;

import com.lgd.datatype.ObjectFormatUtils;
import com.lgd.random.GenerateRandomUtils;
import com.lgd.datatype.StringFormatUtils;
import com.lgd.vo.BaseVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liguodong on 2016/7/11.
 */
public class GenerateSqlUtils {

    private final static Logger LOGGER =
            LoggerFactory.getLogger(GenerateSqlUtils.class);

    private final static String BATCH_INSERT = "INSERT INTO `%s` (%s) VALUES";

    public static Map<String,Class<?>> mysqlJavaMap = new HashMap<String,Class<?>>();

    public static Map<Class<?>,String> mapMethod = new HashMap<Class<?> , String>();


    static {
        mysqlJavaMap.put("int",Integer.class);
        mysqlJavaMap.put("tinyint",Integer.class);
        mysqlJavaMap.put("smallint",Integer.class);
        mysqlJavaMap.put("mediumint",Integer.class);
        mysqlJavaMap.put("bigint",Integer.class);

        mysqlJavaMap.put("double",Double.class);
        mysqlJavaMap.put("float",Double.class);

        mysqlJavaMap.put("varchar",String.class);
        mysqlJavaMap.put("char",String.class);

        mysqlJavaMap.put("date",Date.class);



        mapMethod.put(Integer.class,"generateRandomInt");
        mapMethod.put(Double.class,"generateRandomDouble");
        mapMethod.put(String.class,"generateRandomStrInt");
        mapMethod.put(Date.class,"generateRandomDate");
    }



    public static String execute(String tableName,String colNameString,String colValueType){

        String[] colNameStrings = StringFormatUtils.strToArr(colNameString,",");
        String[] colValueTypes = StringFormatUtils.strToArr(colValueType,",");
        String[] colValueValues = new String[colValueTypes.length];

        LOGGER.info(colNameString);
        LOGGER.info(colValueType);

        for (int i = 0; i < colValueTypes.length; i++) {
            String methodName = mapMethod.get(mysqlJavaMap.get(colValueTypes[i]));
            LOGGER.info("methodName:"+methodName);
            GenerateRandomUtils generateRandomUtils = new GenerateRandomUtils();
            TypeFormat typeFormat = new TypeFormat(generateRandomUtils,methodName,10);
            colValueValues[i] = ObjectFormatUtils.objToStr(
                    typeFormat.getTypeFormatValue());

        }
        return generateInsertStatement(tableName,colNameStrings,colValueValues);
    }


    /**
     * 生成批量插入值
     * @param tableName  表名
     * @param colNameString  字段名
     * @param colValueType  字段类型
     * @param size  条数
     * @return
     */
    public static String executeBatchInsert(String tableName,String colNameString,String colValueType,int size){

        String[] colNameStrings = StringFormatUtils.strToArr(colNameString,",");
        String[] colValueTypes = StringFormatUtils.strToArr(colValueType,",");
        List<String[]> list = new ArrayList<String[]>(size);


        LOGGER.info("\n字段名：[\n"+colNameString+"]");
        LOGGER.info("\n字段类型：[\n"+colValueType+"]");

        for (int j = 0; j < size; j++) {
            String[] colValueValues = new String[colValueTypes.length];

            for (int i = 0; i < colValueTypes.length; i++) {
                String methodName = mapMethod.get(mysqlJavaMap.get(colValueTypes[i]));
                LOGGER.info("methodName:"+methodName);
                GenerateRandomUtils generateRandomUtils = new GenerateRandomUtils();
                TypeFormat typeFormat = new TypeFormat(generateRandomUtils,methodName,10);
                //生成随机值
                colValueValues[i] = ObjectFormatUtils.objToStr(
                        typeFormat.getTypeFormatValue());

            }

            list.add(colValueValues);
        }

        return generateBatchInsert(tableName,colNameStrings,list);
    }





    /**
     * 生成一条insert语句
     *
     * INSERT INTO table_name (列1, 列2,...) VALUES (值1, 值2,....)
     * @param tableName
     */
    public static String generateInsertStatement(String tableName,String[] colName,String[] colValue){

        String template = "INSERT INTO `%s` (%s) VALUES (%s);";

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

        //System.out.println(String.format(template, tableName, colNameStr.toString(), colValueStr.toString()));
        LOGGER.info("INSERT : " + String.format(template, tableName, colNameStr.toString(), colValueStr.toString()));
        return String.format(template, tableName, colNameStr.toString(), colValueStr.toString());
    }


    /**
     * 批量生成Insert语句  字符串数组
     * INSERT INTO users (name, age) VALUES('姚明', 25), ('比尔.盖茨', 50), ('火星人', 600);
     * @param tableName
     * @param colName
     * @param colValue
     */
    public static String generateBatchInsert(String tableName, String[] colName,List<String[]> colValue){

        StringBuilder colNameStr = new StringBuilder();
        StringBuilder batchInsert = new StringBuilder();

        //字段名
        for (int i = 0; i < colName.length; i++) {
            colNameStr.append(colName[i]);
            if(i!=colName.length-1){
                colNameStr.append(",");
            }
        }

        String batchInsertName = String.format(BATCH_INSERT, tableName, colNameStr.toString());
        LOGGER.info("batchInsertName : "+batchInsertName);
        batchInsert.append(batchInsertName);

        //字段值
        for (int j = 0; j < colValue.size(); j++) {
            String[] temp = colValue.get(j);
            batchInsert.append("(");
            for (int i = 0; i < temp.length; i++) {

                batchInsert.append(temp[i]);
                if(i!=temp.length-1){
                    batchInsert.append(",");
                }
            }
            batchInsert.append(")");

            if(j!=colValue.size()-1){
                batchInsert.append(",");
            }else{
                batchInsert.append(";");
            }
        }

        LOGGER.info("Batch Insert:[{}]",batchInsert);
        return batchInsert.toString();
    }




    /**
     * 批量插入实体
     *
     * @param tableName
     * @param colValue
     */

    public static void generateInsertStatementVo(String tableName, List<BaseVo> colValue){

        for (BaseVo tempVo:colValue){

            String voStr = parseVoString(tempVo.toString(),"BaseVo\\{(\\w+=.+)\\}");

            List<String[]> list = splitVoString(voStr);

            generateInsertStatement(tableName,list.get(0),list.get(1));
        }
    }



    private static List<String[]> splitVoString(String voStr){
        String[] strings = voStr.split(", ");
        String[] colName = new String[strings.length];
        String[] colValue = new String[strings.length];

        for (int i = 0; i < strings.length; i++) {
            String[] tempStr = strings[i].split("=");
            if(tempStr.length==2){
                colName[i] = tempStr[0];
                colValue[i] = tempStr[1];
            }else{
                continue;
            }
        }

        List<String[]> list = new ArrayList<String[]>(2);
        list.add(colName);
        list.add(colValue);
        return list;
    }

    private static String parseVoString(String OriginalStr,String regex){
        //表达式对象    分组1 分组2
        Pattern pattern = Pattern.compile(regex);

        //创建Matcher对象
        Matcher matcher = pattern.matcher(OriginalStr);//尝试将整个字符串序列与该模式匹配

        if(matcher.find())
        {
           return matcher.group(1);//group()与group(0)匹配整个表达式的子字符串
        }
        return "";
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


        //generateInsertStatement(tableName,colName,list);


        System.out.println(new BaseVo().toString());



        //BaseVo{(\w+=.+)}
        //BaseVo{name='null', age=0, price=0.0, discount=null}

        //parseVoString("BaseVo{name='null', age=0, price=0.0, discount=null}","BaseVo\\{(\\w+=.+)\\}");



        //插入实体
        List<BaseVo> listVo  = new ArrayList<BaseVo>();

//        for (int i = 0; i <4; i++) {
//            BaseVo baseVo = new BaseVo(GenerateRandomUtils.generateRandomStr(5),
//                    GenerateRandomUtils.generateRandomInt(100),
//                    GenerateRandomUtils.generateRandomDouble(200),
//                    GenerateRandomUtils.generateRandomFloat(1000));
//            listVo.add(baseVo);
//        }
//
//
//        generateInsertStatementVo("BaseVo", listVo);

    }




}
